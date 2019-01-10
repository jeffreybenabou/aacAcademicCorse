package com.example.jeffrey.academic.firebase_example.add_new_user_to_database;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Movie;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.jeffrey.academic.MainActivity;
import com.example.jeffrey.academic.R;
import com.example.jeffrey.academic.firebase_example.FireBaseInit;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.core.SnapshotHolder;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.annotation.Nullable;

import retrofit2.http.Url;

public class UserNameClass {

    private String name;
    private String phone;
    private String area;


    // TODO: 10/01/2019 שומר את נתיב התמונה שלנו בשרת
    private String imagesRefPath;


    public UserNameClass() {

        // TODO: 10/01/2019 על מנת לשמור או לטעון נתונים מהפיירבייס ואליו חובה למממש בנאי שהוא ריק
    }


    public UserNameClass(String name, String phone,String area,String referance) {
        this.name = name;
        this.phone = phone;
        this.area=area;
        imagesRefPath=referance;
    }






    public void getImageFromServer( final ImageView imageView){

        /// TODO: 10/01/2019 מתודה שמופעלת לאחר ששמרנו נתונים בשרת

        // TODO: 10/01/2019 גישה אל התמונה שלנו בשרת דרך הנתיב
        FireBaseInit.fireBaseInit.storageRef.child(imagesRefPath).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {

                // TODO: 10/01/2019 שימוש בספרייה חיצונית שטוענת את הקישור אל תוך אובייקט מסוג אימגווי
                // TODO: 10/01/2019    יש שימוש בגיפ שיוצג כרקע התמונה כל עוד התמונה לא נטענה
                Glide.with(imageView).load(uri)
                        .thumbnail(Glide.with(imageView).load(R.drawable.mygif))
                        .into(imageView);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });

    }



    public void putImageInServerWithInputStream(final Activity context, Uri imagePath) {

        // TODO: 10/01/2019 טעינת תמונה אל השרת באמצעות נתיב התמונה שבחרנו
        StorageReference imagesRef = FireBaseInit.fireBaseInit.storageRef.child(imagesRefPath);
        Bitmap bitmap = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), imagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();


        UploadTask uploadTask = imagesRef.putBytes(data);
        setTheUploadTaskLiseners(context,uploadTask);

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(context,"פעולה לא הצליחה",Toast.LENGTH_SHORT).show();

            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                Toast.makeText(context,"פעולה  הצליחה",Toast.LENGTH_SHORT).show();
                moveToNextActivity(context);
            }
        });

    }

    private void setTheUploadTaskLiseners(final Activity context, UploadTask uploadTask) {
        // TODO: 10/01/2019 מאזין לשינויים של העלאת הקובץ ומעדכן את המד ההתקדמות שלנו בהתאם
        uploadTask.addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                setTheProgressBar(context,taskSnapshot.getTotalByteCount(),taskSnapshot.getBytesTransferred());
            }
        });
    }

    private void setTheProgressBar(Activity context, long total, long progress) {
        ProgressBar progressBar=context.findViewById(R.id.image_progressbar);
        progressBar.setMax((int) total);
        progressBar.setProgress((int) progress);


    }

    private void moveToNextActivity(Activity context) {
        context.finish();
        context.startActivity(new Intent(context,ShowUsersOnFireBase.class));
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getImagesRefPath() {
        return imagesRefPath;
    }

    public void setImagesRefPath(String imagesRefPath) {
        this.imagesRefPath = imagesRefPath;
    }
}
