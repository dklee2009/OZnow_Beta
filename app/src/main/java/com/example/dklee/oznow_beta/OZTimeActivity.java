package com.example.dklee.oznow_beta;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TimePicker;

/**
 * Created by kyounghee on 2015-09-01.
 */
public class OZTimeActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oz_time);
        TabHost tab = (TabHost) findViewById(R.id.tabHost);
        tab.setup();
        TabHost.TabSpec spec = tab.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Date");
        tab.addTab(spec);
        TabHost.TabSpec spec2 = tab.newTabSpec("tag2");
        spec2.setContent(R.id.tab2);
        spec2.setIndicator("Hour");
        tab.addTab(spec2);
        tab.setCurrentTab(0);
        TimePicker timePicker=(TimePicker)findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

            }
        });

    }
}
