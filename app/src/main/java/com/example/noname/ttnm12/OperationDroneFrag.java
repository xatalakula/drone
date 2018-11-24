package com.example.noname.ttnm12;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class OperationDroneFrag extends Fragment {
    Button btnControl,btnWatchVideo;

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
        return view;
    }

}
