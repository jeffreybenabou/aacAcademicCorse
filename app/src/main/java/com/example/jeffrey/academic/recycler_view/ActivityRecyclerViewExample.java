package com.example.jeffrey.academic.recycler_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jeffrey.academic.R;
import com.example.jeffrey.academic.firebase_example.answer_and_qestion.RecycelViewQestionAnswer;

public class ActivityRecyclerViewExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_example2);
        initRecyclerView();
    }

    private void initRecyclerView(){

// TODO: 15/12/2018 איתחול של אובייקט מסוג recycelviev
        // TODO: 15/12/2018 אשר תפקידו הוא להציג לנו כמות מידע מסויימת לפי תבנית שהגדרנו מראש
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager.setSmoothScrollbarEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_example);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewExample adapter = new RecyclerViewExample(this);
        recyclerView.setAdapter(adapter);
    }
}
