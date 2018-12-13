package com.example.jeffrey.test.FireBase;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jeffrey.test.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

/**
 * A simple {@link Fragment} subclass.
 */
public class QestionFragment extends Fragment {


    private View view;
    private FirebaseFirestore database ;
    private Context context;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_qestion, container, false);
        loadDataBase();
        setButtonLiseners();
        return view;
    }

    private void loadDataBase() {
        // TODO: 13/12/2018 מתודה שמאתחלת את האובייקט שלנו מסוג פיירבייס עם הגדרות נחוצות
        database = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        database.setFirestoreSettings(settings);

    }


    private void setButtonLiseners() {
        // TODO: 13/12/2018 איתחול של כפתור שבעת לחיצה עליו נשלח את השאלה שלנו אל השרת
        Button button=view.findViewById(R.id.send_me_qestion_firebase);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText text = view.findViewById(R.id.qestion_to_send_firebase);


                database.collection("studentqestions").add(new AnswerQestionClass("ממתין לתשובה",text.getText().toString(),false)).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Toast.makeText(context,"שאלה נוספה אל מאגר השאלות.",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }
}
