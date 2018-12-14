package com.example.jeffrey.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.jeffrey.test.ExampleClassWork.pizza.PizzaActivity;
import com.example.jeffrey.test.FireBase.FireBaseInit;
import com.example.jeffrey.test.Fragmant.navegation_fragmant.navigation_fragmant.FragmentManagerActivity;
import com.example.jeffrey.test.Fragmant.navegation_fragmant.rating_fragmant.RatingActivity;
import com.example.jeffrey.test.Fragmant.navegation_fragmant.transfer_data_between_fragmant.DataHandlerActivity;
import com.example.jeffrey.test.activity_data_send.secondExercise.FirstActivity;
import com.example.jeffrey.test.impliciti_intent_example.ImplicitIntentExample;
import com.example.jeffrey.test.notification.NotificationExample;
import com.example.jeffrey.test.product_example.Product;
import com.example.jeffrey.test.sharedpreferance.SharedColorSave;
import com.example.jeffrey.test.sharedpreferance.SharedPreferencesExample;
import com.example.jeffrey.test.thread.ThreadExample.ThreadExampleA;
import com.example.jeffrey.test.thread.UIThreadExample.UIThreadExample;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


    }

    public void setTheButtons(View view) {

        switch (view.getId())
        {
            case R.id.implicit:
                startActivity(new Intent(MainActivity.this,ImplicitIntentExample.class));
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
                startActivity(new Intent(MainActivity.this,FireBaseInit.class));
                break;


        }











    }





}
