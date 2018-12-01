package com.example.noname.ttnm12;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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
    private EditText searchView;
    static CustomListDrone adapter;
    private Dialog dialog;
    private Dialog dialogError;
    private Dialog dialogSuccess;
    private Dialog dialogFail;
    private int positionEditting ;
    ImageView imageVoice;
    Button btnExitVoice;
    Dialog dialogVoice;
    Boolean flag = false;
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
        searchView = view.findViewById(R.id.search_bar);
        createDialog();



        List<Drone> listDrone = getListData();
        adapter = new CustomListDrone(listDrone,this.getActivity());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Drone drone = adapter.getItem(position);
                if (drone.getState().equals("chưa kết nối")) {
                    positionEditting = position;
                    dialog.show();
                }
                else{
                    dialogError.show();
                }
            }
        });

        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ConnectionDroneFrag.adapter.getFilter().filter(s);
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


    public void createDialog() {
        AlertDialog.Builder builder;
        AlertDialog.Builder builderError;
        AlertDialog.Builder builderSuccess;
        AlertDialog.Builder builderFail;
        builder = new AlertDialog.Builder(getActivity());
        builderError = new AlertDialog.Builder(getActivity());
        builderSuccess = new AlertDialog.Builder(getActivity());
        builderFail = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        final LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builderSuccess.setView(inflater.inflate(R.layout.dialog_success_connection, null))
                // Add action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialogSuccess.cancel();
                    }
                });
        dialogSuccess = builderSuccess.create();

        builderFail.setView(inflater.inflate(R.layout.dialog_fail_connection, null))
                // Add action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialogFail.cancel();
                    }
                });
        dialogFail = builderFail.create();


        builder.setView(inflater.inflate(R.layout.dialog_password_drone, null))
                // Add action buttons
                .setPositiveButton("Kết nối", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        View view = inflater.inflate(R.layout.dialog_password_drone, null);
                        TextView text = view.findViewById(R.id.password);
                        dialogSuccess.show();
                        Drone drone = adapter.getItem(positionEditting);
                        drone.connect();
                    }
                })
                .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        dialog = builder.create();

        builderError.setView(inflater.inflate(R.layout.dialog_fail_connection, null))
                // Add action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        dialogError = builderError.create();
    }
    private List<Drone> getListData() {
        List<Drone> list = new ArrayList<>();



        list.add(new Drone("drone_ggwp_11","đã kết nối"));
        list.add(new Drone("drone_ggwp_12","chưa kết nối"));
        list.add(new Drone("drone_ggwp_13","chưa kết nối"));
        list.add(new Drone("drone_ggwp_14","chưa kết nối"));
        list.add(new Drone("drone_ggwp_15","chưa kết nối"));
        list.add(new Drone("drone_ggwp_26","chưa kết nối"));
        list.add(new Drone("drone_ggwp_27","chưa kết nối"));
        list.add(new Drone("drone_ggwp_28","chưa kết nối"));

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

    private void showDialogVoice() {
        flag = false;
        dialogVoice = new Dialog(getActivity());
        dialogVoice.setContentView(R.layout.custom_dialog_voice);
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
                        searchView.setText("drone_abc");
                    }else {
                        searchView.setText("drone_ggwp_01");
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
