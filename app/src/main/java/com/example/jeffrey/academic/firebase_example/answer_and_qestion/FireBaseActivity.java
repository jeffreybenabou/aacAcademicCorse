package com.example.jeffrey.academic.firebase_example.answer_and_qestion;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.jeffrey.academic.R;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

public class FireBaseActivity extends AppCompatActivity {


    // TODO: 13/12/2018 אובייקט שישמש אותנו על מנת לגשת אל מסד הנתונים שלנו

    private FirebaseFirestore database ;
    private AnswerFragment answerFragment;
    private QestionFragment qestionFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base_init);
        answerFragment=new AnswerFragment();
        qestionFragment=new QestionFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fire_base_fragment_to_change,qestionFragment).commit();

        loadDataBase();
        setTheFragmentSwitch();

    }

    private void setTheFragmentSwitch() {
        BottomNavigationView bottomNavigationView=findViewById(R.id.fire_base_qestion_answer_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (item.getItemId())
                {
                    case R.id.choose_answer_fragmant_menu:
                        transaction.replace(R.id.fire_base_fragment_to_change,answerFragment).commit();

                        break;
                    case R.id.choose_qestion_fragmant_menu:
                        transaction.replace(R.id.fire_base_fragment_to_change,qestionFragment).commit();

                        break;
                }

                return true;
            }
        });
    }



    private void loadDataBase() {
        // TODO: 13/12/2018 מתודה שמאתחלת את האובייקט שלנו מסוג פיירבייס עם ברירת מחדל
        //  TODO:שמאפשרת למשתמש לשמור נתונים ולראות אותם
        // TODO: 03/01/2019 גם כאשר אין למשתמש חיבור לאינטרנט

        database = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        database.setFirestoreSettings(settings);

    }

}


