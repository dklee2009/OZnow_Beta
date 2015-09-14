package com.example.dklee.oznow_beta;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by kyounghee on 2015-09-01.
 */
public class OZTimeActivity extends Activity implements AdapterView.OnItemClickListener {
    private LinearLayout lin_hour;
    private LinearLayout lin_date;

    public static int SUNDAY        = 1;
    public static int MONDAY        = 2;
    public static int TUESDAY       = 3;
    public static int WEDNSESDAY    = 4;
    public static int THURSDAY      = 5;
    public static int FRIDAY        = 6;
    public static int SATURDAY      = 7;

    private TextView mTvCalendarTitle;
    private GridView mGvCalendar;

    private ArrayList<DayVO> mDayList;
    private CalendarAdapter mCalendarAdapter;

    Calendar mLastMonthCalendar;
    Calendar mThisMonthCalendar;
    Calendar mNextMonthCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oz_time);
        Button btn_date=(Button)findViewById(R.id.btn_date);
        Button btn_hour=(Button)findViewById(R.id.btn_hour);
        lin_hour=(LinearLayout)findViewById(R.id.lin_hour);
        lin_date=(LinearLayout)findViewById(R.id.lin_hour);
        lin_hour.setVisibility(View.INVISIBLE);
        btn_hour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lin_date.setVisibility(View.INVISIBLE);이거 왜 안먹히지...
                mGvCalendar.setVisibility(View.INVISIBLE);
                lin_hour.setVisibility(View.VISIBLE);
            }
        });
        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lin_hour.setVisibility(View.INVISIBLE);
                mGvCalendar.setVisibility(View.VISIBLE);
            }
        });
        mTvCalendarTitle = (TextView)findViewById(R.id.gv_calendar_activity_tv_title);
        mGvCalendar = (GridView)findViewById(R.id.gv_calendar_activity_gv_calendar);
        mGvCalendar.setOnItemClickListener(this);
        mDayList = new ArrayList<DayVO>();
    }
    @Override
    protected void onResume()
    {
        super.onResume();

        // 이번달 의 캘린더 인스턴스를 생성한다.
        mThisMonthCalendar = Calendar.getInstance();
        mThisMonthCalendar.set(Calendar.DAY_OF_MONTH, 1);
        getCalendar(mThisMonthCalendar);
    }

    /**
     * 달력을 셋팅한다.
     *
     * @param calendar 달력에 보여지는 이번달의 Calendar 객체
     */
    private void getCalendar(Calendar calendar)
    {
        int lastMonthStartDay;
        int dayOfMonth;
        int thisMonthLastDay;

        mDayList.clear();

        // 이번달 시작일의 요일을 구한다. 시작일이 일요일인 경우 인덱스를 1(일요일)에서 8(다음주 일요일)로 바꾼다.)
        dayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);
        thisMonthLastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar.add(Calendar.MONTH, -1);
        Log.e("지난달 마지막일", calendar.get(Calendar.DAY_OF_MONTH) + "");

        // 지난달의 마지막 일자를 구한다.
        lastMonthStartDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar.add(Calendar.MONTH, 1);
        Log.e("이번달 시작일", calendar.get(Calendar.DAY_OF_MONTH)+"");

        if(dayOfMonth == SUNDAY)
        {
            dayOfMonth += 7;
        }

        lastMonthStartDay -= (dayOfMonth-1)-1;


        // 캘린더 타이틀(년월 표시)을 세팅한다.
        mTvCalendarTitle.setText(mThisMonthCalendar.get(Calendar.YEAR) + "년 "
                + (mThisMonthCalendar.get(Calendar.MONTH) + 1) + "월");

        DayVO day;

        Log.e("DayOfMOnth", dayOfMonth+"");

        for(int i=0; i<dayOfMonth-1; i++)
        {
            int date = lastMonthStartDay+i;
            day = new DayVO();
            day.setDay(Integer.toString(date));
            day.setInMonth(false);

            mDayList.add(day);
        }
        for(int i=1; i <= thisMonthLastDay; i++)
        {
            day = new DayVO();
            day.setDay(Integer.toString(i));
            day.setInMonth(true);

            mDayList.add(day);
        }
        for(int i=1; i<42-(thisMonthLastDay+dayOfMonth-1)+1; i++)
        {
            day = new DayVO();
            day.setDay(Integer.toString(i));
            day.setInMonth(false);
            mDayList.add(day);
        }

        initCalendarAdapter();
    }

    /**
     * 지난달의 Calendar 객체를 반환합니다.
     *
     * @param calendar
     * @return LastMonthCalendar
     */
    private Calendar getLastMonth(Calendar calendar)
    {
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        calendar.add(Calendar.MONTH, -1);
        mTvCalendarTitle.setText(mThisMonthCalendar.get(Calendar.YEAR) + "년 "
                + (mThisMonthCalendar.get(Calendar.MONTH) + 1) + "월");
        return calendar;
    }

    /**
     * 다음달의 Calendar 객체를 반환합니다.
     *
     * @param calendar
     * @return NextMonthCalendar
     */
    private Calendar getNextMonth(Calendar calendar)
    {
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        calendar.add(Calendar.MONTH, +1);
        mTvCalendarTitle.setText(mThisMonthCalendar.get(Calendar.YEAR) + "년 "
                + (mThisMonthCalendar.get(Calendar.MONTH) + 1) + "월");
        return calendar;
    }

    /*@Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.gv_calendar_activity_b_last:
                mThisMonthCalendar = getLastMonth(mThisMonthCalendar);
                getCalendar(mThisMonthCalendar);
                break;
            case R.id.gv_calendar_activity_b_next:
                mThisMonthCalendar = getNextMonth(mThisMonthCalendar);
                getCalendar(mThisMonthCalendar);
                break;
        }
    }*/

    private void initCalendarAdapter()
    {
        mCalendarAdapter = new CalendarAdapter(this, R.layout.day, mDayList);
        mGvCalendar.setAdapter(mCalendarAdapter);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long arg3)
    {

    }
}
