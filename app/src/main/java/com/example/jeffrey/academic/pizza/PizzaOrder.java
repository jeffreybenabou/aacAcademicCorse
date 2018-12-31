package com.example.jeffrey.academic.pizza;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeffrey.academic.R;

import java.util.ArrayList;

public class PizzaOrder extends AppCompatActivity {
    private ArrayList<Drawable> images;
    private ImageView pizzaImage;
    private TextView sumToShow;
    private int sum=0;
    private int sumOfAddOn=0;
    private RadioGroup radioGroup;
    private Button sendTheOrder;
    private ArrayList<String>string;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_order);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 10);
        }
        name=getIntent().getExtras().getString("name");
        string=new ArrayList<>();
        sumToShow=findViewById(R.id.sum_to_show);
        popToast("ברוך הבא "+name);

        addArrayListImages();
        setTheImageThread();
        checkTheRadioGroup();
        setTheButtonOrder();

    }

    private void setTheButtonOrder() {
        sendTheOrder=findViewById(R.id.order);
        sendTheOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popToast("הפיצה בהכנה ,שליח יגיע  לכתובת :"+getIntent().getExtras().get("address")+System.getProperty("line.separator")+".בתאבון");

                setTheSmsSend();



            }
        });
    }

    private void setTheSmsSend() {
        SmsManager smsManager = SmsManager.getDefault();
        if (ActivityCompat.checkSelfPermission(PizzaOrder.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED)

        {
            String text2="שיהיה בתאבון !";
            StringBuilder addOn= new StringBuilder();
            String text="הפיצה שהזמנת בדרך אלייך ! עם התוספות :";
            for (int i = 0; i <string.size() ; i++) {
                addOn.append(string.get(i)).append(",");
            }
            ArrayList<String>send=smsManager.divideMessage(text+addOn+text2+name+sumToShow.getText().toString());




            smsManager.sendMultipartTextMessage(getIntent().getExtras().getString("phone"), null, send, null, null);



           startActivity(new Intent(PizzaOrder.this,PizzaOrder.class).putExtra("name",name).putExtra("address",getIntent().getExtras().getString("address")).putExtra("phone",getIntent().getExtras().getString("phone")));

           finish();
        }
    }

    private void popToast(String text)
    {
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();

    }

    private void checkTheRadioGroup() {
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.big_pizza:
                        sum = 55;

                        break;
                    case R.id.small_pizza:
                        sum = 15;
                        break;
                    case R.id.normal_pizza:
                        sum = 35;
                        break;
                }
                setTheText();
            }
        });
    }

    private void setTheImageThread() {
        final Animation in  = AnimationUtils.loadAnimation(this, R.anim.anima);


        pizzaImage=findViewById(R.id.pizza_image);
        pizzaImage.setAnimation(in);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                {

                    for (int i = 0; i <images.size() ; i++) {
                        try {
                            try {
                                Thread.sleep(4000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            final int finalI = i;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    pizzaImage.setImageDrawable(images.get(finalI));

                                }
                            });
                            Thread.sleep(4000);



                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    pizzaImage.startAnimation(in);
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }).start();



    }

    private void addArrayListImages() {
        images=new ArrayList<>();
        images.add(getDrawable(R.drawable.pizza1));
        images.add(getDrawable(R.drawable.pizza2));
        images.add(getDrawable(R.drawable.pizza3));
    }

    public void addSumOfAddOn(View view)
    {

        CheckBox checkBox=(CheckBox)view;
        if(checkBox.isChecked())
        {
            string.add(checkBox.getText().toString());
            sumOfAddOn+=2;
        }

        else
        {
            string.remove(checkBox.getText().toString());
            sumOfAddOn-=2;
        }

        setTheText();
    }

    private void setTheText(){

        sumToShow.setText("סכום כולל לתשלום :"+(sum+sumOfAddOn)+"$");
    }
}
