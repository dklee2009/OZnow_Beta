package com.example.dklee.oznow_beta;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by DKLEE on 2015-08-17.
 */
public class OZCategoryActivity extends AppCompatActivity implements View.OnClickListener {
    private Button ctg_btn_1;
    private Button ctg_btn_2;
    private Button ctg_btn_3;
    private Button ctg_btn_4;
    private Button ctg_btn_5;
    private Button ctg_btn_6;
    private Button ctg_btn_7;
    private Button ctg_btn_8;
    private Button ctg_btn_1_1;
    private Button ctg_btn_2_2;
    private Button ctg_btn_3_3;
    private Button ctg_btn_4_4;
    private Button ctg_btn_5_5;
    private Button ctg_btn_6_6;
    private Button ctg_btn_7_7;
    private Button ctg_btn_8_8;
    private TextView ctg_txt1;
    private TextView ctg_txt2;
    private TextView ctg_txt3;
    private TextView ctg_txt4;
    private TextView ctg_txt5;
    private TextView ctg_txt6;
    private TextView ctg_txt7;
    private TextView ctg_txt8;
    private OZCategoryDialog ctg_dialog;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oz_write_category);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        ctg_btn_1_1=(Button)findViewById(R.id.ctg_btn1_1);
        ctg_btn_1_1.setOnClickListener(this);
        ctg_btn_2 = (Button)findViewById(R.id.ctg_btn2);
        ctg_btn_2.setOnClickListener(this);
        ctg_btn_2_2=(Button)findViewById(R.id.ctg_btn2_2);
        ctg_btn_2_2.setOnClickListener(this);
        ctg_btn_3 = (Button)findViewById(R.id.ctg_btn3);
        ctg_btn_3.setOnClickListener(this);
        ctg_btn_3_3=(Button)findViewById(R.id.ctg_btn3_3);
        ctg_btn_3_3.setOnClickListener(this);
        ctg_btn_4 = (Button)findViewById(R.id.ctg_btn4);
        ctg_btn_4.setOnClickListener(this);
        ctg_btn_4_4=(Button)findViewById(R.id.ctg_btn4_4);
        ctg_btn_4_4.setOnClickListener(this);
        ctg_btn_5 = (Button)findViewById(R.id.ctg_btn5);
        ctg_btn_5.setOnClickListener(this);
        ctg_btn_5_5=(Button)findViewById(R.id.ctg_btn5_5);
        ctg_btn_5_5.setOnClickListener(this);
        ctg_btn_6 = (Button)findViewById(R.id.ctg_btn6);
        ctg_btn_6.setOnClickListener(this);
        ctg_btn_6_6=(Button)findViewById(R.id.ctg_btn6_6);
        ctg_btn_6_6.setOnClickListener(this);
        ctg_btn_7 = (Button)findViewById(R.id.ctg_btn7);
        ctg_btn_7.setOnClickListener(this);
        ctg_btn_7_7=(Button)findViewById(R.id.ctg_btn7_7);
        ctg_btn_7_7.setOnClickListener(this);
        ctg_btn_8 = (Button)findViewById(R.id.ctg_btn8);
        ctg_btn_8.setOnClickListener(this);
        ctg_btn_8_8=(Button)findViewById(R.id.ctg_btn8_8);
        ctg_btn_8_8.setOnClickListener(this);

        ctg_txt1 = (TextView)findViewById(R.id.ctg_txt1);
        ctg_txt2 = (TextView)findViewById(R.id.ctg_txt2);
        ctg_txt3 = (TextView)findViewById(R.id.ctg_txt3);
        ctg_txt4 = (TextView)findViewById(R.id.ctg_txt4);
        ctg_txt5 = (TextView)findViewById(R.id.ctg_txt5);
        ctg_txt6 = (TextView)findViewById(R.id.ctg_txt6);
        ctg_txt7 = (TextView)findViewById(R.id.ctg_txt7);
        ctg_txt8 = (TextView)findViewById(R.id.ctg_txt8);

        ctg_dialog = new OZCategoryDialog(OZCategoryActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ctg_btn_1 = (Button)findViewById(R.id.ctg_btn1);
        ctg_btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctg_dialog.show();
                ctg_btn_1.setVisibility(View.INVISIBLE);
                ctg_btn_1_1.setVisibility(View.VISIBLE);
                ctg_btn_1_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(OZCategoryActivity.this, OZnowActivity.class);
                        startActivity(intent);
                    }
                });
                ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        ctg_txt1.setText(ctg_dialog.getcategoryName());
                        /*ctg_txt2.setText(ctg_dialog.getcategoryName());
                        ctg_txt3.setText(ctg_dialog.getcategoryName());
                        ctg_txt4.setText(ctg_dialog.getcategoryName());
                        ctg_txt5.setText(ctg_dialog.getcategoryName());
                        ctg_txt6.setText(ctg_dialog.getcategoryName());
                        ctg_txt7.setText(ctg_dialog.getcategoryName());
                        ctg_txt8.setText(ctg_dialog.getcategoryName());*/
                    }
                });
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
                ctg_btn_1_1.setVisibility(View.VISIBLE);
                ctg_btn_1_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(OZCategoryActivity.this, OZnowActivity.class);
                        startActivity(intent);
                    }
                });
                ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        ctg_txt1.setText(ctg_dialog.getcategoryName());
                        /*ctg_txt2.setText(ctg_dialog.getcategoryName());
                        ctg_txt3.setText(ctg_dialog.getcategoryName());
                        ctg_txt4.setText(ctg_dialog.getcategoryName());
                        ctg_txt5.setText(ctg_dialog.getcategoryName());
                        ctg_txt6.setText(ctg_dialog.getcategoryName());
                        ctg_txt7.setText(ctg_dialog.getcategoryName());
                        ctg_txt8.setText(ctg_dialog.getcategoryName());*/
                    }
                });
                break;
            case R.id.ctg_btn2:
                ctg_dialog.show();
                ctg_btn_2.setVisibility(View.INVISIBLE);
                ctg_btn_2_2.setVisibility(View.VISIBLE);
                ctg_btn_2_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(OZCategoryActivity.this, OZnowActivity.class);
                        startActivity(intent);
                    }
                });
                ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        ctg_txt2.setText(ctg_dialog.getcategoryName());
                        /*ctg_txt3.setText(ctg_dialog.getcategoryName());
                        ctg_txt4.setText(ctg_dialog.getcategoryName());
                        ctg_txt5.setText(ctg_dialog.getcategoryName());
                        ctg_txt6.setText(ctg_dialog.getcategoryName());
                        ctg_txt7.setText(ctg_dialog.getcategoryName());
                        ctg_txt8.setText(ctg_dialog.getcategoryName());*/
                    }
                });
                break;
            case R.id.ctg_btn3:
                ctg_dialog.show();
                ctg_btn_3.setVisibility(View.INVISIBLE);
                ctg_btn_3_3.setVisibility(View.VISIBLE);
                ctg_btn_3_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(OZCategoryActivity.this, OZnowActivity.class);
                        startActivity(intent);
                    }
                });
                ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        ctg_txt3.setText(ctg_dialog.getcategoryName());
                    }
                });
                break;
            case R.id.ctg_btn4:
                ctg_dialog.show();
                ctg_btn_4.setVisibility(View.INVISIBLE);
                ctg_btn_4_4.setVisibility(View.VISIBLE);
                ctg_btn_4_4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(OZCategoryActivity.this, OZnowActivity.class);
                        startActivity(intent);
                    }
                });
                ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        ctg_txt4.setText(ctg_dialog.getcategoryName());
                    }
                });
                break;
            case R.id.ctg_btn5:
                ctg_dialog.show();
                ctg_btn_5.setVisibility(View.INVISIBLE);
                ctg_btn_5_5.setVisibility(View.VISIBLE);
                ctg_btn_5_5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(OZCategoryActivity.this, OZnowActivity.class);
                        startActivity(intent);
                    }
                });
                ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        ctg_txt5.setText(ctg_dialog.getcategoryName());
                    }
                });
                break;
            case R.id.ctg_btn6:
                ctg_dialog.show();
                ctg_btn_6.setVisibility(View.INVISIBLE);
                ctg_btn_6_6.setVisibility(View.VISIBLE);
                ctg_btn_6_6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(OZCategoryActivity.this, OZnowActivity.class);
                        startActivity(intent);
                    }
                });
                break;
            case R.id.ctg_btn7:
                ctg_dialog.show();
                ctg_btn_7.setVisibility(View.INVISIBLE);
                ctg_btn_7_7.setVisibility(View.VISIBLE);
                ctg_btn_7_7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(OZCategoryActivity.this, OZnowActivity.class);
                        startActivity(intent);
                    }
                });
                break;
            case R.id.ctg_btn8:
                ctg_dialog.show();
                ctg_btn_8.setVisibility(View.INVISIBLE);
                ctg_btn_8_8.setVisibility(View.VISIBLE);
                ctg_btn_8_8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(OZCategoryActivity.this, OZnowActivity.class);
                        startActivity(intent);
                    }
                });
                break;
        }
    }
}
