package com.example.noname.ttnm12;


import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class StepThreeFrag extends Fragment {

    Calendar cal;
    TextView tvTimeStart,tvTimeEnd,tvDetailRoute;
    ImageView imageRouteSelected;
    ListView listRoute,listCheckPoint,listSpecial;
    Button btnSelectRoute,btnCloseCheckPoint;
    private int idRouteSelected;

    public StepThreeFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step_three, container, false);
        this.imageRouteSelected = (ImageView) view.findViewById(R.id.imgv_route_selected);
        imageRouteSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogRoute();
            }
        });
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
        tvDetailRoute = (TextView) view.findViewById(R.id.tv_detail_route);
        tvDetailRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogCheckpoint();
            }
        });
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

    private void openDialogRoute() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.custom_dialog_route);
        listRoute = dialog.findViewById(R.id.listview_route);
        listRoute.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                idRouteSelected = position;
            }
        });
        btnSelectRoute = (Button) dialog.findViewById(R.id.button_select_route);
        btnSelectRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.hide();
                changeRoute();
            }
        });
        CustomRouteAdapter customRouteAdapter = new CustomRouteAdapter(getListRoute(),getActivity());
        listRoute.setAdapter(customRouteAdapter);
        dialog.show();

    }

    private List<Integer> getListRoute() {
        List<Integer> listRoute = new ArrayList<>();
        listRoute.add(R.drawable.ic_route_1);
        listRoute.add(R.drawable.ic_route_3);
        listRoute.add(R.drawable.ic_route_4);
        return listRoute;
    }

    private void changeRoute(){
        Log.e("idroute", "changeRoute: " + idRouteSelected);
        if(idRouteSelected == 0 ){
            imageRouteSelected.setImageResource(R.drawable.ic_route_1);
        }
        else if(idRouteSelected == 1) {
            imageRouteSelected.setImageResource(R.drawable.ic_route_3);
        }
        else {
            imageRouteSelected.setImageResource(R.drawable.ic_route_4);
        }
    }

    private void showDialogCheckpoint() {
        final Dialog dialogCheckpoint = new Dialog(getActivity());
        dialogCheckpoint.setContentView(R.layout.dialog_detail_route);
        listCheckPoint = (ListView) dialogCheckpoint.findViewById(R.id.list_checkpoint);
        listSpecial = (ListView) dialogCheckpoint.findViewById(R.id.list_special_checkpoint);
        btnCloseCheckPoint = (Button) dialogCheckpoint.findViewById(R.id.button_close_checkpoint);
        btnCloseCheckPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCheckpoint.hide();
            }
        });
        CustomListCheckPoint customListCheckPoint1 = new CustomListCheckPoint(getListCheckPoint(),getActivity());
        listCheckPoint.setAdapter(customListCheckPoint1);
        CustomListCheckPoint customListCheckPoint2 = new CustomListCheckPoint(getListSpecial(),getActivity());
        listSpecial.setAdapter(customListCheckPoint2);
        dialogCheckpoint.show();
    }

    private List<CheckPoint> getListCheckPoint() {
        List<CheckPoint> listCheckPoint = new ArrayList<>();
        listCheckPoint.add(new CheckPoint("01","10°12'43''","12°14'16''",0,0));
        listCheckPoint.add(new CheckPoint("02","10°22'54''","12°24'26''",0,0));
        listCheckPoint.add(new CheckPoint("03","10°32'11''","12°34'36''",0,0));
        listCheckPoint.add(new CheckPoint("04","10°43'13''","12°44'46''",0,0));
        listCheckPoint.add(new CheckPoint("05","10°54'52''","12°54'56''",0,0));
        listCheckPoint.add(new CheckPoint("06","11°02'32''","13°14'16''",0,0));
        listCheckPoint.add(new CheckPoint("07","12°12'13''","13°24'26''",0,0));
        listCheckPoint.add(new CheckPoint("08","13°32'22''","13°34'36''",0,0));
        listCheckPoint.add(new CheckPoint("09","14°13'11''","13°44'46''",0,0));
        listCheckPoint.add(new CheckPoint("10","15°43'02''","13°54'56''",0,0));
        listCheckPoint.add(new CheckPoint("11","16°54'43''","14°14'16''",0,0));
        listCheckPoint.add(new CheckPoint("12","17°22'32''","14°24'26''",0,0));
        listCheckPoint.add(new CheckPoint("13","18°44'13''","14°34'36''",0,0));
        return listCheckPoint;
    }

    private List<CheckPoint> getListSpecial() {
        List<CheckPoint> listCheckPoint = new ArrayList<>();
        listCheckPoint.add(new CheckPoint("01","10°15'43''","12°18'16''",R.drawable.ic_flag_level_1,0));
        listCheckPoint.add(new CheckPoint("02","10°25'54''","12°28'26''",R.drawable.ic_flag_level_1,0));
        listCheckPoint.add(new CheckPoint("03","10°35'11''","12°38'36''",R.drawable.ic_flag_level_2,0));
        listCheckPoint.add(new CheckPoint("04","10°45'13''","12°48'46''",R.drawable.ic_flag_level_1,0));
        listCheckPoint.add(new CheckPoint("05","10°55'52''","12°58'56''",R.drawable.ic_flag_level_1,0));
        listCheckPoint.add(new CheckPoint("06","11°65'32''","13°68'16''",R.drawable.ic_flag_level_3,0));
        return listCheckPoint;
    }

}
