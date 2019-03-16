package com.example.jeffrey.academic.final_assignment_first_semester;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import com.example.jeffrey.academic.R;
import com.example.jeffrey.academic.recycler_view.RecyclerViewExample;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setTheThread();
    }

    private void setTheThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }




}
