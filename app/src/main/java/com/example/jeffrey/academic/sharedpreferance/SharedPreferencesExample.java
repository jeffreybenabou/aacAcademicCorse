package com.example.jeffrey.academic.sharedpreferance;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jeffrey.academic.R;

public class SharedPreferencesExample extends AppCompatActivity {

    private Button  saveTheCounter;
    private TextView textView;
    private SharedPreferences SPSaveTheCounter;
    private SharedPreferences.Editor SPEditor;
    private int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        setTheSharedPreferences();
        setTheTextView();
        defineTheButton();

    }

    private void setTheSharedPreferences() {
        SPSaveTheCounter=getSharedPreferences("type",MODE_PRIVATE);
    }

    private void setTheTextView() {
        textView=findViewById(R.id.text_view_counter);
        textView.setText(""+SPSaveTheCounter.getInt("counter",counter));
        counter=SPSaveTheCounter.getInt("counter",counter);

    }


    private void defineTheButton() {

        saveTheCounter =findViewById(R.id.save_image_button);
        saveTheCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                saveTheCounter();
                textView.setText(""+SPSaveTheCounter.getInt("counter",counter));

            }
        });
    }

    private void saveTheCounter() {
        SPEditor=SPSaveTheCounter.edit();
        SPEditor.putInt("counter", counter);
        SPEditor.apply();


    }

}
