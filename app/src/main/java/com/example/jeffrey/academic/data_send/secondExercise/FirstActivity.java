package com.example.jeffrey.academic.data_send.secondExercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jeffrey.academic.R;

public class FirstActivity extends AppCompatActivity {

    private EditText receiveTheUserName, receiveTheAgeOfUser;
    private String age;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        setTheEditText();
        defineTheButtonAction();


    }

    private void setTheEditText() {
        receiveTheUserName=findViewById(R.id.name_of_user);
        receiveTheAgeOfUser=findViewById(R.id.age);
    }

    private void setTheData() {
        age=receiveTheAgeOfUser.getText().toString();
        name=receiveTheUserName.getText().toString();
    }

    private void defineTheButtonAction() {
        Button nextActivity = findViewById(R.id.lessonNumber2_button);
        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startTheShowDataActivity();




            }
        });
    }

    private void startTheShowDataActivity() {
        if (checkUserNameAndAge()) {
            setTheData();
            Intent intent = new Intent(FirstActivity.this, ShowData.class);
            intent.putExtra("name", name);
            intent.putExtra("age", age);
            startActivity(intent);
        }
    }

    private boolean checkUserNameAndAge() {
        if (receiveTheAgeOfUser.getText().length() == 0) {
            receiveTheAgeOfUser.setError("הכנס שם משתמש");

        }
        if (receiveTheUserName.getText().length() == 0) {
            receiveTheUserName.setError("הכנס גיל");
        }
        return receiveTheUserName.getText().toString().length() > 0 && receiveTheAgeOfUser.getText().toString().length() > 0;
    }
}
