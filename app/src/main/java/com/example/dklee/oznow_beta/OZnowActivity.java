package com.example.dklee.oznow_beta;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TableRow;

public class OZnowActivity extends Activity implements View.OnClickListener {

    private EditText contentEt;
    private TableRow tb_category;
    private CheckBox checkBox_todo;
    private ContentDBHelper contentDBHelper;
    private String category_name;
    private String kind;
    private String category_color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oz_write);
        Log.d("Oznow", "메세지 onCreate");
        TabHost tab=(TabHost)findViewById(R.id.tabhost);
        tab.setup();;
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
        tb_category=(TableRow)findViewById(R.id.tb_category);
        kind="todo";
        Intent intent=getIntent();
        category_color=intent.getStringExtra("color");
        if(category_color.equals("red")){
            tb_category.setBackgroundResource(R.drawable.red_bar);
            SharedPreferences pref=getSharedPreferences("category",MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            category_name=pref.getString("c1_name", "");
        }else if(category_color.equals("orange")){
            tb_category.setBackgroundResource(R.drawable.orange_bar);
            SharedPreferences pref=getSharedPreferences("category",MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            category_name=pref.getString("c2_name", "");
        }else if(category_color.equals("yellow")){
            tb_category.setBackgroundResource(R.drawable.yellow_bar);
            SharedPreferences pref=getSharedPreferences("category",MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            category_name=pref.getString("c3_name", "");
        }else if(category_color.equals("lightgreen")){
            tb_category.setBackgroundResource(R.drawable.lime_bar);
            SharedPreferences pref=getSharedPreferences("category",MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            category_name=pref.getString("c4_name", "");
        }else if(category_color.equals("green")){
            tb_category.setBackgroundResource(R.drawable.green_bar);
            SharedPreferences pref=getSharedPreferences("category",MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            category_name=pref.getString("c5_name", "");
        }else if(category_color.equals("lightblue")){
            tb_category.setBackgroundResource(R.drawable.skyblue_bar);
            SharedPreferences pref=getSharedPreferences("category",MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            category_name=pref.getString("c6_name", "");
        }else if(category_color.equals("blue")){
            tb_category.setBackgroundResource(R.drawable.blue_bar);
            SharedPreferences pref=getSharedPreferences("category",MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            category_name=pref.getString("c7_name", "");
        }else if(category_color.equals("purple")){
            tb_category.setBackgroundResource(R.drawable.purple_bar);
            SharedPreferences pref=getSharedPreferences("category",MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            category_name=pref.getString("c8_name", "");
        }
    }

    @Override
    public void onClick(View v) {
        String content=contentEt.getText().toString();
        String bookmark="no";
        String sql="insert into ozContent(content, kind, bookmark, c_name, c_color) values(?,?,?,?,?)";
        SQLiteDatabase db=contentDBHelper.getWritableDatabase();
        db.execSQL(sql, new String[] {content, kind, bookmark, category_name, category_color});
        // 자장 후 전체 리스트로 돌아가도록 설정
        Intent intent=new Intent(OZnowActivity.this, AllListActivity.class);
        startActivity(intent);
    }
}

