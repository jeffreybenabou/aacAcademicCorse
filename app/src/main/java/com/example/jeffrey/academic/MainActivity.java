package com.example.jeffrey.academic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.jeffrey.academic.data_send.secondExercise.FirstActivity;
import com.example.jeffrey.academic.firebase_example.FireBaseInit;
import com.example.jeffrey.academic.firebase_example.add_new_user_to_database.GetUserNameDetails;
import com.example.jeffrey.academic.firebase_example.answer_and_qestion.FireBaseActivity;
import com.example.jeffrey.academic.firebase_example.firebase_users_data_add_data_change.FireBaseExmaple;
import com.example.jeffrey.academic.fragment_example.navigation_fragmant.FragmentManagerActivity;
import com.example.jeffrey.academic.fragment_example.rating_fragmant.RatingActivity;
import com.example.jeffrey.academic.fragment_example.transfer_data_between_fragmant.DataHandlerActivity;
import com.example.jeffrey.academic.impliciti_intent_example.ImplicitIntentExample;
import com.example.jeffrey.academic.notification.NotificationExample;
import com.example.jeffrey.academic.pizza.PizzaActivity;
import com.example.jeffrey.academic.product_example.Product;
import com.example.jeffrey.academic.sharedpreferance.SharedColorSave;
import com.example.jeffrey.academic.sharedpreferance.SharedPreferencesExample;
import com.example.jeffrey.academic.thread.thread_example.ThreadExampleA;
import com.example.jeffrey.academic.thread.ui_thread_example.UIThreadExample;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        FireBaseInit.getInstance(this);


    }

    public void setTheButtons(View view) {

        switch (view.getId())
        {
            case R.id.implicit:
                startActivity(new Intent(MainActivity.this,ImplicitIntentExample.class));
                break;
            case R.id.firebase_add_user_to_data_base:
                startActivity(new Intent(MainActivity.this,GetUserNameDetails.class));
                break;
            case R.id.second_class:
                startActivity(new Intent(MainActivity.this,FirstActivity.class));
                break;
            case R.id.third_class:
                startActivity(new Intent(MainActivity.this,Product.class));
                break;
            case R.id.four1_class:
                startActivity(new Intent(MainActivity.this,SharedColorSave.class));
                break;
            case R.id.four2_class:
                startActivity(new Intent(MainActivity.this,SharedPreferencesExample.class));
                break;
            case R.id.five1_class:
                startActivity(new Intent(MainActivity.this,ThreadExampleA.class));
                break;
            case R.id.five2_class:
                startActivity(new Intent(MainActivity.this,UIThreadExample.class));
                break;

            case R.id.pizza:
                startActivity(new Intent(MainActivity.this,PizzaActivity.class));
                break;
            case R.id.notification:
                startActivity(new Intent(MainActivity.this,NotificationExample.class));
                break;
            case R.id.fragmant_active:
                startActivity(new Intent(MainActivity.this,FragmentManagerActivity.class));
                break;
            case R.id.fragmant_data_transpert:
                startActivity(new Intent(MainActivity.this,DataHandlerActivity.class));
                break;
            case R.id.fragmant_example_1:
                startActivity(new Intent(MainActivity.this,RatingActivity.class));
                break;
            case R.id.askQestion:
                startActivity(new Intent(MainActivity.this,FireBaseActivity.class));
                break;
            case R.id.firebase_change_data:
                startActivity(new Intent(MainActivity.this,FireBaseExmaple.class));
                break;


        }

    }


}
