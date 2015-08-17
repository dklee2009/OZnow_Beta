package com.example.dklee.oznow_beta;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.List;

/**
 * Created by kyounghee on 2015-08-12.
 */
public class AllListActivity extends Activity {
    private ContentDBHelper contentDBHelper;
    private ListView listView;
    private ArrayAdapter adapter;
    private Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oz_main);
        Button categoryBtn=(Button)findViewById(R.id.button_category);
        categoryBtn.setVisibility(View.VISIBLE);
        categoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {// 카테고리 버튼을 눌렀을때 작성페이지로 넘어가도록 intent 처리 후에 중간에 카테고리 선택 Activity 추가
                Intent intent=new Intent(AllListActivity.this,OZ_category_Activity.class);
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
        contentDBHelper=new ContentDBHelper(this);
        SQLiteDatabase db=contentDBHelper.getReadableDatabase();
        String sql="select * from ozContent";
        cursor=db.rawQuery(sql,null);
        startManagingCursor(cursor);
        SimpleCursorAdapter adapter= new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, new String[]{"content", "kind"}, new int[]{
                android.R.id.text1,android.R.id.text2},1);
        listView=(ListView)findViewById(R.id.allList);
        listView.setAdapter(adapter);
        //sqlite 사용안할 때!!!
        /*String list[]=this.fileList();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        ListView listView=(ListView)findViewById(R.id.allList);
        listView.setAdapter(adapter);*/
    }


}
