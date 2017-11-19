package com.example.admin.weekend2hw;


import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChildFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChildFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public static TextView tvTimerView;
    private Timer timer = new Timer();

    public ChildFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChildFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChildFragment newInstance(String param1, String param2) {
        ChildFragment fragment = new ChildFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_child, container, false);
    }
    public static  void startTimer()
    {
        Timer timer = new Timer();
        TimerTask t = new TimerTask() {
            int sec = 0;
            @Override
            public void run() {

                updateUI(sec);
            }
        };
        timer.scheduleAtFixedRate(t,1000,1000);
    }
    public void stopTimer()
    {

    }
    public static void updateUI(final int seconds)
    {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                tvTimerView.setText("" + seconds);
            }
        });
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvTimerView= view.findViewById(R.id.tvTime);
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {

                tvTimerView.setText("" + msg.getData().get("seconds"));
            }
        };

        if (mParam1 != null && mParam1.equals("Start")) {



            TimerTask t = new TimerTask() {
                int sec = 0;

                @Override
                public void run() {
                    sec++;
                    Bundle b = new Bundle();
                    b.putString("seconds", String.valueOf(sec));
                    Message m = new Message();
                    m.setData(b);
                    handler.sendMessage(m);
                }
            };
            timer.scheduleAtFixedRate(t, 1000, 1000);
        }
        if (mParam1 != null && mParam1.equals("Stop"))
        {
            timer.cancel();
            Bundle b = new Bundle();
            b.putString("seconds", String.valueOf(0));
            Message m = new Message();
            m.setData(b);
            handler.sendMessage(m);
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        timer.cancel();
    }
}
