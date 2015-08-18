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
            public void onClick(View v) {// ī�װ� ��ư�� �������� �ۼ��������� �Ѿ���� intent ó�� �Ŀ� �߰��� ī�װ� ���� Activity �߰�
                Intent intent=new Intent(AllListActivity.this,OZ_category_Activity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * todo�� note�ۼ��� AllListActivity�� ���ƿ��� onCreate�� �ٽ� ������� �ʴ´�.
     * ���� onResume���� ����� ǥ���ϵ��� �� �׻� ������Ʈ �ǵ��� �ؾ� �Ѵ�.
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
        //sqlite ������ ��!!!
        /*String list[]=this.fileList();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        ListView listView=(ListView)findViewById(R.id.allList);
        listView.setAdapter(adapter);*/
    }


}
