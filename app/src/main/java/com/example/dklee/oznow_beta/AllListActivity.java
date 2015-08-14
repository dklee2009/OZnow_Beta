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
            public void onClick(View v) {// ī�װ� ��ư�� �������� �ۼ��������� �Ѿ���� intetn ó�� �Ŀ� �߰��� ī�װ� ���� Activity �߰�
                Intent intent=new Intent(AllListActivity.this,OZnowActivity.class);
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
        String list[]=this.fileList();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        ListView listView=(ListView)findViewById(R.id.allList);
        listView.setAdapter(adapter);
    }
}
