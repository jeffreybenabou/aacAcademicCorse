package com.example.jeffrey.academic.sharedpreferance;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jeffrey.academic.R;

public class SharedColorSave extends AppCompatActivity {

    private Button red, green, blue, load, delete;
    private SharedPreferences colorSharedPreferences;
    private SharedPreferences.Editor editor;
    private View save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_color_save);
        setTheColorSharedPreferences();
        setTheButton();


    }

    private void setTheButton() {
        delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.apply();

                createToast("קובץ העדפות הוסר בהצלחה");
            }
        });
        red = findViewById(R.id.red);
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                red.setBackgroundColor(Color.RED);
            }
        });
        green = findViewById(R.id.green);
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                green.setBackgroundColor(Color.GREEN);
            }
        });
        blue = findViewById(R.id.blue);
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                blue.setBackgroundColor(Color.BLUE);
            }
        });
        load = findViewById(R.id.load_color);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (colorSharedPreferences.contains("exist")) {
                    red.setBackgroundColor(colorSharedPreferences.getInt("red", Color.BLACK));
                    green.setBackgroundColor(colorSharedPreferences.getInt("green", Color.BLACK));
                    blue.setBackgroundColor(colorSharedPreferences.getInt("blue", Color.BLACK));

                } else
                    createToast("קובץ העדפות לא קיים-צבעים לא נשמרו עדיין.");

            }
        });
        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTheData();
            }
        });

    }

    private void saveTheData() {

        editor.putInt("blue", Color.BLUE);
        editor.putInt("red", Color.RED);
        editor.putInt("green", Color.GREEN);
        editor.putBoolean("exist", true);
        editor.apply();
        createToast("צבעים נשמרו בהצלחה");

    }

    private void setTheColorSharedPreferences() {
        colorSharedPreferences = getSharedPreferences("color", MODE_PRIVATE);
        editor = colorSharedPreferences.edit();
        editor.apply();
    }

    private void createToast(String text) {
        Toast.makeText(SharedColorSave.this, text, Toast.LENGTH_LONG).show();

    }
}
