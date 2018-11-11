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
public class SuperviseFrag extends Fragment {

        private ListView listView;

    public SuperviseFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_supervise, container, false);
        listView = view.findViewById(R.id.listview_drone_connected);
        List<String> listId = getListData();
        listView.setAdapter(new CustomListAdapter(listId,this.getActivity()));
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private List<String> getListData() {
        List<String> list = new ArrayList<>();


        list.add("drone_ggwp_01");
        list.add("drone_ggwp_02");
        list.add("drone_ggwp_03");
        list.add("drone_ggwp_04");
        list.add("drone_ggwp_05");

        return list;
    }

}
