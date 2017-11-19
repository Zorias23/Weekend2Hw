package com.example.admin.weekend2hw;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/**
 * Created by Admin on 11/18/2017.
 */

public class MyRunnable implements Runnable{
    Handler handler = new Handler(Looper.getMainLooper());
    @Override
    public void run() {

            handler.post(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

    }

    }

