package com.example.dklee.oznow_beta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class OZnowActivity extends AppCompatActivity {

    private EditText contentEt;
    private LinearLayout linearLayout;
    private CheckBox checkBox_todo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oz_write);
        contentEt=(EditText)findViewById(R.id.editText_todo);
        Button saveBtn=(Button)findViewById(R.id.button_save);
        Button todoWriteBtn=(Button)findViewById(R.id.button_todoWrite);
        Button noteWriteBtn=(Button)findViewById(R.id.button_noteWrite);
        checkBox_todo=(CheckBox)findViewById(R.id.checkbox_todo);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFile();
                // 자장 후 전체 리스트로 돌아가도록 설정
                Intent intent=new Intent(OZnowActivity.this,AllListActivity.class);
                startActivity(intent);
                finish();
            }
        });
        noteWriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout = (LinearLayout) findViewById(R.id.dynamicArea);
                checkBox_todo.setVisibility(View.GONE);
                contentEt.setVisibility(View.GONE);
                EditText editText_note = new EditText(OZnowActivity.this);
                editText_note.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                linearLayout.addView(editText_note);
                contentEt=editText_note;

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        contentEt=(EditText)findViewById(R.id.editText_todo);
        CheckBox todoCheck=new CheckBox(OZnowActivity.this);
        //contentEt.append(todoCheck.toString());
    }

    public void saveFile(){
        /*String content=null;
        if(todoEt.getText().toString()==null){
            content=noteEt.getText().toString();
        }else{
            content=todoEt.getText().toString();
        }*/
        String content=contentEt.getText().toString();
        try {
            FileOutputStream fos=openFileOutput(content,MODE_PRIVATE);// 후에 카테고리 네임으로
            PrintWriter pw= new PrintWriter(fos);
            pw.println(content);
            pw.close();
            Toast.makeText(this, "todo 저장 ok", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
