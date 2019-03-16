package com.example.jeffrey.academic.fragment_example.transfer_data_between_fragmant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jeffrey.academic.R;

public class DataHandlerActivity extends AppCompatActivity implements TopFragmant.TopFragmantLiseners {

    // TODO: 05/12/2018 נממשק את הממשק שבנינו בפרגמנט שלנו דרך המחלקה עם המילה implement
    BottomFragmant bottomFragmant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_handler);
        bottomFragmant= (BottomFragmant) getSupportFragmentManager().findFragmentById(R.id.fragment3);
    }


    // TODO: 05/12/2018 פה אנחנו דורסים את המתודה של הממשק וזה הדרך תקשור שלנו בין פרגמנטים
    @Override
    public void whichComponentIsChecked(boolean name, boolean lastName, boolean location, boolean image) {
        bottomFragmant.showComponent(name,lastName,location,image);
    }


}
