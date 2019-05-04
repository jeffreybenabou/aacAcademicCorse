package com.example.jeffrey.academic.services;
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
import com.example.jeffrey.academic.R;


public class MediaPlayerActivity extends AppCompatActivity implements View.OnClickListener {
    public static String channelNewItem = "sport", channelNewItem2 = "nati";
    private NotificationManagerCompat notificationManagerCompat;

    private Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        notificationManagerCompat = NotificationManagerCompat.from(this);
        setTheButtonAttr();
        createNotificationChannel();
    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelNewItem, channelNewItem, NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("this is chanel 1");
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

    private void createNotification() {
        PendingIntent nextSong = setTheTitleAction(0);
        PendingIntent prevSong = setTheTitleAction(1);

        Notification notification = new NotificationCompat.Builder(MediaPlayerActivity.this, channelNewItem2)
                .setSmallIcon(R.drawable.logo)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setAutoCancel(true)
                .setColor(Color.RED)
                .setVibrate(new long[]{150, 150, 150, 150, 150, 150, 150, 150, 150, 150, 150, 150, 150, 150, 150, 150, 150, 150})
                .addAction(R.mipmap.ic_launcher, "עצור שיר", nextSong)
                .addAction(R.mipmap.ic_launcher, "המשך שיר", prevSong)
                .build();
        notificationManagerCompat.notify(1, notification);
    }

    private PendingIntent setTheTitleAction(int index) {
        Intent broadcast = new Intent(MediaPlayerActivity.this, MusicHandler.class);
        broadcast.putExtra("index", index);
        return PendingIntent.
                getBroadcast(MediaPlayerActivity.this, index, broadcast, PendingIntent.FLAG_UPDATE_CURRENT);
    }


    private void setTheButtonAttr() {
        start = findViewById(R.id.start_service);
        stop = findViewById(R.id.stop_service);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_service:
                startService(new Intent(this, MusicService.class));
                break;
            case R.id.stop_service:
                stopService(new Intent(this, MusicService.class));
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        createNotification();
    }
}
