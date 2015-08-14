package com.example.dklee.oznow_beta;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by DKLEE on 2015-08-14.
 */
public class IntroActivity extends OZnowActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oz_main_intro);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(IntroActivity.this, OZnowActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
