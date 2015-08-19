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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oz_main);
        listView = (ListView) findViewById(R.id.allList);
        Button categoryBtn = (Button) findViewById(R.id.button_category);
        TextView textView_today=(TextView)findViewById(R.id.textView_today);
        GregorianCalendar today=new GregorianCalendar();
        textView_today.setText(today.get(today.MONTH) + 1 + " . " + today.get(today.DATE));
        categoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllListActivity.this, OZ_category_Activity.class);
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
            listView.setId(_id);
            allList.add(new ContentVO(_id, content, kind, bookmark));
        }
        listView.setOnItemClickListener(this);
        CustomAdapter adapter=new CustomAdapter(this, R.layout.oz_main_item, allList);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
        Log.d("listview의 id", String.valueOf(listView.getId()));
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setDivider(new ColorDrawable(Color.RED));
        listView.setDividerHeight(2);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv=(TextView)view;
        String content=tv.getText().toString();
        Toast.makeText(this,content,Toast.LENGTH_SHORT).show();
    }


    private class CustomAdapter extends ArrayAdapter<ContentVO> implements View.OnClickListener{
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
                v=layoutInflater.inflate(R.layout.oz_main_item, null);
            }
            TextView tv=(TextView)v.findViewById(R.id.TextView_content);
            //textView hiddendata없나?
            tv.setText(getItem(position).getContent());
            tv.setOnClickListener(this);
            Button bookBtn=(Button)v.findViewById(R.id.Button_bookmark);
            bookBtn.setOnClickListener(this);

            Button delBtn=(Button)v.findViewById(R.id.Button_delete);
            delBtn.setOnClickListener(this);

            Button upBtn=(Button)v.findViewById(R.id.Button_update);
            upBtn.setOnClickListener(this);

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
                Log.d("connnnn", content);
            }
            if(viewId==R.id.Button_delete){
                TextView tv=(TextView)findViewById(R.id.TextView_content);
                content=tv.getText().toString();
                Log.d("connnnn", content);
                Log.d("ddddd","dele");
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

            }
        }
    }
}
