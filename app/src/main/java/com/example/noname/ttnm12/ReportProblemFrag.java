package com.example.noname.ttnm12;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReportProblemFrag extends Fragment implements View.OnClickListener{

    Button btnComplete;
    RadioButton btn[] = new RadioButton[6];
    boolean btnState[]  = new boolean[6];
    int idButton[] = {R.id.radio_btn_1,R.id.radio_btn_2,R.id.radio_btn_3,R.id.radio_btn_4,R.id.radio_btn_5,R.id.radio_btn_6};


    public ReportProblemFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_report_problem, container, false);
        btnComplete = (Button) view.findViewById(R.id.button_complete);
        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });
        for(int i = 0; i < btn.length; i++){
            btn[i] = (RadioButton) view.findViewById(idButton[i]);
            btn[i].setOnClickListener(this);
            btnState[i] = false;
        }
        return view;
    }

    public void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Xác nhận");
        builder.setMessage("Bạn muốn xác nhận gửi chứ ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "Gửi thành công", Toast.LENGTH_SHORT).show();
                Fragment fragment = new ReportFrag();
                loadFragMent(fragment);
            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private void loadFragMent(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.radio_btn_1 :
                if(btnState[0]){
                    btn[0].setChecked(false);
                    btnState[0] = false;
                }
                else {
                    btnState[0] = true;
                }
                break;

            case R.id.radio_btn_2 :
                if(btnState[1]){
                    btn[1].setChecked(false);
                    btnState[1] = false;
                }
                else {
                    btnState[1] = true;
                }
                break;

            case R.id.radio_btn_3 :
                if(btnState[2]){
                    btn[2].setChecked(false);
                    btnState[2] = false;
                }
                else {
                    btnState[2] = true;
                }
                break;

            case R.id.radio_btn_4 :
                if(btnState[3]){
                    btn[3].setChecked(false);
                    btnState[3] = false;
                }
                else {
                    btnState[3] = true;
                }
                break;
            case R.id.radio_btn_5 :
                if(btnState[4]){
                    btn[4].setChecked(false);
                    btnState[4] = false;
                }
                else {
                    btnState[4] = true;
                }
                break;

            case R.id.radio_btn_6 :
                if(btnState[5]){
                    btn[5].setChecked(false);
                    btnState[5] = false;
                }
                else {
                    btnState[5] = true;
                }
                break;
        }
    }
}
