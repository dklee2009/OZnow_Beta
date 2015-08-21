package com.example.dklee.oznow_beta;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class OZnowActivity extends AppCompatActivity {

    private EditText contentEt;
    private LinearLayout linearLayout;
    private CheckBox checkBox_todo;
    ContentDBHelper contentDBHelper;
    private String category_name1;
    private String category_name2;
    private String category_name3;
    private String category_name4;
    private String category_name5;
    private String category_name6;
    private String category_name7;
    private String category_name8;
    private String click_category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oz_write);
        contentDBHelper=new ContentDBHelper(this);
        contentEt=(EditText)findViewById(R.id.editText_todo);
        Button saveBtn=(Button)findViewById(R.id.button_save);
        Button todoWriteBtn=(Button)findViewById(R.id.button_todoWrite);
        Button noteWriteBtn=(Button)findViewById(R.id.button_noteWrite);
        checkBox_todo=(CheckBox)findViewById(R.id.checkbox_todo);
        Intent intent=getIntent();
        if(intent.getStringExtra("category_name1")!=null){
            category_name1=intent.getStringExtra("category_name1");
        }
        if(intent.getStringExtra("category_name2")!=null){
            category_name2=intent.getStringExtra("category_name2");
        }
        if(intent.getStringExtra("category_name3")!=null){
            category_name3=intent.getStringExtra("category_name3");
        }
        if(intent.getStringExtra("category_name4")!=null){
            category_name4=intent.getStringExtra("category_name4");
        }
        if(intent.getStringExtra("category_name5")!=null){
            category_name5=intent.getStringExtra("category_name5");
        }
        if(intent.getStringExtra("category_name6")!=null){
            category_name6=intent.getStringExtra("category_name6");
        }
        if(intent.getStringExtra("category_name7")!=null){
            category_name7=intent.getStringExtra("category_name7");
        }
        if(intent.getStringExtra("category_name8")!=null){
            category_name8=intent.getStringExtra("category_name8");
        }
        click_category=intent.getStringExtra("click_category");
        saveBtn.setOnClickListener(new View.OnClickListener() {//익명함수 사용
            @Override
            public void onClick(View v) {
                String content=contentEt.getText().toString();
                String kind=null;
                String bookmark="no";
                if(contentEt.getHint()!="note를 입력해주세요"){
                    kind="todo";
                }
                else{
                    kind="note";
                }
                String sql="insert into ozContent(content, kind, bookmark, category) values(?,?,?,?)";
                SQLiteDatabase db=contentDBHelper.getWritableDatabase();
                db.execSQL(sql, new String[] {content, kind, bookmark, click_category});
                // 자장 후 전체 리스트로 돌아가도록 설정
                Intent intent=new Intent(OZnowActivity.this,AllListActivity.class);
                if(category_name1!=null){
                    intent.putExtra("category_name1", category_name1);
                }
                if(category_name2!=null){
                    intent.putExtra("category_name2", category_name2);
                }
                if(category_name3!=null){
                    intent.putExtra("category_name3", category_name3);
                }
                if(category_name4!=null){
                    intent.putExtra("category_name4", category_name4);
                }
                if(category_name5!=null){
                    intent.putExtra("category_name5", category_name5);
                }
                if(category_name6!=null){
                    intent.putExtra("category_name6", category_name6);
                }
                if(category_name7!=null){
                    intent.putExtra("category_name7", category_name7);
                }
                if(category_name8!=null){
                    intent.putExtra("category_name8", category_name8);
                }
                startActivity(intent);
            }
        });
        noteWriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout = (LinearLayout) findViewById(R.id.dynamicArea);
                checkBox_todo.setVisibility(View.INVISIBLE);
                contentEt.setVisibility(View.GONE);
                EditText editText_note = new EditText(OZnowActivity.this);
                editText_note.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                editText_note.setHint("note를 입력해주세요");
                linearLayout.addView(editText_note);
                contentEt=editText_note;

            }
        });
        todoWriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_todo.setVisibility(View.VISIBLE);
                contentEt.setVisibility(View.VISIBLE);
                contentEt.setHint("todo를 입력해주세요");
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
        if(content!=null){
            contentEt.setText(content);
        }
        //contentEt.append(todoCheck.toString());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
