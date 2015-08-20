package com.example.dklee.oznow_beta;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;


/**
 * Created by DKLEE on 2015-08-17.
 */
public class OZCategoryActivity extends AppCompatActivity {
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
    String category_name1;
    private String category_name2;
    private String category_name3;
    private String category_name4;
    private String category_name5;
    private String category_name6;
    private String category_name7;
    private String category_name8;


    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oz_category);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        ctg_txt1 = (TextView) findViewById(R.id.ctg_txt1);
        ctg_txt2 = (TextView) findViewById(R.id.ctg_txt2);
        ctg_txt3 = (TextView) findViewById(R.id.ctg_txt3);
        ctg_txt4 = (TextView) findViewById(R.id.ctg_txt4);
        ctg_txt5 = (TextView) findViewById(R.id.ctg_txt5);
        ctg_txt6 = (TextView) findViewById(R.id.ctg_txt6);
        ctg_txt7 = (TextView) findViewById(R.id.ctg_txt7);
        ctg_txt8 = (TextView) findViewById(R.id.ctg_txt8);
        ctg_dialog = new OZCategoryDialog(OZCategoryActivity.this);
        Intent intent = getIntent();
        if (intent.getStringExtra("category_name1") != null) {
            ctg_txt1.setText(intent.getStringExtra("category_name1"));
        }
        if (intent.getStringExtra("category_name2") != null) {
            ctg_txt2.setText(intent.getStringExtra("category_name2"));
        }
        if (intent.getStringExtra("category_name3") != null) {
            ctg_txt3.setText(intent.getStringExtra("category_name3"));
        }
        if (intent.getStringExtra("category_name4") != null) {
            ctg_txt4.setText(intent.getStringExtra("category_name4"));
        }
        if (intent.getStringExtra("category_name5") != null) {
            ctg_txt5.setText(intent.getStringExtra("category_name5"));
        }
        if (intent.getStringExtra("category_name6") != null) {
            ctg_txt6.setText(intent.getStringExtra("category_name6"));
        }
        if (intent.getStringExtra("category_name7") != null) {
            ctg_txt7.setText(intent.getStringExtra("category_name7"));
        }
        if (intent.getStringExtra("category_name8") != null) {
            ctg_txt8.setText(intent.getStringExtra("category_name8"));
        }

        ctg_btn_1 = (Button) findViewById(R.id.ctg_btn1);
        ctg_btn_1_1 = (Button) findViewById(R.id.ctg_btn1_1);
        ctg_btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctg_dialog.show();
                ctg_btn_2.setVisibility(View.INVISIBLE);
                ctg_btn_2_2.setVisibility(View.VISIBLE);
                ctg_btn_1_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(OZCategoryActivity.this, OZnowActivity.class);
                        intent.putExtra("category_name1", ctg_txt1.getText());
                        intent.putExtra("category_name2", ctg_txt2.getText());
                        intent.putExtra("category_name3", ctg_txt3.getText());
                        intent.putExtra("category_name4", ctg_txt4.getText());
                        intent.putExtra("category_name5", ctg_txt5.getText());
                        intent.putExtra("category_name6", ctg_txt6.getText());
                        intent.putExtra("category_name7", ctg_txt7.getText());
                        intent.putExtra("category_name8", ctg_txt8.getText());
                        intent.putExtra("click_category", ctg_txt1.getText());
                        startActivity(intent);
                    }
                });

                ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        category_name1 = ctg_dialog.getcategoryName();
                        ctg_txt1.setText(ctg_dialog.getcategoryName());
                    }
                });
            }
        });
        ctg_btn_2 = (Button) findViewById(R.id.ctg_btn2);
        ctg_btn_2_2 = (Button) findViewById(R.id.ctg_btn2_2);
        ctg_btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctg_dialog.show();
                ctg_btn_2.setVisibility(View.INVISIBLE);
                ctg_btn_2_2.setVisibility(View.VISIBLE);
                ctg_btn_2_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(OZCategoryActivity.this, OZnowActivity.class);
                        intent.putExtra("category_name1", ctg_txt1.getText());
                        intent.putExtra("category_name2", ctg_txt2.getText());
                        intent.putExtra("category_name3", ctg_txt3.getText());
                        intent.putExtra("category_name4", ctg_txt4.getText());
                        intent.putExtra("category_name5", ctg_txt5.getText());
                        intent.putExtra("category_name6", ctg_txt6.getText());
                        intent.putExtra("category_name7", ctg_txt7.getText());
                        intent.putExtra("category_name8", ctg_txt8.getText());
                        intent.putExtra("click_category", ctg_txt2.getText());
                        startActivity(intent);
                    }
                });

                ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        category_name2 = ctg_dialog.getcategoryName();
                        ctg_txt2.setText(ctg_dialog.getcategoryName());
                    }
                });
            }
        });
        ctg_btn_3 = (Button) findViewById(R.id.ctg_btn3);
        ctg_btn_3_3 = (Button) findViewById(R.id.ctg_btn3_3);
        ctg_btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctg_dialog.show();
                ctg_btn_3.setVisibility(View.INVISIBLE);
                ctg_btn_3_3.setVisibility(View.VISIBLE);
                ctg_btn_3_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(OZCategoryActivity.this, OZnowActivity.class);
                        intent.putExtra("category_name1", ctg_txt1.getText());
                        intent.putExtra("category_name2", ctg_txt2.getText());
                        intent.putExtra("category_name3", ctg_txt3.getText());
                        intent.putExtra("category_name4", ctg_txt4.getText());
                        intent.putExtra("category_name5", ctg_txt5.getText());
                        intent.putExtra("category_name6", ctg_txt6.getText());
                        intent.putExtra("category_name7", ctg_txt7.getText());
                        intent.putExtra("category_name8", ctg_txt8.getText());
                        intent.putExtra("click_category", ctg_txt3.getText());
                        startActivity(intent);
                    }
                });

                ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        category_name3 = ctg_dialog.getcategoryName();
                        ctg_txt3.setText(ctg_dialog.getcategoryName());
                    }
                });
            }
        });
        ctg_btn_4 = (Button) findViewById(R.id.ctg_btn4);
        ctg_btn_4_4 = (Button) findViewById(R.id.ctg_btn4_4);
        ctg_btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctg_dialog.show();
                ctg_btn_4.setVisibility(View.INVISIBLE);
                ctg_btn_4_4.setVisibility(View.VISIBLE);
                ctg_btn_4_4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(OZCategoryActivity.this, OZnowActivity.class);
                        intent.putExtra("category_name1", ctg_txt1.getText());
                        intent.putExtra("category_name2", ctg_txt2.getText());
                        intent.putExtra("category_name3", ctg_txt3.getText());
                        intent.putExtra("category_name4", ctg_txt4.getText());
                        intent.putExtra("category_name5", ctg_txt5.getText());
                        intent.putExtra("category_name6", ctg_txt6.getText());
                        intent.putExtra("category_name7", ctg_txt7.getText());
                        intent.putExtra("category_name8", ctg_txt8.getText());
                        intent.putExtra("click_category", ctg_txt4.getText());
                        startActivity(intent);
                    }
                });

                ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        category_name4 = ctg_dialog.getcategoryName();
                        ctg_txt4.setText(ctg_dialog.getcategoryName());
                    }
                });
            }
        });
        ctg_btn_5 = (Button) findViewById(R.id.ctg_btn5);
        ctg_btn_5_5 = (Button) findViewById(R.id.ctg_btn5_5);
        ctg_btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctg_dialog.show();
                ctg_btn_5.setVisibility(View.INVISIBLE);
                ctg_btn_5_5.setVisibility(View.VISIBLE);
                ctg_btn_5_5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(OZCategoryActivity.this, OZnowActivity.class);
                        intent.putExtra("category_name1", ctg_txt1.getText());
                        intent.putExtra("category_name2", ctg_txt2.getText());
                        intent.putExtra("category_name3", ctg_txt3.getText());
                        intent.putExtra("category_name4", ctg_txt4.getText());
                        intent.putExtra("category_name5", ctg_txt5.getText());
                        intent.putExtra("category_name6", ctg_txt6.getText());
                        intent.putExtra("category_name7", ctg_txt7.getText());
                        intent.putExtra("category_name8", ctg_txt8.getText());
                        intent.putExtra("click_category", ctg_txt5.getText());
                        startActivity(intent);
                    }
                });

                ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        category_name5 = ctg_dialog.getcategoryName();
                        ctg_txt5.setText(ctg_dialog.getcategoryName());
                    }
                });
            }
        });
        ctg_btn_6 = (Button) findViewById(R.id.ctg_btn6);
        ctg_btn_6_6 = (Button) findViewById(R.id.ctg_btn6_6);
        ctg_btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctg_dialog.show();
                ctg_btn_6.setVisibility(View.INVISIBLE);
                ctg_btn_6_6.setVisibility(View.VISIBLE);
                ctg_btn_6_6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(OZCategoryActivity.this, OZnowActivity.class);
                        intent.putExtra("category_name1", ctg_txt1.getText());
                        intent.putExtra("category_name2", ctg_txt2.getText());
                        intent.putExtra("category_name3", ctg_txt3.getText());
                        intent.putExtra("category_name4", ctg_txt4.getText());
                        intent.putExtra("category_name5", ctg_txt5.getText());
                        intent.putExtra("category_name6", ctg_txt6.getText());
                        intent.putExtra("category_name7", ctg_txt7.getText());
                        intent.putExtra("category_name8", ctg_txt8.getText());
                        intent.putExtra("click_category", ctg_txt6.getText());
                        startActivity(intent);
                    }
                });

                ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        category_name6 = ctg_dialog.getcategoryName();
                        ctg_txt6.setText(ctg_dialog.getcategoryName());
                    }
                });
            }
        });
        ctg_btn_7 = (Button) findViewById(R.id.ctg_btn7);
        ctg_btn_7_7 = (Button) findViewById(R.id.ctg_btn7_7);
        ctg_btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctg_dialog.show();
                ctg_btn_7.setVisibility(View.INVISIBLE);
                ctg_btn_7_7.setVisibility(View.VISIBLE);
                ctg_btn_7_7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(OZCategoryActivity.this, OZnowActivity.class);
                        intent.putExtra("category_name1", ctg_txt1.getText());
                        intent.putExtra("category_name2", ctg_txt2.getText());
                        intent.putExtra("category_name3", ctg_txt3.getText());
                        intent.putExtra("category_name4", ctg_txt4.getText());
                        intent.putExtra("category_name5", ctg_txt5.getText());
                        intent.putExtra("category_name6", ctg_txt6.getText());
                        intent.putExtra("category_name7", ctg_txt7.getText());
                        intent.putExtra("category_name8", ctg_txt8.getText());
                        intent.putExtra("click_category", ctg_txt7.getText());
                        startActivity(intent);
                    }
                });

                ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        category_name7 = ctg_dialog.getcategoryName();
                        ctg_txt7.setText(ctg_dialog.getcategoryName());
                    }
                });
            }
        });
        ctg_btn_8 = (Button) findViewById(R.id.ctg_btn8);
        ctg_btn_8_8 = (Button) findViewById(R.id.ctg_btn8_8);
        ctg_btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctg_dialog.show();
                ctg_btn_8.setVisibility(View.INVISIBLE);
                ctg_btn_8_8.setVisibility(View.VISIBLE);
                ctg_btn_8_8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(OZCategoryActivity.this, OZnowActivity.class);
                        intent.putExtra("category_name1", ctg_txt1.getText());
                        intent.putExtra("category_name2", ctg_txt2.getText());
                        intent.putExtra("category_name3", ctg_txt3.getText());
                        intent.putExtra("category_name4", ctg_txt4.getText());
                        intent.putExtra("category_name5", ctg_txt5.getText());
                        intent.putExtra("category_name6", ctg_txt6.getText());
                        intent.putExtra("category_name7", ctg_txt7.getText());
                        intent.putExtra("category_name8", ctg_txt8.getText());
                        intent.putExtra("click_category", ctg_txt8.getText());
                        startActivity(intent);
                    }
                });

                ctg_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        category_name8 = ctg_dialog.getcategoryName();
                        ctg_txt8.setText(ctg_dialog.getcategoryName());
                    }
                });
            }
        });
    }
}

