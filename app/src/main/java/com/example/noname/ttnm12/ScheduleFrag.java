package com.example.noname.ttnm12;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 */
public class ScheduleFrag extends Fragment {
    private ListView listView;
    public ScheduleFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_schedule, container, false);
        listView = view.findViewById(R.id.listview_schedule);
        List<Schedule> listSchedule = getListData();
        listView.setAdapter(new CustomListSchedule(listSchedule,this.getActivity()));
        return view;
    }
    private List<Schedule> getListData() {
        List<Schedule> list = new ArrayList<>();

        list.add(new Schedule("2018-11-20","KV1"));
        list.add(new Schedule("2018-11-19","KV2"));
        list.add(new Schedule("2018-11-18","KV3"));
        list.add(new Schedule("2018-11-17","KV1"));
        list.add(new Schedule("2018-11-16","KV2"));
        list.add(new Schedule("2018-11-15","KV3"));
        list.add(new Schedule("2018-11-14","KV4"));
        list.add(new Schedule("2018-11-13","KV5"));

        return list;
    }

    private void loadFragMent(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
