package com.example.admin.weekend2hw;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

public class Main2Activity extends AppCompatActivity implements DialogInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void goToPdfActivity(View view) {
        Intent intent = new Intent(Main2Activity.this, ViewPdfActivity.class);
        startActivity(intent);
    }


    public void showDialogImage(View view) {
        Log.d("Main2Activity", "onClick: clicked view image button...");
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        DialogFragment newFragment = MyDialogFragment.newInstance();
        newFragment.show(ft, "dialog");
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                    ft.commit();
                }
            }
        }, 3000);
    }

    public void showDefaultAlert(View view) {
        new AlertDialog.Builder(this)
                .setMessage(R.string.defaultAlertMessage)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    public void showCustomAlert(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
        DialogFragment newFragment = MyAlertDialogFragment.newInstance();
        newFragment.show(ft, "dialog");
    }

    @Override
    public void cancel() {

    }

    @Override
    public void dismiss() {

    }
    public void doPositiveClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Positive click!");
    }

    public void doNegativeClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Negative click!");
    }

    public void sendNotify(View view) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("Important Notification")
                        .setContentText("I'll take you to another activity!");
        Intent resultIntent = new Intent(this, ViewPdfActivity.class);
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        int mNotificationId = 001;
// Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
// Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());




    }

    public void goToSmsActivity(View view) {
        Intent intent = new Intent(this, SendSmsActivity.class);
        startActivity(intent);
    }

    public void goToTimerActivity(View view) {
        Intent intent = new Intent(this, TimerActivity.class);
        startActivity(intent);
    }

    public void showCustomAlert2(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(Main2Activity.this).create();
        LayoutInflater inflater = alertDialog.getLayoutInflater();
        @SuppressLint("InflateParams") View dialogView = inflater.inflate(R.layout.custom_alert, null);
        alertDialog.setView(dialogView);
        alertDialog.show();
    }

    public void showCustomAlert3(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose your activity");
        builder.setItems(R.array.players, new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("CustomAlert3", "onClick: you clicked item " + i);
                if (i == 0)
                {
                    Intent intent = new Intent(Main2Activity.this, Main2Activity.class);
                    startActivity(intent);
                }
                if (i == 1)
                {
                    Intent intent = new Intent(Main2Activity.this, ViewPdfActivity.class);
                    startActivity(intent);
                }
                if (i ==2)
                {
                    Intent intent = new Intent(Main2Activity.this, TimerActivity.class);
                    startActivity(intent);
                }
            }
        });
        builder.show();
    }
}
