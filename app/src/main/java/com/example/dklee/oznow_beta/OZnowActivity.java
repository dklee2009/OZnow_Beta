package com.example.dklee.oznow_beta;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TableRow;

public class OZnowActivity extends Activity {
    private EditText et_todo;
    private EditText et_note;
    private ContentDBHelper contentDBHelper;
    private String category_name;
    private String kind;
    private String category_color;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oz_write);
        Log.d("Oznow", "메세지 onCreate");
        et_note=(EditText)findViewById(R.id.et_note);
        et_todo=(EditText)findViewById(R.id.et_todo);
        // todo checkbox 정보를 sharedPreference에 담음
      /*  SharedPreferences check_pref = getSharedPreferences("checkbox", MODE_PRIVATE);
        SharedPreferences.Editor check_editor = check_pref.edit();
        Boolean checked=false;
        CheckBox cb_todo=(CheckBox)findViewById(R.id.cb_todo);
        checked=cb_todo.isChecked();
        check_editor.putBoolean("checkornot", checked);
        check_editor.commit();*/
        //tab 정보를 불러옴
        TabHost tab=(TabHost)findViewById(R.id.tabhost);
        tab.setup();
        TabHost.TabSpec spec=tab.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("To do");
        tab.addTab(spec);
        TabHost.TabSpec spec2=tab.newTabSpec("tag2");
        spec2.setContent(R.id.tab2);
        spec2.setIndicator("Note");
        tab.addTab(spec2);
        tab.setCurrentTab(0);
        contentDBHelper=new ContentDBHelper(this);
        final TableRow tb_category_todo=(TableRow)findViewById(R.id.tb_category_todo);
        TableRow tb_category_note=(TableRow)findViewById(R.id.tb_category_note);
        kind="todo";
        Intent intent=getIntent();
        category_color=intent.getStringExtra("color");
        if(category_color.equals("red")){
            tb_category_todo.setBackgroundResource(R.drawable.red_bar);
            tb_category_note.setBackgroundResource(R.drawable.red_bar);
            SharedPreferences pref=getSharedPreferences("category", MODE_PRIVATE);
            category_name=pref.getString("c1_name", "");
        }else if(category_color.equals("orange")){
            tb_category_todo.setBackgroundResource(R.drawable.orange_bar);
            tb_category_note.setBackgroundResource(R.drawable.orange_bar);
            SharedPreferences pref=getSharedPreferences("category", MODE_PRIVATE);
            category_name=pref.getString("c2_name", "");
        }else if(category_color.equals("yellow")){
            tb_category_todo.setBackgroundResource(R.drawable.yellow_bar);
            tb_category_note.setBackgroundResource(R.drawable.yellow_bar);
            SharedPreferences pref=getSharedPreferences("category", MODE_PRIVATE);
            category_name=pref.getString("c3_name", "");
        }else if(category_color.equals("lightgreen")){
            tb_category_todo.setBackgroundResource(R.drawable.lime_bar);
            tb_category_note.setBackgroundResource(R.drawable.lime_bar);
            SharedPreferences pref=getSharedPreferences("category", MODE_PRIVATE);
            category_name=pref.getString("c4_name", "");
        }else if(category_color.equals("green")){
            tb_category_todo.setBackgroundResource(R.drawable.green_bar);
            tb_category_note.setBackgroundResource(R.drawable.green_bar);
            SharedPreferences pref=getSharedPreferences("category", MODE_PRIVATE);
            category_name=pref.getString("c5_name", "");
        }else if(category_color.equals("lightblue")){
            tb_category_todo.setBackgroundResource(R.drawable.skyblue_bar);
            tb_category_note.setBackgroundResource(R.drawable.skyblue_bar);
            SharedPreferences pref=getSharedPreferences("category", MODE_PRIVATE);
            category_name=pref.getString("c6_name", "");
        }else if(category_color.equals("blue")){
            tb_category_todo.setBackgroundResource(R.drawable.blue_bar);
            tb_category_note.setBackgroundResource(R.drawable.blue_bar);
            SharedPreferences pref=getSharedPreferences("category", MODE_PRIVATE);
            category_name=pref.getString("c7_name", "");
        }else if(category_color.equals("purple")){
            tb_category_todo.setBackgroundResource(R.drawable.purple_bar);
            tb_category_note.setBackgroundResource(R.drawable.purple_bar);
            SharedPreferences pref=getSharedPreferences("category", MODE_PRIVATE);
            category_name=pref.getString("c8_name", "");
        }
        Button btn_save=(Button)findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=null;
                if(et_note.getText().toString().equals("")){
                    content=et_todo.getText().toString();
                }else if(et_todo.getText().toString().equals("")){
                    content=et_note.getText().toString();
                }
                String bookmark="no";
                String sql="insert into ozContent(content, kind, bookmark, c_name, c_color) values(?,?,?,?,?)";
                SQLiteDatabase db=contentDBHelper.getWritableDatabase();
                db.execSQL(sql, new String[] {content, kind, bookmark, category_name, category_color});
                // 자장 후 전체 리스트로 돌아가도록 설정
                Intent intent=new Intent(OZnowActivity.this, AllListActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button btn_category_modi=(Button)findViewById(R.id.btn_category_modi);
        btn_category_modi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OZnowActivity.this, OZCategoryActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button btn_subtask=(Button)findViewById(R.id.btn_subtask);
        btn_subtask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cb_subtask=new CheckBox(OZnowActivity.this);
                LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(200, 200);
                cb_subtask.setLayoutParams(layoutParams);
                //cb_subtask.setPadding(60,200,0,0);
                EditText et_subtask=new EditText(OZnowActivity.this);
                //et_subtask.setPadding(80,200,0,0);
                tb_category_todo.addView(cb_subtask);
                tb_category_todo.addView(et_subtask);
            }
        });
    }
}

