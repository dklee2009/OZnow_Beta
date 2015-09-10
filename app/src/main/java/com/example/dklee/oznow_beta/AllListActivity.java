package com.example.dklee.oznow_beta;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by kyounghee on 2015-08-12.
 */
public class AllListActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private ContentDBHelper contentDBHelper;
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
        Log.d("AllList", "meg onCreate");//Log 정보
        contentDBHelper=new ContentDBHelper(this);// db 연결
        listView = (ListView) findViewById(R.id.allList);// listView alllist
        ImageButton categoryBtn = (ImageButton) findViewById(R.id.btn_category);
        TextView txt_today=(TextView)findViewById(R.id.txt_today);
        mypage_drawer=(DrawerLayout)findViewById(R.id.drawerlayout);
        ListView list=(ListView)findViewById(R.id.drawer);//drawer의 리스트뷰
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,drawer_str);
        list.setAdapter(arrayAdapter);
        mypage_drawer_toggle=new ActionBarDrawerToggle(this, mypage_drawer, R.string.close, R.string.open){
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
        //mypage_drawer.closeDrawer(listView);
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
        SQLiteDatabase db = contentDBHelper.getReadableDatabase();
        String sql = "select * from ozContent order by _id desc";
        Cursor cursor = db.rawQuery(sql, null);
        String content, kind, bookmark, c_name, c_color=null;
        int _id=0;
        while(cursor.moveToNext()) {
            _id = cursor.getInt(0);
            content = cursor.getString(1);
            kind = cursor.getString(2);
            bookmark=cursor.getString(3);
            c_name=cursor.getString(4);
            c_color=cursor.getString(5);
            allList.add(new ContentVO(_id, content, kind, bookmark, c_name, c_color));
        }
        listView.setOnItemClickListener(this);
        CustomAdapter adapter=new CustomAdapter(this, R.layout.row_oz_main_item, allList);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setDividerHeight(2);
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
            Button btn_del=(Button)v.findViewById(R.id.Button_delete);
            CheckBox cb_listitem=(CheckBox)v.findViewById(R.id.listItem_check);
            TextView tv_content=(TextView)v.findViewById(R.id.TextView_content);
            btn_del.setOnClickListener(this);
            if(getItem(position).getKind().equals("note")){
                cb_listitem.setVisibility(View.INVISIBLE);
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

            //textView hiddendata없나?
            tv_content.setText(getItem(position).getContent());
            tv_content.setOnClickListener(this);
            if(cb_listitem.isChecked()==true){
                tv_content.setTextColor(Color.YELLOW);
            }
            return v;
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

            if(viewId==R.id.Button_delete){
                TextView tv=(TextView)findViewById(R.id.TextView_content);
                content=tv.getText().toString();
                SQLiteDatabase db = contentDBHelper.getWritableDatabase();
                String sql="delete from ozContent where content='"+content+"'";
                db.execSQL(sql);
                Intent intent=new Intent(AllListActivity.this, AllListActivity.class);
                startActivity(intent);
            }
        }
    }
}
