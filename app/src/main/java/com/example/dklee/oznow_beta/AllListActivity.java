package com.example.dklee.oznow_beta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by kyounghee on 2015-08-12.
 */
public class AllListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oz_main);
        final Button categoryBtn=(Button)findViewById(R.id.button_category);
        categoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {// 카테고리 버튼을 눌렀을때 작성페이지로 넘어가도록 intetn 처리 후에 중간에 카테고리 선택 Activity 추가
                Intent intent=new Intent(AllListActivity.this,OZnowActivity.class);
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
        String list[]=this.fileList();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        ListView listView=(ListView)findViewById(R.id.allList);
        listView.setAdapter(adapter);
    }
}
