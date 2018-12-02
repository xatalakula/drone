package com.example.noname.ttnm12;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OperationDroneFrag extends Fragment {
    Button btnControl,btnWatchVideo;
    ImageView dronePos;

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
        return view;
    }

    public void handleAnimation(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(dronePos,"x",650f);
        animator.setDuration(50000);
        AnimatorSet animationSet = new AnimatorSet();
        animationSet.playTogether(animator);
        animationSet.start();
    }

}
