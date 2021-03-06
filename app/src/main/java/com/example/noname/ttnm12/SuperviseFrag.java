package com.example.noname.ttnm12;


import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class SuperviseFrag extends Fragment {

    private ListView listView;
    private EditText textSearch;
    ImageView imageVoice;
    Button btnExitVoice;
    Dialog dialogVoice;
    Boolean flag = false;
    static CustomListAdapter customListAdapter;

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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { Fragment fragment = new DetailDroneFrag();
                loadFragMent(fragment); }
        });
        customListAdapter = new CustomListAdapter(listDrone,this.getActivity(),0);
        listView.setAdapter(customListAdapter);
        textSearch = (EditText) view.findViewById(R.id.text_search_supervise);
        textSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SuperviseFrag.customListAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        imageVoice = (ImageView) view.findViewById(R.id.image_voice);
        imageVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogVoice();
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

    private void showDialogVoice() {
        flag = false;
        dialogVoice = new Dialog(getActivity());
        dialogVoice.setContentView(R.layout.custom_dialog_voice);
        dialogVoice.setCancelable(false);
        dialogVoice.show();
        btnExitVoice = (Button) dialogVoice.findViewById(R.id.btn_exit_voice);

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.arg1 == 1) {
                    dialogVoice.hide();
                    Random rd = new Random();
                    int i = rd.nextInt((1-0+1)+0);
                    if(i==1) {
                        textSearch.setText("drone_abc");
                    }else {
                        textSearch.setText("drone_ggwp_01");
                    }
                }
            }
        };

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag == false) {
                    SystemClock.sleep(5000);
                    if(flag == true){
                        break;
                    }
                    Message msg = handler.obtainMessage();
                    msg.arg1 = 1;
                    handler.sendMessage(msg);
                    break;
                }

            }
        }) ;
        btnExitVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = true;
                dialogVoice.hide();
            }
        });
        dialogVoice.show();
        thread.start();

    }

}
