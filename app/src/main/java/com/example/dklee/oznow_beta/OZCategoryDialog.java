package com.example.dklee.oznow_beta;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by DKLEE on 2015-08-18.
 */
public class OZCategoryDialog extends Dialog implements View.OnClickListener {

    private EditText dialog_edittxt;
    private Button dialog_ok, dialog_cancel;
    private String dialog_category;
    private ImageView imageView;
    private String message;

    public OZCategoryDialog(Context context) {
        super(context);
    }

    protected void onCreate() {
        Log.d("dialog", "message onCreate");
        setContentView(R.layout.dialog_oz_category_write);
        imageView = (ImageView) findViewById(R.id.btn_img);
        if (getMessage() == "red") {
            imageView.setBackgroundResource(R.drawable.redbtn);
        } else if (getMessage() == "orange") {
            imageView.setBackgroundResource(R.drawable.orangebtn);
        } else if (getMessage() == "yellow") {
            imageView.setBackgroundResource(R.drawable.yellowbtn);
        } else if (getMessage() == "lightblue") {
            imageView.setBackgroundResource(R.drawable.lightbluebtn);
        } else if (getMessage() == "blue") {
            imageView.setBackgroundResource(R.drawable.bluebtn);
        } else if (getMessage() == "lightgreen") {
            imageView.setBackgroundResource(R.drawable.lightgreenbtn);
        } else if (getMessage() == "green") {
            imageView.setBackgroundResource(R.drawable.greenbtn);
        } else if (getMessage() == "purple") {
            imageView.setBackgroundResource(R.drawable.purplebtn);
        }
        dialog_edittxt = (EditText) findViewById(R.id.dialog_edittxt);
        dialog_ok = (Button) findViewById(R.id.dialog_ok);
        dialog_cancel = (Button) findViewById(R.id.dialog_cancel);
        dialog_ok.setOnClickListener(this);
        dialog_cancel.setOnClickListener(this);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getcategoryName() {
        return dialog_category;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.dialog_ok) {
            dialog_category = dialog_edittxt.getText().toString();
            dismiss();

        }
        else if (v == dialog_cancel)
            cancel();
    }
}
