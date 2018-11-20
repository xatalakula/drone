package com.example.noname.ttnm12;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailDroneFrag extends Fragment {

    Button btnInfo,btnOperation;
    public DetailDroneFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_drone, container, false);
        btnInfo = (Button) view.findViewById(R.id.btn_info);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoDroneFrag fragment = new InfoDroneFrag();
                loadFragment(fragment);
            }
        });
        btnOperation = (Button) view.findViewById(R.id.btn_operation);
        btnOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperationDroneFrag fragment = new OperationDroneFrag();
                loadFragment(fragment);
            }
        });
        loadFragment(new InfoDroneFrag());
        return view;
    }


    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.container_detail, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
