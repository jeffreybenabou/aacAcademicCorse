package com.example.jeffrey.academic.thread.thread_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeffrey.academic.R;

public class ThreadExampleA extends AppCompatActivity {

    private TextView textView;
    private Thread thread;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_example);
        textView = findViewById(R.id.seconde_to_count);
        setTheButtonToStart();
        setTheThread();
    }

    private void setTheButtonToStart() {
        ImageButton button=findViewById(R.id.start_counter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!thread.isAlive())
                {
                    setTheThread();
                    thread.start();
                }
                else
                    Toast.makeText(ThreadExampleA.this,"תהליכון כבר פעיל המתן לסיום",Toast.LENGTH_LONG).show();

            }
        });
    }

    private void setTheThread() {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ThreadExampleA.this,"תהליכון רץ",Toast.LENGTH_LONG).show();

                    }
                });
                while (true) {

                    runOnUiThread(new Thread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("" + counter++);
                        }
                    }));

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(counter>10)
                        break;
                }
                counter=0;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ThreadExampleA.this,"תהליכון הסתיים",Toast.LENGTH_LONG).show();

                    }
                });

            }
        });




    }
}
