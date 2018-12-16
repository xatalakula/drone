package com.example.noname.ttnm12;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class OperationDroneFrag extends Fragment {
    Button btnControl,btnWatchVideo,btnCloseCheckPoint;
    ImageView dronePos;
    TextView longitude,latitude,tvDetailRoute;
    int long1 = 100,long2 = 22,long3 = 12;
    int lat1 = 100,lat2 = 43,lat3 = 35;
    int count = 0;
    ListView listCheckPoint,listSpecial;

    public OperationDroneFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_operation_drone, container, false);
        btnControl = (Button) view.findViewById(R.id.btn_control);
        btnControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ManuallyOperateActivity.class);
                startActivity(intent);
            }
        });
        btnWatchVideo = (Button) view.findViewById(R.id.btn_watch_video);
        btnWatchVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),VideoActivity.class);
                startActivity(intent);
            }
        });
        tvDetailRoute = (TextView) view.findViewById(R.id.tv_detail_route);
        tvDetailRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogCheckpoint();
            }
        });
        dronePos = (ImageView) view.findViewById(R.id.image_drone_position);
        handleAnimation(view);
        longitude = (TextView) view.findViewById(R.id.longitude);
        latitude = (TextView) view.findViewById(R.id.latitude);
        updateCoordinate();
        return view;
    }

    public void handleAnimation(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(dronePos,"x",650f);
        animator.setDuration(50000);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(dronePos,"y",250f);
        animator1.setDuration(50000);
        AnimatorSet animationSet = new AnimatorSet();
        animationSet.playTogether(animator,animator1);
        animationSet.start();
    }

    private void updateCoordinate() {
        count = 0;

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.arg1 == 1) {
                    increasePos(long1,long2,long3,1);
                    longitude.setText("Kinh độ: " + long1 + "°"+long2+"'"+long3+"''");
                    increasePos(lat1,lat2,lat3,2);
                    latitude.setText("Vĩ độ:     " + lat1 + "°"+lat2+"'"+lat3+"''");
                }
            }
        };

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 50) {
                    SystemClock.sleep(1000);
                    count++;
                    Message msg = handler.obtainMessage();
                    msg.arg1 = 1;
                    handler.sendMessage(msg);
                }

            }
        }) ;
        thread.start();

    }

    private void increasePos(int pos1,int pos2,int pos3,int flag) {
        pos3 += 2;
        if(pos3>60) {
            pos3 = pos3-60;
            pos2++;
            if(pos2>60){
                pos2 = pos2-60;
                pos1++;
            }
        }
        if(flag == 1){
            long1 = pos1;
            long2 = pos2;
            long3 = pos3;
        }else {
            lat1 = pos1;
            lat2 = pos2;
            lat3 = pos3;
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
        listCheckPoint.add(new CheckPoint("01","10°12'43''","12°14'16''",0,R.drawable.ic_check_success));
        listCheckPoint.add(new CheckPoint("02","10°22'54''","12°24'26''",0,R.drawable.ic_check_success));
        listCheckPoint.add(new CheckPoint("03","10°32'11''","12°34'36''",0,R.drawable.ic_check_success));
        listCheckPoint.add(new CheckPoint("04","10°43'13''","12°44'46''",0,R.drawable.ic_check_success));
        listCheckPoint.add(new CheckPoint("05","10°54'52''","12°54'56''",0,R.drawable.ic_check_success));
        listCheckPoint.add(new CheckPoint("06","11°02'32''","13°14'16''",0,R.drawable.ic_check_success));
        listCheckPoint.add(new CheckPoint("07","12°12'13''","13°24'26''",0,R.drawable.ic_check_fail));
        listCheckPoint.add(new CheckPoint("08","13°32'22''","13°34'36''",0,R.drawable.ic_check_fail));
        listCheckPoint.add(new CheckPoint("09","14°13'11''","13°44'46''",0,0));
        listCheckPoint.add(new CheckPoint("10","15°43'02''","13°54'56''",0,0));
        listCheckPoint.add(new CheckPoint("11","16°54'43''","14°14'16''",0,0));
        listCheckPoint.add(new CheckPoint("12","17°22'32''","14°24'26''",0,0));
        listCheckPoint.add(new CheckPoint("13","18°44'13''","14°34'36''",0,0));
        return listCheckPoint;
    }

    private List<CheckPoint> getListSpecial() {
        List<CheckPoint> listCheckPoint = new ArrayList<>();
        listCheckPoint.add(new CheckPoint("01","10°15'43''","12°18'16''",R.drawable.ic_flag_level_1,R.drawable.ic_check_success));
        listCheckPoint.add(new CheckPoint("02","10°25'54''","12°28'26''",R.drawable.ic_flag_level_1,R.drawable.ic_check_success));
        listCheckPoint.add(new CheckPoint("03","10°35'11''","12°38'36''",R.drawable.ic_flag_level_2,0));
        listCheckPoint.add(new CheckPoint("04","10°45'13''","12°48'46''",R.drawable.ic_flag_level_1,0));
        listCheckPoint.add(new CheckPoint("05","10°55'52''","12°58'56''",R.drawable.ic_flag_level_1,0));
        listCheckPoint.add(new CheckPoint("06","11°65'32''","13°68'16''",R.drawable.ic_flag_level_3,0));
        return listCheckPoint;
    }

}
