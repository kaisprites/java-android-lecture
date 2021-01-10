package com.example.androidcalendar;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

public class RingtonePlayingService extends Service {
    MediaPlayer mediaPlayer;
    int startId;
    boolean isRunning;

    public RingtonePlayingService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            String CHANNEL_ID = "default";
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                    "channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setContentTitle("알람시작")
                    .setContentText("알람음이 재생됩니다")
                    .build();
            startForeground(1, notification);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String getState= intent.getExtras().getString("state");
        assert getState != null;
        switch (getState) {
            case "alarm on":
                startId = 1;
                break;
            case "alarm off":
            default:
                startId = 0;
                break;
        }

        //알람음 재생 X, 시작 버튼 클릭
        if(!this.isRunning && startId == 1) {
            mediaPlayer = MediaPlayer.create(this, R.raw.newworldweapon);
            mediaPlayer.start();
            this.isRunning= true;
            this.startId = 0;
        }

        //알람음 재생 O, 종료 버튼 클릭
        else if (this.isRunning && startId == 0) {
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();

            this.isRunning = false;
            this.startId = 0;
        }

        //재생X, 종료버튼 클릭
        else if(!this.isRunning && startId == 0) {
            this.isRunning = false;
            this.startId = 0;
        }

        //재생O, 시작버튼 클릭
        else if(this.isRunning && startId == 1) {
            this.isRunning = true;
            this.startId = 1;
        }
        else {}
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
