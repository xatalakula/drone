package com.example.noname.ttnm12;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OperationDroneFrag extends Fragment {
    Button btnControl,btnWatchVideo;
    ImageView dronePos;
    TextView longitude,latitude;
    int long1 = 100,long2 = 22,long3 = 12;
    int lat1 = 100,lat2 = 43,lat3 = 35;
    int count = 0;

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

}
