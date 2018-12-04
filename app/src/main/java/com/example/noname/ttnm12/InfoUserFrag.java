package com.example.noname.ttnm12;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 */
public class InfoUserFrag extends Fragment {

    Button btnChangePwd;
    Button btnComplete,btnCancel;
    Dialog dialog;

    public InfoUserFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info_user, container, false);
        btnChangePwd = (Button) view.findViewById(R.id.button_change_pass);
        btnChangePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogChagePwd();
            }
        });
        return view;
    }

    private void showDialogChagePwd() {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.custom_dialog_changepwd);
        dialog.setCancelable(false);
        btnComplete = (Button) dialog.findViewById(R.id.button_complete);
        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogConfirm();
            }
        });
        btnCancel = (Button) dialog.findViewById(R.id.button_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.hide();
            }
        });
        dialog.show();

    }

    public void showDialogConfirm(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Xác nhận");
        builder.setMessage("Bạn muốn hoàn tất chứ ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Hoàn tất", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.hide();
                Toast.makeText(getActivity(), "Thay đổi thành công", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

}
