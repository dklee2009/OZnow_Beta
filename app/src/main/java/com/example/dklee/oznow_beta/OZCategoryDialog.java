package com.example.dklee.oznow_beta;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by DKLEE on 2015-08-18.
 */
public class OZCategoryDialog extends Dialog implements View.OnClickListener {

    private EditText dialog_edittxt;
    private Button dialog_ok , dialog_cancel;
    private String dialog_category;
    public OZCategoryDialog(Context context){
        super(context);
    }




    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_oz_category_write);
        dialog_edittxt = (EditText)findViewById(R.id.dialog_edittxt);
        dialog_ok = (Button)findViewById(R.id.dialog_ok);
        dialog_cancel = (Button)findViewById(R.id.dialog_cancel);

        dialog_ok.setOnClickListener(this);
        dialog_cancel.setOnClickListener(this);
    }
    public String getcategoryName(){
        return dialog_category;
    }


    @Override
    public void onClick(View v) {
        if( v.getId()== R.id.dialog_ok){
            dialog_category = dialog_edittxt.getText().toString();
            dismiss();
        }
        else if(v==dialog_cancel)
            cancel();
    }
}
