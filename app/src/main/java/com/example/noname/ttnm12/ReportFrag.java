package com.example.noname.ttnm12;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class ReportFrag extends Fragment {
    private Button buttonReport;
    private Button buttonError;
    private Button buttonMess;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_report, container, false);
        buttonReport = (Button) view.findViewById(R.id.button_upload);
        buttonError = (Button) view.findViewById(R.id.button_sendError);
        buttonMess = (Button) view.findViewById(R.id.button_sendMess);

        buttonReport.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                loadFragment(new UploadVideoFragment());
            }
        });
        buttonError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ReportProblemFrag();
                loadFragment(fragment);
            }
        });

        buttonMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new MessageFrag();
                loadFragment(fragment);
            }
        });

        return view;
    }


    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
