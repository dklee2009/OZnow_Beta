package com.example.dklee.oznow_beta;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by DKLEE on 2015-08-17.
 */
public class OZCategoryActivity extends Activity implements View.OnClickListener {
    public Button ctg_btn_1;
    public Button ctg_btn_2;
    private Button ctg_btn_3;
    private Button ctg_btn_4;
    private Button ctg_btn_5;
    private Button ctg_btn_6;
    private Button ctg_btn_7;
    private Button ctg_btn_8;
    public Button ctg_btn_1_1;
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

    private Animation btn_an01;
    private Animation btn_an02;
    private Animation btn_an03;
    private Animation btn_an04;
    private Animation btn_an05;
    private Animation btn_an06;
    private Animation btn_an07;
    private Animation btn_an08;



    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oz_category);
        Log.d("OZCategory", "meg onCreate");

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        SharedPreferences pref = getSharedPreferences("category", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        ctg_txt1 = (TextView) findViewById(R.id.ctg_txt1);
        ctg_txt2 = (TextView) findViewById(R.id.ctg_txt2);
        ctg_txt3 = (TextView) findViewById(R.id.ctg_txt3);
        ctg_txt4 = (TextView) findViewById(R.id.ctg_txt4);
        ctg_txt5 = (TextView) findViewById(R.id.ctg_txt5);
        ctg_txt6 = (TextView) findViewById(R.id.ctg_txt6);
        ctg_txt7 = (TextView) findViewById(R.id.ctg_txt7);
        ctg_txt8 = (TextView) findViewById(R.id.ctg_txt8);
        ctg_btn_1 = (Button) findViewById(R.id.ctg_btn1);
        ctg_btn_2 = (Button) findViewById(R.id.ctg_btn2);
        ctg_btn_3 = (Button) findViewById(R.id.ctg_btn3);
        ctg_btn_4 = (Button) findViewById(R.id.ctg_btn4);
        ctg_btn_5 = (Button) findViewById(R.id.ctg_btn5);
        ctg_btn_6 = (Button) findViewById(R.id.ctg_btn6);
        ctg_btn_7 = (Button) findViewById(R.id.ctg_btn7);
        ctg_btn_8 = (Button) findViewById(R.id.ctg_btn8);
        ctg_btn_1_1 = (Button) findViewById(R.id.ctg_btn1_1);
        ctg_btn_2_2 = (Button) findViewById(R.id.ctg_btn2_2);
        ctg_btn_3_3 = (Button) findViewById(R.id.ctg_btn3_3);
        ctg_btn_4_4 = (Button) findViewById(R.id.ctg_btn4_4);
        ctg_btn_5_5 = (Button) findViewById(R.id.ctg_btn5_5);
        ctg_btn_6_6 = (Button) findViewById(R.id.ctg_btn6_6);
        ctg_btn_7_7 = (Button) findViewById(R.id.ctg_btn7_7);
        ctg_btn_8_8 = (Button) findViewById(R.id.ctg_btn8_8);
        ctg_dialog = new OZCategoryDialog(OZCategoryActivity.this);
        Button btn_close = (Button) findViewById(R.id.btn_close);

        btn_an01 = AnimationUtils.loadAnimation(this, R.anim.ctg_btn_anim);
        btn_an02 = AnimationUtils.loadAnimation(this, R.anim.ctg_btn_anim2);
        btn_an03 = AnimationUtils.loadAnimation(this, R.anim.ctg_btn_anim3);
        btn_an04 = AnimationUtils.loadAnimation(this, R.anim.ctg_btn_anim4);
        btn_an05 = AnimationUtils.loadAnimation(this, R.anim.ctg_btn_anim5);
        btn_an06 = AnimationUtils.loadAnimation(this, R.anim.ctg_btn_anim6);
        btn_an07 = AnimationUtils.loadAnimation(this, R.anim.ctg_btn_anim7);
        btn_an08 = AnimationUtils.loadAnimation(this, R.anim.ctg_btn_anim8);

        ctg_btn_1.setAnimation(btn_an01);
        ctg_btn_2.setAnimation(btn_an02);
        ctg_btn_3.setAnimation(btn_an03);
        ctg_btn_4.setAnimation(btn_an04);
        ctg_btn_5.setAnimation(btn_an05);
        ctg_btn_6.setAnimation(btn_an06);
        ctg_btn_7.setAnimation(btn_an07);
        ctg_btn_8.setAnimation(btn_an08);

        ctg_btn_1_1.setAnimation(btn_an01);
        ctg_btn_2_2.setAnimation(btn_an02);
        ctg_btn_3_3.setAnimation(btn_an03);
        ctg_btn_4_4.setAnimation(btn_an04);
        ctg_btn_5_5.setAnimation(btn_an05);
        ctg_btn_6_6.setAnimation(btn_an06);
        ctg_btn_7_7.setAnimation(btn_an07);
        ctg_btn_8_8.setAnimation(btn_an08);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OZCategoryActivity.this, AllListActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button btn_update = (Button) findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctg_btn_1.setVisibility(View.VISIBLE);
                ctg_btn_1.setText("up");
                ctg_btn_1.setOnClickListener(this);
            }
        });
        String c1_name = pref.getString("c1_name", "");
        String c2_name = pref.getString("c2_name", "");
        String c3_name = pref.getString("c3_name", "");
        String c4_name = pref.getString("c4_name", "");
        String c5_name = pref.getString("c5_name", "");
        String c6_name = pref.getString("c6_name", "");
        String c7_name = pref.getString("c7_name", "");
        String c8_name = pref.getString("c8_name", "");
        if (!c1_name.equals("")) {
            ctg_txt1.setText(c1_name);
            ctg_btn_1.setVisibility(View.INVISIBLE);
            ctg_btn_1_1.setVisibility(View.VISIBLE);
            Log.d("c1", c1_name);
        }
        if (!c2_name.equals("")) {
            ctg_txt2.setText(c2_name);
            ctg_btn_2.setVisibility(View.INVISIBLE);
            ctg_btn_2_2.setVisibility(View.VISIBLE);
            Log.d("c2", c2_name);
        }
        if (!c3_name.equals("")) {
            ctg_txt3.setText(c3_name);
            ctg_btn_3.setVisibility(View.INVISIBLE);
            ctg_btn_3_3.setVisibility(View.VISIBLE);
            Log.d("c3", c3_name);
        }
        if (!c4_name.equals("")) {
            ctg_txt4.setText(c4_name);
            ctg_btn_4.setVisibility(View.INVISIBLE);
            ctg_btn_4_4.setVisibility(View.VISIBLE);
        }
        if (!c5_name.equals("")) {
            ctg_txt5.setText(c5_name);
            ctg_btn_5.setVisibility(View.INVISIBLE);
            ctg_btn_5_5.setVisibility(View.VISIBLE);
        }
        if (!c6_name.equals("")) {
            ctg_txt6.setText(c6_name);
            ctg_btn_6.setVisibility(View.INVISIBLE);
            ctg_btn_6_6.setVisibility(View.VISIBLE);
        }
        if (!c7_name.equals("")) {
            ctg_txt7.setText(c7_name);
            ctg_btn_7.setVisibility(View.INVISIBLE);
            ctg_btn_7_7.setVisibility(View.VISIBLE);
        }
        if (!c8_name.equals("")) {
            ctg_txt8.setText(c8_name);
            ctg_btn_8.setVisibility(View.INVISIBLE);
            ctg_btn_8_8.setVisibility(View.VISIBLE);
        }
        ctg_btn_1.setOnClickListener(this);
        ctg_btn_1_1.setOnClickListener(this);
        ctg_btn_2.setOnClickListener(this);
        ctg_btn_2_2.setOnClickListener(this);
        ctg_btn_3.setOnClickListener(this);
        ctg_btn_3_3.setOnClickListener(this);
        ctg_btn_4.setOnClickListener(this);
        ctg_btn_4_4.setOnClickListener(this);
        ctg_btn_5.setOnClickListener(this);
        ctg_btn_5_5.setOnClickListener(this);
        ctg_btn_6.setOnClickListener(this);
        ctg_btn_6_6.setOnClickListener(this);
        ctg_btn_7.setOnClickListener(this);
        ctg_btn_7_7.setOnClickListener(this);
        ctg_btn_8.setOnClickListener(this);
        ctg_btn_8_8.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ctg_btn1) {
            ctg_dialog.setMessage("red");
            ctg_dialog.onCreate();
            ctg_dialog.show();
            ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    ctg_txt1.setText(ctg_dialog.getcategoryName());
                    SharedPreferences pref = getSharedPreferences("category", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("c1_name", ctg_dialog.getcategoryName());
                    editor.commit();
                    ctg_btn_1.setVisibility(View.INVISIBLE);
                    ctg_btn_1_1.setVisibility(View.VISIBLE);
                }
            });
            ctg_dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {ctg_btn_1.setVisibility(View.VISIBLE);
                }
            });
        } else if (v.getId() == R.id.ctg_btn1_1) {
            Intent intent = new Intent(this, OZnowActivity.class);
            intent.putExtra("color", "red");
            startActivity(intent);
            finish();
        } else if (v.getId() == R.id.ctg_btn2) {
            ctg_dialog.setMessage("orange");
            ctg_dialog.onCreate();
            ctg_dialog.show();
            ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    ctg_txt2.setText(ctg_dialog.getcategoryName());
                    SharedPreferences pref = getSharedPreferences("category", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("c2_name", ctg_dialog.getcategoryName());
                    editor.commit();
                    ctg_btn_2.setVisibility(View.INVISIBLE);
                    ctg_btn_2_2.setVisibility(View.VISIBLE);
                }
            });
            ctg_dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {

                }
            });
        } else if (v.getId() == R.id.ctg_btn2_2) {
            Intent intent = new Intent(this, OZnowActivity.class);
            intent.putExtra("color", "orange");
            startActivity(intent);
            finish();
        } else if (v.getId() == R.id.ctg_btn3) {
            ctg_dialog.setMessage("yellow");
            ctg_dialog.onCreate();
            ctg_dialog.show();
            ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    ctg_txt3.setText(ctg_dialog.getcategoryName());
                    SharedPreferences pref = getSharedPreferences("category", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("c3_name", ctg_dialog.getcategoryName());
                    editor.commit();
                    ctg_btn_3.setVisibility(View.INVISIBLE);
                    ctg_btn_3_3.setVisibility(View.VISIBLE);
                }
            });
            ctg_dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {

                }
            });
        } else if (v.getId() == R.id.ctg_btn3_3) {
            Intent intent = new Intent(this, OZnowActivity.class);
            intent.putExtra("color", "yellow");
            startActivity(intent);
            finish();
        } else if (v.getId() == R.id.ctg_btn4) {
            ctg_dialog.setMessage("lightgreen");
            ctg_dialog.onCreate();
            ctg_dialog.show();
            ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    ctg_txt4.setText(ctg_dialog.getcategoryName());
                    SharedPreferences pref = getSharedPreferences("category", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("c4_name", ctg_dialog.getcategoryName());
                    editor.commit();
                    ctg_btn_4.setVisibility(View.INVISIBLE);
                    ctg_btn_4_4.setVisibility(View.VISIBLE);
                }
            });
            ctg_dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {

                }
            });
        } else if (v.getId() == R.id.ctg_btn4_4) {
            Intent intent = new Intent(this, OZnowActivity.class);
            intent.putExtra("color", "lightgreen");
            startActivity(intent);
            finish();
        } else if (v.getId() == R.id.ctg_btn5) {
            ctg_dialog.setMessage("green");
            ctg_dialog.onCreate();
            ctg_dialog.show();
            ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    ctg_txt5.setText(ctg_dialog.getcategoryName());
                    SharedPreferences pref = getSharedPreferences("category", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("c5_name", ctg_dialog.getcategoryName());
                    editor.commit();
                    ctg_btn_5.setVisibility(View.INVISIBLE);
                    ctg_btn_5_5.setVisibility(View.VISIBLE);
                }
            });
            ctg_dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {

                }
            });
        } else if (v.getId() == R.id.ctg_btn5_5) {
            Intent intent = new Intent(this, OZnowActivity.class);
            intent.putExtra("color", "green");
            startActivity(intent);
            finish();
        } else if (v.getId() == R.id.ctg_btn6) {
            ctg_dialog.setMessage("lightblue");
            ctg_dialog.onCreate();
            ctg_dialog.show();
            ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    ctg_txt6.setText(ctg_dialog.getcategoryName());
                    SharedPreferences pref = getSharedPreferences("category", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("c6_name", ctg_dialog.getcategoryName());
                    editor.commit();
                    ctg_btn_6.setVisibility(View.INVISIBLE);
                    ctg_btn_6_6.setVisibility(View.VISIBLE);
                }
            });
            ctg_dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {

                }
            });
        } else if (v.getId() == R.id.ctg_btn6_6) {
            Intent intent = new Intent(this, OZnowActivity.class);
            intent.putExtra("color", "lightblue");
            startActivity(intent);
            finish();
        } else if (v.getId() == R.id.ctg_btn7) {
            ctg_dialog.setMessage("blue");
            ctg_dialog.onCreate();
            ctg_dialog.show();
            ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    ctg_txt7.setText(ctg_dialog.getcategoryName());
                    SharedPreferences pref = getSharedPreferences("category", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("c7_name", ctg_dialog.getcategoryName());
                    editor.commit();
                    ctg_btn_7.setVisibility(View.INVISIBLE);
                    ctg_btn_7_7.setVisibility(View.VISIBLE);
                }
            });
            ctg_dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {

                }
            });
        } else if (v.getId() == R.id.ctg_btn7_7) {
            Intent intent = new Intent(this, OZnowActivity.class);
            intent.putExtra("color", "blue");
            startActivity(intent);
            finish();
        } else if (v.getId() == R.id.ctg_btn8) {
            ctg_dialog.setMessage("purple");
            ctg_dialog.onCreate();
            ctg_dialog.show();
            ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    ctg_txt8.setText(ctg_dialog.getcategoryName());
                    SharedPreferences pref = getSharedPreferences("category", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("c8_name", ctg_dialog.getcategoryName());
                    editor.commit();
                    ctg_btn_8.setVisibility(View.INVISIBLE);
                    ctg_btn_8_8.setVisibility(View.VISIBLE);
                }
            });
            ctg_dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {

                }
            });
        } else if (v.getId() == R.id.ctg_btn8_8) {
            Intent intent = new Intent(this, OZnowActivity.class);
            intent.putExtra("color", "purple");
            startActivity(intent);
            finish();
        }
    }
}

