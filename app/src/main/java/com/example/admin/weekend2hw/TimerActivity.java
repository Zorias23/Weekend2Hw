package com.example.admin.weekend2hw;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TimerActivity extends AppCompatActivity implements ParentFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
    }



    public void startTimer(View view) {

        ChildFragment.startTimer();
    }

    public void stopTimer(View view) {
    }

    @Override
    public void onFragmentInteraction(String s) {
        if (s.equals("Start"))
        {
            ParentFragment pf = (ParentFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.parentFragment);
            ChildFragment cf = ChildFragment.newInstance("Start", "val");
            pf.getChildFragmentManager().beginTransaction().replace(R.id.childFragment, cf, "CHILD_FRAG").commit();

        }
        if (s.equals("Stop"))
        {
            ParentFragment pf = (ParentFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.parentFragment);
            ChildFragment cf = ChildFragment.newInstance("Stop", "val");
            pf.getChildFragmentManager().beginTransaction().replace(R.id.childFragment, cf, "CHILD_FRAG").commit();

        }
    }
}
