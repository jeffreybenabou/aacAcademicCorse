package com.example.jeffrey.academic.final_assignment_first_semester;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jeffrey.academic.R;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private ArrayList<EditText>editTexts;
    private Button sendData;
    private boolean dataOk;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loadTheComponent();
        checkTheSheardPrefarance();

        setTheOnClick();
    }

    private void checkTheSheardPrefarance() {
        if(sharedPreferences.contains("userName"))
            goToNextActivity();
    }

    private void setTheOnClick() {
        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkData();
                if(dataOk)
                {
                    saveDataToSharedPreference();
                    goToNextActivity();
                }
            }
        });
    }

    private void saveDataToSharedPreference() {
        sharedPreferences.edit().putString("userName",editTexts.get(0).getText().toString()).apply();
    }

    private void goToNextActivity() {
        Intent intent=new Intent(this,ItemsActivity.class);
        intent.putExtra("userName",sharedPreferences.getString("userName",""));
        startActivity(intent);
        finish();
    }

    private void checkData() {
        dataOk=true;
        for (EditText e :editTexts) {
            if(e.getText().toString().isEmpty())
            {
                e.setError("יש להכניס "+e.getHint().toString());
                dataOk=false;
            }
            else
                e.setError(null);
        }
    }

    private void loadTheComponent() {
        sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
        EditText userName = findViewById(R.id.user_name_in_end_semester);
        EditText password = findViewById(R.id.password_in_end_semster);
        EditText firstName = findViewById(R.id.first_name_in_end_semester);
        sendData=findViewById(R.id.sign_in_inside_end_semester);
        editTexts=new ArrayList<>();
        editTexts.add(userName);
        editTexts.add(password);
        editTexts.add(firstName);
    }
}
