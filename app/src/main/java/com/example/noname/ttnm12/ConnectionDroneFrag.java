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
 * {@link ConnectionDroneFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ConnectionDroneFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private ListView listView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ConnectionDroneFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_connection_drone, container, false);
        listView = view.findViewById(R.id.listview_drone_connected);
        List<Drone> listDrone = getListData();
        listView.setAdapter(new CustomListDrone(listDrone,this.getActivity()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { Fragment fragment = new DetailDroneFrag();
                loadFragMent(fragment); }
        });

        return view;
    }

    private List<Drone> getListData() {
        List<Drone> list = new ArrayList<>();



        list.add(new Drone("drone_ggwp_01","đã kết nối"));
        list.add(new Drone("drone_ggwp_02","chưa kết nối"));
        list.add(new Drone("drone_ggwp_03","chưa kết nối"));
        list.add(new Drone("drone_ggwp_04","chưa kết nối"));
        list.add(new Drone("drone_ggwp_05","chưa kết nối"));
        list.add(new Drone("drone_ggwp_06","chưa kết nối"));
        list.add(new Drone("drone_ggwp_07","chưa kết nối"));
        list.add(new Drone("drone_ggwp_08","chưa kết nối"));

        return list;
    }

    private void loadFragMent(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
