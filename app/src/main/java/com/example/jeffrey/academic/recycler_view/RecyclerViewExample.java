package com.example.jeffrey.academic.recycler_view;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jeffrey.academic.R;
import com.example.jeffrey.academic.firebase_example.FireBaseInit;
import com.example.jeffrey.academic.firebase_example.add_new_user_to_database.UserNameClass;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class RecyclerViewExample  extends RecyclerView.Adapter<RecyclerViewExample.ViewHolder> {

    //todo מערך שישמור לנו את כל שמות המשתמשים ונשתמש בו גם על מנת לתת גודל מסויים לרייסיקל ויו
    private ArrayList<UserNameClass>allUsersOnFireBase;


    public RecyclerViewExample(Context context){
        allUsersOnFireBase=new ArrayList<>();
        FireBaseInit.getInstance(context).getDatabase().collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for (int i = 0; i <task.getResult().getDocuments().size() ; i++) {
                    allUsersOnFireBase.add(task.getResult().getDocuments().get(i).toObject(UserNameClass.class));
                    notifyItemChanged(i);
                }
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View  view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_example,viewGroup,false);

        /// TODO: 10/02/2019   תפקיד המתודה הזו היא להגדיר לנו את תבנית העיצוב שתשמש אותנו לייצוג נתונים של אובייקט כלשהוא
        // TODO: 10/02/2019 יש לבנות תבנית עיצוב כלשהיא שתייצג לנו א האובייקט שנרצה להציג
        // TODO: 12/02/2019 במקרה הזה תבנית העיצוב שמייצגת היא התבנית הבאה:
        // TODO: 12/02/2019     R.layout.recycler_view_example
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i)
    {
        // TODO: 12/02/2019 מתודה זו תפקידה היא להכיל את המידע מתוך ייצוג נתונים כלשהוא אל תוך תבנית העיצוב
        // TODO: 12/02/2019 במקרה הזה ייצוג הנתונים הוא מערך שלוקח מידע מתוך שרת ושומר אותו במערך
        viewHolder.area.setText(allUsersOnFireBase.get(i).getArea());
        viewHolder.name.setText(allUsersOnFireBase.get(i).getName());
        viewHolder.number.setText(allUsersOnFireBase.get(i).getPhone());
        FireBaseInit.getFireBaseInit().getStorageRef().child(allUsersOnFireBase.get(i).getImagesRefPath()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(viewHolder.imageView).load(uri)
                        .thumbnail(Glide.with(viewHolder.imageView).load(R.drawable.mygif))
                        .into(viewHolder.imageView);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allUsersOnFireBase.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name,number,area;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name_of_user_recyclerview_example);
            number=itemView.findViewById(R.id.number_of_user_recyclerview_example);
            area=itemView.findViewById(R.id.area_of_user_recyclerview_example);
            imageView=itemView.findViewById(R.id.image_of_user_recyclerview_example);
        }
    }


}
