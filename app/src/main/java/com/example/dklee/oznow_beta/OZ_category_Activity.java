package com.example.dklee.oznow_beta;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;


/**
 * Created by DKLEE on 2015-08-17.
 */
public class OZ_category_Activity extends AppCompatActivity implements View.OnClickListener {
    private Button ctg_btn_11;
    private Button ctg_btn_1;
    private OZ_category_dialog ctg_dialog;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.oz_write_category);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        ctg_btn_1 = (Button)findViewById(R.id.ctg_btn1);
        ctg_btn_1.setOnClickListener(this);
        Button ctg_btn_2 = (Button)findViewById(R.id.ctg_btn2);
        ctg_btn_2.setOnClickListener(this);
        Button ctg_btn_3 = (Button)findViewById(R.id.ctg_btn3);
        ctg_btn_3.setOnClickListener(this);
        Button ctg_btn_4 = (Button)findViewById(R.id.ctg_btn4);
        ctg_btn_4.setOnClickListener(this);
        Button ctg_btn_5 = (Button)findViewById(R.id.ctg_btn5);
        ctg_btn_5.setOnClickListener(this);
        Button ctg_btn_6 = (Button)findViewById(R.id.ctg_btn6);
        ctg_btn_6.setOnClickListener(this);
        Button ctg_btn_7 = (Button)findViewById(R.id.ctg_btn7);
        ctg_btn_7.setOnClickListener(this);
        Button ctg_btn_8 = (Button)findViewById(R.id.ctg_btn8);
        ctg_btn_8.setOnClickListener(this);
        ctg_btn_11 = (Button)findViewById(R.id.ctg_btn11);

        final TextView ctg_txt1 = (TextView)findViewById(R.id.ctg_txt1);
        TextView ctg_txt2 = (TextView)findViewById(R.id.ctg_txt2);
        TextView ctg_txt3 = (TextView)findViewById(R.id.ctg_txt3);
        TextView ctg_txt4 = (TextView)findViewById(R.id.ctg_txt4);
        TextView ctg_txt5 = (TextView)findViewById(R.id.ctg_txt5);
        TextView ctg_txt6 = (TextView)findViewById(R.id.ctg_txt6);
        TextView ctg_txt7 = (TextView)findViewById(R.id.ctg_txt7);
        TextView ctg_txt8 = (TextView)findViewById(R.id.ctg_txt8);

        ctg_dialog = new OZ_category_dialog(OZ_category_Activity.this);
        ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                ctg_txt1.setText(ctg_dialog.getcategoryName());

            }
        });



    }

    @Override
    public void onClick(View v) {
        TextView tv=(TextView)v;
        switch(tv.getId()){
            case R.id.ctg_btn1 :
                ctg_dialog.show();
                ctg_btn_1.setVisibility(View.INVISIBLE);
                ctg_btn_11.setVisibility(View.VISIBLE);
                ctg_btn_11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(OZ_category_Activity.this, OZnowActivity.class);
                        startActivity(intent);
                    }
                });
        }
    }
}
