package com.example.androidcalendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {
    Context context;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        String get_yout_string = intent.getExtras().getString("state");
        Intent serviceIntent = new Intent(context, RingtonePlayingService.class);
        serviceIntent.putExtra("state",get_yout_string);
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            this.context.startForegroundService(serviceIntent);
        } else {
            this.context.startService(serviceIntent);
        }
    }
}
