package com.example.dklee.oznow_beta;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by kyounghee on 2015-08-23.
 */
public class LoginActivity extends Activity {
    private Button btn_login_facebook;
    private Button btn_login_google;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oz_login);
        Log.d("login", "meg onCreate");
        btn_login_facebook=(Button)findViewById(R.id.btn_login_facebook);
        btn_login_google=(Button)findViewById(R.id.btn_login_google);
        btn_login_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, AllListActivity.class);
                startActivity(intent);
                SharedPreferences pref = getSharedPreferences("category", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                finish();
            }
        });
        btn_login_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, AllListActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
