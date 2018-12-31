package com.example.jeffrey.academic.thread.ui_thread_example;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeffrey.academic.R;

import java.util.Random;

public class UIThreadExample extends AppCompatActivity {

    private Button startColorChange,stopColorChange;
    private Thread thread;
    private TextView colorChange;
    private boolean isRunning =false;
    private int counter=0;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_thread);
        colorChange =findViewById(R.id.text_view_to_change_color);
        setTheButton();
        // TODO: 06/12/2018 הגדרה של אובייקט מסוג טוסט
        toast=Toast.makeText(this, "", Toast.LENGTH_LONG);


    }

    @Override
    protected void onPause() {
        super.onPause();
        // TODO: 06/12/2018  סיום פעילות הטוסט שלנו ויציאה מהלולאה בכך שמשנים את התנאי לfalse
        toast.cancel();
        isRunning=false;
    }

    private void setTheThread() {
        // TODO: 06/12/2018 בכל פעם שנקרא למתודה הזו התהליכון יאותחל לנו משורת הקוד הראשונה על מנת שנוכל להפעיל את התהליכון שלנו מספר פעמים ככל שנרצה
        thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRunning) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // TODO: 06/12/2018 כאן אנחנו רצים על התהליך הראשי כי יש גישה לרכיב כלשהוא
                            changeColor();
                        }
                    });

                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                counter=0;
            }

        });

        thread.start();


    }

    private void changeColor() {
        // TODO: 06/12/2018 כאן נשנה את הצבעים בצורה רנדומלית-בגלל שהגבול של הצבעים הוא עד 255 אז נרצה להגביל את הטווח שלנו
        Random random = new Random();
        colorChange.setBackgroundColor(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        colorChange.setTextColor(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        counter++;
        popToast(" "+counter+" צבעים שונו ");
    }

    private void setTheButton() {




        stopColorChange=findViewById(R.id.stop_color_change);
        stopColorChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startColorChange.setEnabled(true);
                stopColorChange.setEnabled(false);
                isRunning=false;
                popToast("החלפת צבעים הופסקה");

            }
        });

        startColorChange =findViewById(R.id.start_color_change);
        startColorChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isRunning=true;
                startColorChange.setEnabled(false);
                stopColorChange.setEnabled(true);

                setTheThread();


            }
        });
    }

    private void popToast(String message) {
        toast.setText(message);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();

    }
}
