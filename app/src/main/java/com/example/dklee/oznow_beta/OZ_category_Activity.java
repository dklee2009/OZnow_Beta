package com.example.dklee.oznow_beta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


/**
 * Created by DKLEE on 2015-08-17.
 */
public class OZ_category_Activity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.oz_write_category);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

    }

    }
