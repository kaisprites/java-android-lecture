package com.example.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

public class TimerService extends Service {
    private boolean isStop = true;
    private Timer t;

    @Override
    public void onCreate() {
        super.onCreate();
        t = new Timer();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(isStop) {
            isStop = false;
            t.start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(!isStop) {
            isStop = true;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public class Timer extends Thread {
        private int count;
        private Handler handler;

        public Timer() {
            handler = new Handler();
        }
        @Override
        public void run() {
            while(true){
                if(isStop) break;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable(){
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), count+"", Toast.LENGTH_SHORT).show();
                        android.util.Log.d("timer",count+"");
                    }
                });
                count++;
            }
        }
    }

}
