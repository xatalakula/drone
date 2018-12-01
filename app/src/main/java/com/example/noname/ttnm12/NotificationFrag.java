package com.example.noname.ttnm12;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFrag extends Fragment {

    CustomListNoti customListNoti;
    ListView listView;

    public NotificationFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        listView = (ListView) view.findViewById(R.id.listview_notification);
        customListNoti = new CustomListNoti(getListData(),getActivity());
        listView.setAdapter(customListNoti);
        return view;
    }

    private List<String> getListData() {
        List<String> list = new ArrayList<>();


        list.add("Co dau hieu kha nghi tai vi tri ab'af'dd khu vuc 2." +
                "De nghi kiem lam phu trach tien hanh kiem tra ngay va bao cao lai " +
                "truoc 22:00:00 ngay 30/11/2018");
        list.add("Co dau hieu kha nghi tai vi tri ab'af'dd khu vuc 4.32" +
                "De nghi kiem lam phu trach tien hanh kiem tra ngay va bao cao lai " +
                "truoc 22:00:00 ngay 30/15/2018");
        list.add("Nghi ngo can bo kiem lam tai 312 khong hoan thanh nhiem vu " +
                "ngay 12/11/2018. De nghi can bo tien hanh giai trinh truoc ngay 15/11/2018");


        return list;
    }

}
