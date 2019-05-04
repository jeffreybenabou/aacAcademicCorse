package com.example.jeffrey.academic.firebase_example.add_new_user_to_database;

import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.jeffrey.academic.R;
import com.example.jeffrey.academic.firebase_example.FireBaseInit;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ShowUsersOnFireBase extends AppCompatActivity {


    private ArrayList<String> arraySpinner;
    private ArrayList<UserNameClass> allUserNames;
    private Spinner spinner;

    // TODO: 10/01/2019 בעזרת הפריסה הזו נוכל לבצע עידכון ללייאוט
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_users_on_fire_base);
        setTheRefreshMethod();
        defineTheSpinner();


    }

    private void setTheRefreshMethod() {

        swipeRefreshLayout = findViewById(R.id.swiper);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // TODO: 10/01/2019 (מאזין שנכנס לפעולה כאשר משתמש מצבע רענון לדף(כמו אינסטגרם שמושכים עם האצבע למטה
                setTheSpinnerItemsFromServer();

            }
        });


    }

    private void defineTheSpinner() {
        setTheSpinnerItemsFromServer();
        setTheSpinnerLiseners();

    }

    private void setTheSpinnerItemsFromServer() {
        // TODO: 10/01/2019 טוען אל תוך התיבה הנפתחת את שמות המשתמשים שלנו שקיימים במאגר נתונים
        FireBaseInit.getFireBaseInit().getDatabase().collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                arraySpinner = new ArrayList<>();
                allUserNames = new ArrayList<>();
                for (int i = 0; i < task.getResult().getDocuments().size(); i++) {
                    UserNameClass userNameClass = task.getResult().getDocuments().get(i).toObject(UserNameClass.class);
                    arraySpinner.add(userNameClass.getName());
                    allUserNames.add(userNameClass);
                }

                // TODO: 10/01/2019 טעינת ערכים אל תוך מתאם שהתביה תשתמש בה
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(ShowUsersOnFireBase.this,
                        android.R.layout.simple_spinner_item, arraySpinner);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

                // TODO: 10/01/2019 מעלים את אייקון הטעינה שנוסף לאחר בקשת רענון
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void setTheSpinnerLiseners() {
        // TODO: 10/01/2019 בודק איזה ערך נלחץ בתיבה ומביא ערכים בהתאם
        spinner = findViewById(R.id.spinner_names_of_users);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                setTheData(allUserNames.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setTheData(UserNameClass userNameClass) {
        TextView name, number, area;
        ImageView imageView;
        imageView = findViewById(R.id.image_of_user_in_show_the_users);
        name = findViewById(R.id.user_name_in_show_users);
        area = findViewById(R.id.area_in_show_users);
        number = findViewById(R.id.phone_in_show_users);
        name.setText(userNameClass.getName());
        area.setText(userNameClass.getArea());
        number.setText(userNameClass.getPhone());
        userNameClass.getImageFromServer(imageView);
    }





}











