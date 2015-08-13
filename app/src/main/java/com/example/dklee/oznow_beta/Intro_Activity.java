package com.example.dklee.oznow_beta;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by DKLEE on 2015-08-14.
 */
public class Intro_Activity extends MainActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_main);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Intro_Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
