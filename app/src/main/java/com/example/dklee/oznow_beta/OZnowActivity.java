package com.example.dklee.oznow_beta;

import android.app.Activity;
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

public class OZnowActivity extends Activity implements View.OnClickListener {

    private EditText contentEt;
    private LinearLayout linearLayout;
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
        contentDBHelper=new ContentDBHelper(this);
        contentEt=(EditText)findViewById(R.id.editText_todo);
        Button saveBtn=(Button)findViewById(R.id.button_save);
        Button todoWriteBtn=(Button)findViewById(R.id.button_todoWrite);
        Button noteWriteBtn=(Button)findViewById(R.id.button_noteWrite);
        checkBox_todo=(CheckBox)findViewById(R.id.checkbox_todo);
        kind="todo";
        Intent intent=getIntent();
        category_color=intent.getStringExtra("color");
        if(category_color.equals("red")){
            SharedPreferences pref=getSharedPreferences("category",MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            category_name=pref.getString("c1_name", "");
        }else if(category_color.equals("orange")){
            SharedPreferences pref=getSharedPreferences("category",MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            category_name=pref.getString("c2_name", "");
        }else if(category_color.equals("yellow")){
            SharedPreferences pref=getSharedPreferences("category",MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            category_name=pref.getString("c3_name", "");
        }else if(category_color.equals("lightgreen")){
            SharedPreferences pref=getSharedPreferences("category",MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            category_name=pref.getString("c4_name", "");
        }else if(category_color.equals("green")){
            SharedPreferences pref=getSharedPreferences("category",MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            category_name=pref.getString("c5_name", "");
        }else if(category_color.equals("lightblue")){
            SharedPreferences pref=getSharedPreferences("category",MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            category_name=pref.getString("c6_name", "");
        }else if(category_color.equals("blue")){
            SharedPreferences pref=getSharedPreferences("category",MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            category_name=pref.getString("c7_name", "");
        }else if(category_color.equals("purple")){
            SharedPreferences pref=getSharedPreferences("category",MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            category_name=pref.getString("c8_name", "");
        }
        saveBtn.setOnClickListener(this);
        noteWriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kind="note";
                linearLayout = (LinearLayout) findViewById(R.id.dynamicArea);
                checkBox_todo.setVisibility(View.INVISIBLE);
                contentEt.setVisibility(View.GONE);
                EditText editText_note = new EditText(OZnowActivity.this);
                editText_note.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                editText_note.setHint("text를 입력해주세요");
                linearLayout.addView(editText_note);
                contentEt=editText_note;

            }
        });
        todoWriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_todo.setVisibility(View.VISIBLE);
                contentEt.setVisibility(View.VISIBLE);
                contentEt.setHint("text를 입력해주세요");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        contentEt=(EditText)findViewById(R.id.editText_todo);
        CheckBox todoCheck=new CheckBox(OZnowActivity.this);
        Intent intent=getIntent();
        String content=intent.getStringExtra("content");
        if(content!=null) {
            contentEt.setText(content);
        }
    }
    @Override
    public void onClick(View v) {
        String content=contentEt.getText().toString();
        String bookmark="no";
        Log.d("kind", kind);
        String sql="insert into ozContent(content, kind, bookmark, c_name, c_color) values(?,?,?,?,?)";
        SQLiteDatabase db=contentDBHelper.getWritableDatabase();
        db.execSQL(sql, new String[] {content, kind, bookmark, category_name, category_color});
        // 자장 후 전체 리스트로 돌아가도록 설정
        Intent intent=new Intent(OZnowActivity.this, AllListActivity.class);
        startActivity(intent);
    }
}

