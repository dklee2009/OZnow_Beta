package com.example.dklee.oznow_beta;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class OZnowActivity extends Activity {
    private EditText et_todo;
    private EditText et_note;
    private ContentDBHelper contentDBHelper;
    private String category_name;
    private String kind;
    private String category_color;
    private TableRow tr1, tr2, tr3, tr4, tr5, tr6, tr7, tr8, tr9, tr10;
    private EditText et_sub1, et_sub2, et_sub3, et_sub4, et_sub5, et_sub6, et_sub7, et_sub8, et_sub9, et_sub10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oz_write);
        Log.d("Oznow", "메세지 onCreate");
        tr1 = (TableRow) findViewById(R.id.tr1);
        tr2 = (TableRow) findViewById(R.id.tr2);
        tr3 = (TableRow) findViewById(R.id.tr3);
        tr4 = (TableRow) findViewById(R.id.tr4);
        tr5 = (TableRow) findViewById(R.id.tr5);
        tr6 = (TableRow) findViewById(R.id.tr6);
        tr7 = (TableRow) findViewById(R.id.tr7);
        tr8 = (TableRow) findViewById(R.id.tr8);
        tr9 = (TableRow) findViewById(R.id.tr9);
        tr10 = (TableRow) findViewById(R.id.tr10);
        et_sub1 = (EditText) findViewById(R.id.et_sub1);
        et_sub2 = (EditText) findViewById(R.id.et_sub2);
        et_sub3 = (EditText) findViewById(R.id.et_sub3);
        et_sub4 = (EditText) findViewById(R.id.et_sub4);
        et_sub5 = (EditText) findViewById(R.id.et_sub5);
        et_sub6 = (EditText) findViewById(R.id.et_sub6);
        et_sub7 = (EditText) findViewById(R.id.et_sub7);
        et_sub8 = (EditText) findViewById(R.id.et_sub8);
        et_sub9 = (EditText) findViewById(R.id.et_sub9);
        et_sub10 = (EditText) findViewById(R.id.et_sub10);
        tr1.setVisibility(View.INVISIBLE);
        tr2.setVisibility(View.INVISIBLE);
        tr3.setVisibility(View.INVISIBLE);
        tr4.setVisibility(View.INVISIBLE);
        tr5.setVisibility(View.INVISIBLE);
        tr6.setVisibility(View.INVISIBLE);
        tr7.setVisibility(View.INVISIBLE);
        tr8.setVisibility(View.INVISIBLE);
        tr9.setVisibility(View.INVISIBLE);
        tr10.setVisibility(View.INVISIBLE);
        et_note = (EditText) findViewById(R.id.et_note);
        et_todo = (EditText) findViewById(R.id.et_todo);
        //tab 정보를 불러옴
        TabHost tab = (TabHost) findViewById(R.id.tabhost);
        tab.setup();
        TabHost.TabSpec spec = tab.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("To do");
        tab.addTab(spec);
        TabHost.TabSpec spec2 = tab.newTabSpec("tag2");
        spec2.setContent(R.id.tab2);
        spec2.setIndicator("Note");
        tab.addTab(spec2);
        tab.setCurrentTab(0);
        contentDBHelper = new ContentDBHelper(this);
        TableLayout tb_category_todo = (TableLayout) findViewById(R.id.tb_category_todo);
        TableRow tb_category_note = (TableRow) findViewById(R.id.tb_category_note);
        kind = "todo";
        Intent intent = getIntent();
        category_color = intent.getStringExtra("color");
        if (category_color.equals("red")) {
            tb_category_todo.setBackgroundResource(R.drawable.red_bar);
            tb_category_note.setBackgroundResource(R.drawable.red_bar);
            SharedPreferences pref = getSharedPreferences("category", MODE_PRIVATE);
            category_name = pref.getString("c1_name", "");
        } else if (category_color.equals("orange")) {
            tb_category_todo.setBackgroundResource(R.drawable.orange_bar);
            tb_category_note.setBackgroundResource(R.drawable.orange_bar);
            SharedPreferences pref = getSharedPreferences("category", MODE_PRIVATE);
            category_name = pref.getString("c2_name", "");
        } else if (category_color.equals("yellow")) {
            tb_category_todo.setBackgroundResource(R.drawable.yellow_bar);
            tb_category_note.setBackgroundResource(R.drawable.yellow_bar);
            SharedPreferences pref = getSharedPreferences("category", MODE_PRIVATE);
            category_name = pref.getString("c3_name", "");
        } else if (category_color.equals("lightgreen")) {
            tb_category_todo.setBackgroundResource(R.drawable.lime_bar);
            tb_category_note.setBackgroundResource(R.drawable.lime_bar);
            SharedPreferences pref = getSharedPreferences("category", MODE_PRIVATE);
            category_name = pref.getString("c4_name", "");
        } else if (category_color.equals("green")) {
            tb_category_todo.setBackgroundResource(R.drawable.green_bar);
            tb_category_note.setBackgroundResource(R.drawable.green_bar);
            SharedPreferences pref = getSharedPreferences("category", MODE_PRIVATE);
            category_name = pref.getString("c5_name", "");
        } else if (category_color.equals("lightblue")) {
            tb_category_todo.setBackgroundResource(R.drawable.skyblue_bar);
            tb_category_note.setBackgroundResource(R.drawable.skyblue_bar);
            SharedPreferences pref = getSharedPreferences("category", MODE_PRIVATE);
            category_name = pref.getString("c6_name", "");
        } else if (category_color.equals("blue")) {
            tb_category_todo.setBackgroundResource(R.drawable.blue_bar);
            tb_category_note.setBackgroundResource(R.drawable.blue_bar);
            SharedPreferences pref = getSharedPreferences("category", MODE_PRIVATE);
            category_name = pref.getString("c7_name", "");
        } else if (category_color.equals("purple")) {
            tb_category_todo.setBackgroundResource(R.drawable.purple_bar);
            tb_category_note.setBackgroundResource(R.drawable.purple_bar);
            SharedPreferences pref = getSharedPreferences("category", MODE_PRIVATE);
            category_name = pref.getString("c8_name", "");
        }
        Button btn_save = (Button) findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = null;
                if (et_note.getText().toString().equals("")) {
                    content = et_todo.getText().toString();
                } else if (et_todo.getText().toString().equals("")) {
                    content = et_note.getText().toString();
                } else {
                    Toast.makeText(OZnowActivity.this, "텍스트를 입력하세요", Toast.LENGTH_SHORT).show();
                }
                String bookmark = "no";
                String sql = "insert into ozContent(content, kind, bookmark, c_name, c_color) values(?,?,?,?,?)";
                SQLiteDatabase db = contentDBHelper.getWritableDatabase();
                db.execSQL(sql, new String[]{content, kind, bookmark, category_name, category_color});
                // 자장 후 전체 리스트로 돌아가도록 설정
                Intent intent = new Intent(OZnowActivity.this, AllListActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button btn_category_modi = (Button) findViewById(R.id.btn_category_modi);
        btn_category_modi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OZnowActivity.this, OZCategoryActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button btn_subtask = (Button) findViewById(R.id.btn_subtask);
        btn_subtask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               tr1.setVisibility(View.VISIBLE);
                String sub1=et_sub1.getText().toString();
                if(!et_sub1.getText().toString().equals("")){
                    tr2.setVisibility(View.VISIBLE);
                    if(!et_sub2.getText().toString().equals("")){
                        tr3.setVisibility(View.VISIBLE);
                        if(!et_sub3.getText().toString().equals("")){
                            tr4.setVisibility(View.VISIBLE);
                            if(!et_sub4.getText().toString().equals("")){
                                tr5.setVisibility(View.VISIBLE);
                                if(!et_sub5.getText().toString().equals("")){
                                    tr6.setVisibility(View.VISIBLE);
                                    if(!et_sub6.getText().toString().equals("")){
                                        tr7.setVisibility(View.VISIBLE);
                                        if(!et_sub7.getText().toString().equals("")){
                                            tr8.setVisibility(View.VISIBLE);
                                            if(!et_sub8.getText().toString().equals("")){
                                                tr9.setVisibility(View.VISIBLE);
                                                if(!et_sub9.getText().toString().equals("")){
                                                    tr10.setVisibility(View.VISIBLE);
                                                    if(!et_sub10.getText().toString().equals("")){
                                                        Toast.makeText(OZnowActivity.this, "subtask는 10개까지 등록 할 수 있습니다.", Toast.LENGTH_LONG).show();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
        Button btn_time=(Button)findViewById(R.id.btn_time);
        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OZnowActivity.this, OZTimeActivity.class);
                startActivity(intent);
            }
        });
    }
}

