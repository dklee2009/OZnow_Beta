package com.example.dklee.oznow_beta;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by kyounghee on 2015-08-12.
 */
public class AllListActivity extends ActionBarActivity  {
    private ListView allList_view;
    private ContentDBManager contentDBManager;
    private DrawerLayout mypage_drawer;
    private ActionBarDrawerToggle mypage_drawer_toggle;

    String [] drawer_str={"해시태그","휴지통"};

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mypage_drawer_toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mypage_drawer_toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mypage_drawer_toggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oz_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Log.d("AllList", "meg onCreate");
        contentDBManager =new ContentDBManager(getApplicationContext());
        allList_view = (ListView) findViewById(R.id.allList);
        mypage_drawer=(DrawerLayout)findViewById(R.id.drawerlayout);
        ImageButton categoryBtn = (ImageButton) findViewById(R.id.btn_category);
        TextView txt_today=(TextView)findViewById(R.id.txt_today);
        ListView drawer_list=(ListView)findViewById(R.id.drawer);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,drawer_str);
        drawer_list.setAdapter(arrayAdapter);
        mypage_drawer_toggle=new ActionBarDrawerToggle(this, mypage_drawer, R.string.mypage_close, R.string.mypage_open){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };
        mypage_drawer.setDrawerListener(mypage_drawer_toggle);
        //오늘의 날짜 표시
        Calendar calendar=Calendar.getInstance();
        int month=calendar.get(Calendar.MONTH);
        int date=calendar.get(Calendar.DATE);
        int count_day=calendar.get(Calendar.DAY_OF_WEEK);
        String day=null;
        switch (count_day){
            case Calendar.MONDAY:
                day="Mon";
                break;
            case Calendar.TUESDAY:
                day="Tue";
                break;
            case Calendar.WEDNESDAY:
                day="Wed";
                break;
            case Calendar.THURSDAY:
                day="Thu";
                break;
            case Calendar.FRIDAY:
                day="Fri";
                break;
            case Calendar.SATURDAY:
                day="Sat";
                break;
            case Calendar.SUNDAY:
                day="Sun";
                break;
        }
        txt_today.setText(month+" . "+date+" . "+day);
        categoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllListActivity.this, OZCategoryActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ArrayList<ContentVO> allList= new ArrayList<ContentVO>();
        //db에 저장된 내용을 실질적으로 불러오는
        SQLiteDatabase db = contentDBManager.getReadableDatabase();
        String sql = "select * from OZnow order by _id desc";
        Cursor cursor = db.rawQuery(sql, null);
        String content, kind, bookmark, c_name, c_color=null;
        int id=0;
        while(cursor.moveToNext()) {
            id = cursor.getInt(0);
            content = cursor.getString(1);
            kind = cursor.getString(2);
            bookmark=cursor.getString(3);
            c_name=cursor.getString(4);
            c_color=cursor.getString(5);
            Log.d("db에 저장된 정보", id+" "+content+" "+kind+" "+bookmark+" "+c_name+" "+c_color);
            allList.add(new ContentVO(id, content, kind, bookmark, c_name, c_color));
        }
        CustomAdapter adapter=new CustomAdapter(this, R.layout.row_oz_main_item, allList);
        adapter.notifyDataSetChanged();
        allList_view.setAdapter(adapter);
        allList_view.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        allList_view.setDividerHeight(2);
        allList_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private class CustomAdapter extends ArrayAdapter<ContentVO> implements View.OnClickListener {
        ArrayList<ContentVO> items;
        Context context;
        int id;

        public CustomAdapter(Context context, int textViewResourceId, ArrayList<ContentVO> objects) {
            super(context, textViewResourceId, objects);
            this.context = context;
            this.items=objects;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v=convertView;
            final int f_position=position;
            if(v==null){
                LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v=layoutInflater.inflate(R.layout.row_oz_main_item, null);
            }
            Button btn_del=(Button)v.findViewById(R.id.Button_delete);
            CheckBox cb_listitem=(CheckBox)v.findViewById(R.id.listItem_check);
            TextView tv_content=(TextView)v.findViewById(R.id.TextView_content);
            btn_del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    id=getItem(f_position).getId();
                    Log.d("선택한 해당 content의 아이디", String.valueOf(id));
                    SQLiteDatabase db = contentDBManager.getWritableDatabase();
                    String sql="delete from OZnow where _id="+id;
                    db.execSQL(sql);
                    Intent intent=new Intent(AllListActivity.this, AllListActivity.class);
                    startActivity(intent);
                }
            });
            if(getItem(position).getKind().equals("note")){
                cb_listitem.setVisibility(View.INVISIBLE);
            }else{
                cb_listitem.setVisibility(View.VISIBLE);
            }
            LinearLayout box = (LinearLayout)v.findViewById(R.id.ctg_box);
            if(getItem(position).getC_color().equals("red")){
                box.setBackgroundResource(R.drawable.red_bar);
            }else if(getItem(position).getC_color().equals("orange")){
                box.setBackgroundResource(R.drawable.orange_bar);
            }else if(getItem(position).getC_color().equals("yellow")){
                box.setBackgroundResource(R.drawable.yellow_bar);
            }else if(getItem(position).getC_color().equals("lightgreen")){
                box.setBackgroundResource(R.drawable.lime_bar);
            }else if(getItem(position).getC_color().equals("green")){
                box.setBackgroundResource(R.drawable.green_bar);
            }else if(getItem(position).getC_color().equals("lightblue")){
                box.setBackgroundResource(R.drawable.skyblue_bar);
            }else if(getItem(position).getC_color().equals("blue")){
                box.setBackgroundResource(R.drawable.blue_bar);
            }else if(getItem(position).getC_color().equals("purple")){
                box.setBackgroundResource(R.drawable.purple_bar);
            }
            box.setOnClickListener(this);
            //id=getPosition(getItem(position));
            id=getItem(position).getId();
            //id=(int)getItemId(position);
            //Toast.makeText(getApplicationContext(),String.valueOf(id),Toast.LENGTH_SHORT).show();
            tv_content.setText(getItem(position).getContent());
            return v;
        }
        @Override
        public ContentVO getItem(int position) {
            return super.getItem(position);
        }

        @Override
        public void onClick(View v) {
            int viewId=v.getId();
            if(viewId==R.id.ctg_box){
                //Toast.makeText(AllListActivity.this, "먹히냥", Toast.LENGTH_LONG).show();
                //여기에다 눌렀을시 삭제 수정 버튼 뜨도록!!
            }else if(viewId==R.id.Button_delete){

            }
        }
    }
}

