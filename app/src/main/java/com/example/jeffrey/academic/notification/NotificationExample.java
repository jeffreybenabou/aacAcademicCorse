package com.example.jeffrey.academic.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jeffrey.academic.R;

public class NotificationExample extends AppCompatActivity {

    private NotificationManagerCompat notificationManagerCompat;
    private EditText title,message;
    public static String channelNewItem="sport",channelNewItem2="nati";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_example);
        notificationManagerCompat=NotificationManagerCompat.from(this);
        title=findViewById(R.id.title_of_commponent);
        message=findViewById(R.id.message);


        createNotificationChannel();
        setTheButton();

    }

    private void setTheButton() {
        Button button=findViewById(R.id.send_notification1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Notification notification=new NotificationCompat.Builder(NotificationExample.this,channelNewItem)
                        .setSmallIcon(R.drawable.logo)
                        .setContentTitle(title.getText())
                        .setContentText(message.getText())
                        .setPriority(NotificationCompat.PRIORITY_HIGH).build();
                notificationManagerCompat.notify(1,notification);
            }
        });


        Button button2=findViewById(R.id.send_notification2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(NotificationExample.this,NotificationExample.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(NotificationExample.this,0,intent,0);
                Notification notification=new NotificationCompat.Builder(NotificationExample.this,channelNewItem2)
                        .setSmallIcon(R.drawable.logo)
                        .setContentTitle(title.getText())
                        .setContentText(message.getText())
                        .setContentIntent(pendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_LOW).build();
                notificationManagerCompat.notify(1,notification);
            }
        });
        Button button3=findViewById(R.id.button_notification);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PendingIntent titleIntent=setTheTitleAction(title.getText().toString(),0);
                PendingIntent textIntent=setTheTitleAction(message.getText().toString(),1);



                Notification notification=new NotificationCompat.Builder(NotificationExample.this,channelNewItem2)
                        .setSmallIcon(R.drawable.logo)
                        .setContentTitle(title.getText())
                        .setContentText(message.getText())
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .setAutoCancel(true)
                        .setColor(Color.RED)
                        .setVibrate(new long[]{150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150})
                        .addAction(R.mipmap.ic_launcher,"כותרת",titleIntent)
                        .addAction(R.mipmap.ic_launcher,"טקסט",textIntent)
                        .build();
                notificationManagerCompat.notify(3,notification);
            }

            private PendingIntent setTheTitleAction(String text,int index) {
                Intent broadcast = new Intent(NotificationExample.this, NotificationReciver.class);
                broadcast.putExtra("toastMessage", text);
                return PendingIntent.
                        getBroadcast(NotificationExample.this, index, broadcast, PendingIntent.FLAG_UPDATE_CURRENT);

            }
        });
    }

    private void createNotificationChannel() {
        
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
                    NotificationChannel channel =new NotificationChannel(channelNewItem,channelNewItem,NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("this is chanel 1");

            NotificationChannel channe2 =new NotificationChannel(channelNewItem2,channelNewItem2,NotificationManager.IMPORTANCE_LOW);
            channe2.setDescription("this is chanel 2");

            NotificationChannel channe3 =new NotificationChannel(channelNewItem2,channelNewItem2,NotificationManager.IMPORTANCE_MIN);
            channe2.setDescription("this is chanel 3");

            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
            manager.createNotificationChannel(channe2);
            manager.createNotificationChannel(channe3);
        }
    }



}
