package com.example.jeffrey.academic.firebase_example.answer_and_qestion;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jeffrey.academic.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.Nullable;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnswerFragment extends Fragment implements Serializable {


    private FirebaseFirestore database ;
    private ArrayList<AnswerQestionClass>answerQestionClasses;
    private Context context;
    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_answer, container, false);


            loadDataBase();
            loadtheQestions();

        return view;
    }



    private void initRecyclerView(){

// TODO: 15/12/2018 איתחול של אובייקט מסוג recycelviev 
        // TODO: 15/12/2018 אשר תפקידו הוא להציג לנו כמות מידע מסויימת לפי תבנית שהגדרנו מראש 
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        layoutManager.setSmoothScrollbarEnabled(true);

        RecyclerView recyclerView = view.findViewById(R.id.recycelview);
        recyclerView.setLayoutManager(layoutManager);
        RecycelViewQestionAnswer adapter = new RecycelViewQestionAnswer(answerQestionClasses);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
        // TODO: 15/12/2018  זוהי המתודה הראשונה שנקראת לעבודה כאשר אנחנו נפעיל פרגמנט חדש ואנחנו בעצם נשתמש באובייקט context
        // TODO: 15/12/2018 על מנת לקשר את הפרגמנט שלנו אל הפעילות המכילה אותו
    }

    private void loadDataBase() {
        // TODO: 13/12/2018 מתודה שמאתחלת את האובייקט שלנו מסוג פיירבייס עם הגדרות נחוצות
        database = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        database.setFirestoreSettings(settings);

    }

    private void loadtheQestions() {
        new Thread(new Runnable() {
            @Override
            public void run() {





                        // TODO: 15/12/2018 כאן אנחנו ניגשים אל האוסף שקוראים לו studentqestions
                // TODO: 15/12/2018 ולוקחים את כל השאלות שנשאלו וטוענים אותם אל תוך אובייקט מסוג מחלקת תשובות שזוהי מחלקה שיצרתי והיא מייצגת לי אוייבקט של שאלה ותשובה
                answerQestionClasses=new ArrayList<>();
                database.collection("studentqestions").document("sf").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                    }
                });
                database.collection("studentqestions").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (int i = 0; i <task.getResult().getDocuments().size() ; i++) {
                        answerQestionClasses.add(task.getResult().getDocuments().get(i).toObject(AnswerQestionClass.class));
                    }
                        initRecyclerView();
                    }
                });
            }
        }).start();
    }


}
