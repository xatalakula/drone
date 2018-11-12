package com.example.noname.ttnm12;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
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
        List<State> listDrone = getListData();
        listView.setAdapter(new CustomListAdapter(listDrone,this.getActivity()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = new DetailDroneFrag();
                loadFragMent(fragment);
            }
        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private List<State> getListData() {
        List<State> list = new ArrayList<>();


        list.add(new State("drone_ggwp_01",R.drawable.ic_state_on));
        list.add(new State("drone_ggwp_02",R.drawable.ic_state_on));
        list.add(new State("drone_ggwp_03",R.drawable.ic_state_on));
        list.add(new State("drone_ggwp_04",R.drawable.ic_state_on));
        list.add(new State("drone_ggwp_05",R.drawable.ic_state_off));
        list.add(new State("drone_ggwp_06",R.drawable.ic_state_on));
        list.add(new State("drone_ggwp_07",R.drawable.ic_state_on));
        list.add(new State("drone_ggwp_08",R.drawable.ic_state_off));

        return list;
    }

    private void loadFragMent(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
