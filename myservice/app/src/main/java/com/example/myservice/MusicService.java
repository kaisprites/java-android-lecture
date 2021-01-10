package com.example.myservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        android.util.Log.i("서비스 onCreate() 메서드 호출>>", "서비스 객체 생성됨");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        android.util.Log.i("onStartCommand() 호출>>", "서비스 시작됨");
        mediaPlayer = MediaPlayer.create(this, R.raw.song1);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        android.util.Log.i("onDestroy() 테스트>>", "onDestroy()");
        mediaPlayer.stop();
        super.onDestroy();
    }
}
