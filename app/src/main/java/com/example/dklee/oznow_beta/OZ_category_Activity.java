package com.example.dklee.oznow_beta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by DKLEE on 2015-08-17.
 */
public class OZ_category_Activity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.oz_write_category);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        Button ctg_btn_1 = (Button)findViewById(R.id.ctg_btn1);
        Button ctg_btn_2 = (Button)findViewById(R.id.ctg_btn2);
        Button ctg_btn_3 = (Button)findViewById(R.id.ctg_btn3);
        Button ctg_btn_4 = (Button)findViewById(R.id.ctg_btn4);
        Button ctg_btn_5 = (Button)findViewById(R.id.ctg_btn5);
        Button ctg_btn_6 = (Button)findViewById(R.id.ctg_btn6);
        Button ctg_btn_7 = (Button)findViewById(R.id.ctg_btn7);
        Button ctg_btn_8 = (Button)findViewById(R.id.ctg_btn8);

        TextView ctg_txt1 = (TextView)findViewById(R.id.ctg_txt1);
        TextView ctg_txt2 = (TextView)findViewById(R.id.ctg_txt2);
        TextView ctg_txt3 = (TextView)findViewById(R.id.ctg_txt3);
        TextView ctg_txt4 = (TextView)findViewById(R.id.ctg_txt4);
        TextView ctg_txt5 = (TextView)findViewById(R.id.ctg_txt5);
        TextView ctg_txt6 = (TextView)findViewById(R.id.ctg_txt6);
        TextView ctg_txt7 = (TextView)findViewById(R.id.ctg_txt7);
        TextView ctg_txt8 = (TextView)findViewById(R.id.ctg_txt8);

        OZ_category_dialog ctg_dialog;

        ctg_dialog = new OZ_category_dialog(OZ_category_Activity.this);


    }

    }
