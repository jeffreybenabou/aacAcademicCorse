package com.example.jeffrey.academic.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MusicHandler extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getIntExtra("index",2))
        {
            case 0:
                context.startService(new Intent(context,MusicService.class));
                break;
            case 1:
                context.stopService(new Intent(context,MusicService.class));
                break;
        }
    }
}
