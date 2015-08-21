package com.example.dklee.oznow_beta;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by kyounghee on 2015-08-12.
 */
public class AllListActivity extends Activity implements AdapterView.OnItemClickListener {
    private ListView listView;
    ContentDBHelper contentDBHelper = new ContentDBHelper(this);
    ArrayList<ContentVO> allList= new ArrayList<ContentVO>();
    private String category_name1;
    private String category_name2;
    private String category_name3;
    private String category_name4;
    private String category_name5;
    private String category_name6;
    private String category_name7;
    private String category_name8;
    private String category;
    private LinearLayout box;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oz_main);
        listView = (ListView) findViewById(R.id.allList);
        ImageButton categoryBtn = (ImageButton) findViewById(R.id.button_category);
        TextView textView_today=(TextView)findViewById(R.id.textView_today);
        GregorianCalendar today=new GregorianCalendar();
        textView_today.setText(today.get(today.MONTH) + 1 + " . " + today.get(today.DATE));
        box = (LinearLayout)findViewById(R.id.ctg_box);
        categoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllListActivity.this, OZCategoryActivity.class);
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
    }
    /**
     * todo나 note작성후 AllListActivity로 돌아오면 onCreate는 다시 실행되지 않는다.
     * 따라서 onResume에서 목록을 표현하도록 해 항상 업데이트 되도록 해야 한다.
     */
    @Override
    protected void onResume() {
        super.onResume();
        //db에 저장된 내용을 실질적으로 불러오는
        SQLiteDatabase db = contentDBHelper.getReadableDatabase();
        String sql = "select * from ozContent order by _id desc";
        Cursor cursor = db.rawQuery(sql, null);
        String content, kind, bookmark=null;
        int _id=0;
        while(cursor.moveToNext()) {
            _id = cursor.getInt(0);
            content = cursor.getString(1);
            kind = cursor.getString(2);
            bookmark=cursor.getString(3);
            category=cursor.getString(4);
            listView.setId(_id);
            allList.add(new ContentVO(_id, content, kind, bookmark, category));
        }
        Toast.makeText(this, category,Toast.LENGTH_SHORT).show();
        listView.setOnItemClickListener(this);
        CustomAdapter adapter=new CustomAdapter(this, R.layout.row_oz_main_item, allList);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setDividerHeight(2);
        Intent intent=getIntent();
        category_name1=intent.getStringExtra("category_name1");
        category_name2=intent.getStringExtra("category_name2");
        category_name3=intent.getStringExtra("category_name3");
        category_name4=intent.getStringExtra("category_name4");
        category_name5=intent.getStringExtra("category_name5");
        category_name6=intent.getStringExtra("category_name6");
        category_name7=intent.getStringExtra("category_name7");
        category_name8=intent.getStringExtra("category_name8");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv=(TextView)view;
        String content=tv.getText().toString();
    }


    private class CustomAdapter extends ArrayAdapter<ContentVO> implements View.OnClickListener {
        private ArrayList<ContentVO> items;
        private Context context;
        String content;

        public CustomAdapter(Context context, int textViewResourceId, ArrayList<ContentVO> objects) {
            super(context, textViewResourceId, objects);
            this.context = context;
            this.items=objects;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v=convertView;
            if(v==null){
                LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v=layoutInflater.inflate(R.layout.row_oz_main_item, null);
            }

            box = (LinearLayout)v.findViewById(R.id.ctg_box);
            /*if(getItem(position).getCategory().equals("red")){
                box.setBackgroundResource(R.drawable.red_bar);
            }else if(getItem(position).getCategory().equals("orange")){
                box.setBackgroundResource(R.drawable.orange_bar);
            }else if(getItem(position).getCategory().equals("yellow")){
                box.setBackgroundResource(R.drawable.yellow_bar);
            }else if(getItem(position).getCategory().equals("lightgreen")){
                box.setBackgroundResource(R.drawable.lime_bar);
            }else if(getItem(position).getCategory().equals("green")){
                box.setBackgroundResource(R.drawable.green_box);
            }else if(getItem(position).getCategory().equals("lightblue")){
                box.setBackgroundResource(R.drawable.skyblue_bar);
            }else if(getItem(position).getCategory().equals("blue")){
                box.setBackgroundResource(R.drawable.blue_bar);
            }else if(getItem(position).getCategory().equals("purple")){
                box.setBackgroundResource(R.drawable.purple_bar);
            }*/
            TextView tv=(TextView)v.findViewById(R.id.TextView_content);
            //textView hiddendata없나?
            tv.setText(getItem(position).getContent());
            tv.setOnClickListener(this);
            return v;

        }


        @Override
        public int getCount() {
            return super.getCount();
        }

        @Override
        public int getPosition(ContentVO item) {
            return super.getPosition(item);
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }

        @Override
        public ContentVO getItem(int position) {
            return super.getItem(position);
        }




        @Override
        public void onClick(View v) {
            int viewId=v.getId();
            String content=null;
            if(viewId==R.id.TextView_content){
                TextView tv=(TextView)v;
                content=tv.getText().toString();
            }
            /*
            if(viewId==R.id.Button_delete){
                TextView tv=(TextView)findViewById(R.id.TextView_content);
                content=tv.getText().toString();
                SQLiteDatabase db = contentDBHelper.getWritableDatabase();
                String sql="delete from ozContent where content='"+content+"'";
                db.execSQL(sql);
                Intent intent=new Intent(AllListActivity.this, AllListActivity.class);
                startActivity(intent);
            }
            if(viewId==R.id.Button_bookmark){
                TextView tv=(TextView)findViewById(R.id.TextView_content);
                content=tv.getText().toString();
                SQLiteDatabase db = contentDBHelper.getWritableDatabase();
                String sql = "update ozContent set bookmark='"+"favorite"+"' where content='"+content+"'";
                db.execSQL(sql);
            }
            if(viewId==R.id.Button_update){
                //이게 todo인지 note인지 구분이 없다... 어떻게하지?
                TextView tv=(TextView)findViewById(R.id.TextView_content);
                content=tv.getText().toString();
                Intent intent=new Intent(AllListActivity.this, OZnowActivity.class);
                intent.putExtra("content",content);
                startActivity(intent);

            }*/
        }
    }
}
