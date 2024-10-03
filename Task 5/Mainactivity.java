package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView timeshow;
    Button start,pause,reset;
    long millsecondtime, startTime, timebuff, resett=0L;
    int min,sec,millsec;
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeshow = (TextView) findViewById(R.id.timer);
        start = (Button) findViewById(R.id.start);
        pause = (Button) findViewById(R.id.pause);
        reset = (Button) findViewById(R.id.reset);

        handler = new Handler();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable,0);
                reset.setEnabled(false);

            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                timebuff += millsecondtime;
                handler.removeCallbacks(runnable);
                reset.setEnabled(true);

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               millsecondtime = 0L;
               startTime = 0L;
               timebuff = 0L;
               resett = 0L;
               sec = 0;
               min = 0;
               millsec=0;
               timeshow.setText("00:00:00");
            }
        });

    }

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            millsecondtime = SystemClock.uptimeMillis() - startTime;
            resett = timebuff + millsecondtime;
            sec = (int) (resett/1000);
            min = sec/60;
            sec = sec%60;
            millsec = (int) (resett%60);
            timeshow.setText("" +min+ ":" + String.format("%02d",sec) + ":" + String.format("%03d", millsec));
            handler.postDelayed(this,0);
        }
    };
}