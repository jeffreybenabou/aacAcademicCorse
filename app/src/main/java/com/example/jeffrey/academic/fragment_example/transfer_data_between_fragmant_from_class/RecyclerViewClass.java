package com.example.jeffrey.academic.fragment_example.transfer_data_between_fragmant_from_class;

import android.content.Context;
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

public class RecyclerViewClass extends android.support.v7.widget.RecyclerView.Adapter<RecyclerViewClass.ViewHolder> {

    //todo מערך שישמור לנו את כל שמות המשתמשים ונשתמש בו גם על מנת לתת גודל מסויים לרייסיקל ויו
    private ArrayList<UserNameExample>allUsers;

    public RecyclerViewClass(ArrayList<UserNameExample>allUsers){
        this.allUsers=allUsers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_example,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        
        viewHolder.area.setText(allUsers.get(i).getFirstName());
        viewHolder.name.setText(allUsers.get(i).getLastName());
        viewHolder.number.setText(allUsers.get(i).getPhoneNumber());

    }

    @Override
    public int getItemCount() {
        return allUsers.size();
    }


    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {

        public TextView name,number,area;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name_of_user_recyclerview_example);
            number=itemView.findViewById(R.id.number_of_user_recyclerview_example);
            area=itemView.findViewById(R.id.area_of_user_recyclerview_example);
        }
    }


}
