package com.example.jeffrey.academic.firebase_example;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.jeffrey.academic.firebase_example.firebase_users_data_add_data_change.FireBaseExmaple;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Collections;
import java.util.List;

public class FireBaseInit  {

    public static FireBaseInit fireBaseInit = null;
    public FirebaseUser user;

    public List<AuthUI.IdpConfig> providers = Collections.singletonList(

            new AuthUI.IdpConfig.GoogleBuilder().build());
    public FirebaseStorage storage;

    public StorageReference storageRef;
    public FirebaseFirestore database;
    private Context context;


    private FireBaseInit(Context context){
        this.context=context;

        defineTheFireBaseDataBase();
        defineTheFireBaseUser();
        defineTheStorageReferance();
    }

    private void defineTheStorageReferance() {
        storage = FirebaseStorage.getInstance();
        storageRef=storage.getReference();
    }

    private void defineTheFireBaseUser() {
        user= FirebaseAuth.getInstance().getCurrentUser();
    }

    private void defineTheFireBaseDataBase() {
            // TODO: 13/12/2018 מתודה שמאתחלת את האובייקט שלנו מסוג פיירבייס עם הגדרות נחוצות
            database = FirebaseFirestore.getInstance();
            FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                    .setTimestampsInSnapshotsEnabled(true)
                    .build();
            database.setFirestoreSettings(settings);


    }



    public static FireBaseInit getInstance(Context context)
    {
        if (fireBaseInit == null)
            fireBaseInit = new FireBaseInit(context);

        return fireBaseInit;
    }


}
