package com.example.noname.ttnm12;


import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class StepThreeFrag extends Fragment {

    Calendar cal;

    TextView tvTimeStart,tvTimeEnd;
    public StepThreeFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step_three, container, false);
        tvTimeStart = (TextView) view.findViewById(R.id.textview_timestart);
        cal = Calendar.getInstance();
        setTime(tvTimeStart,0);
        tvTimeStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });
        tvTimeEnd = (TextView) view.findViewById(R.id.textview_timeend);
        setTime(tvTimeEnd,2);
        return view;
    }

    private void setTime(TextView tv,int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        cal.set(Calendar.HOUR_OF_DAY,cal.get(Calendar.HOUR_OF_DAY)+i);
        String time = sdf.format(cal.getTime());
        tv.setText(time);
        tv.setTag(time);
    }

    private void showTimePickerDialog() {
        TimePickerDialog.OnTimeSetListener callBack = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String min = "0";
                if(minute<10){
                    min = min + minute;
                }else {
                    min = String.valueOf(minute);
                }
                String time = hourOfDay + ":" + min;
                tvTimeStart.setTag(time);
                tvTimeStart.setText(time);
                cal.set(Calendar.HOUR_OF_DAY, hourOfDay+2);
                cal.set(Calendar.MINUTE, minute);
                setTime(tvTimeEnd,0);
            }
        };
        String time = tvTimeStart.getTag()+"";
        String strArr[] = time.split(":");
        int hour = Integer.parseInt(strArr[0]);
        int min = Integer.parseInt(strArr[1]);
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),callBack,hour,min,true);
        timePickerDialog.setTitle("Chọn giờ khởi động");
        timePickerDialog.show();
    }

}
