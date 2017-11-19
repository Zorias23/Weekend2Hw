package com.example.admin.weekend2hw;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        }, 2000);
        //goToNextActivity();
       // MyRunnable m = new MyRunnable();
       // Thread t = new Thread(m);
      //  t.start();
       // goToNextActivity();
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*
        Log.d("MainActivity", "onResume: is called");
         MyRunnable m = new MyRunnable();
        Thread t = new Thread(m);
          t.start();
         goToNextActivity(); */
    }

    public void goToNextActivity()
    {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }


}
