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
import android.widget.Toast;

import ir.neo.stepbarview.StepBarView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SetupRouteFrag extends Fragment {

    private Button btnBack,btnNext;
    private StepBarView stepBar;
    private int indexStep;
    private int flagStep = 1;
    private boolean flagFinish = false;

    public SetupRouteFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setup_route, container, false);
        Fragment fragment = new StepOneFrag();
        loadFragMent(fragment);
        btnBack = (Button) view.findViewById(R.id.btn_back_setup);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(indexStep==1) return;
                Fragment nextFragment = nextFragment(0);
                loadFragMent(nextFragment);
                stepBar.setReachedStep(--indexStep);
                if(flagStep == 1) {
                    btnBack.setVisibility(View.INVISIBLE);
                }
                else {
                    btnBack.setVisibility(View.VISIBLE);
                }
                if(flagStep == 3) {
                    btnNext.setText("Hoàn thành");
                    flagFinish = true;
                }
                else {
                    btnNext.setText("Tiếp tục");
                    flagFinish = false;
                }
            }
        });
        btnBack.setVisibility(View.INVISIBLE);
        btnNext = (Button) view.findViewById(R.id.btn_next_setup);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(indexStep==3) {
                    showAlertDialog();
                }else {
                    Fragment nextFragment = nextFragment(1);
                    loadFragMent(nextFragment);
                    stepBar.setReachedStep(++indexStep);
                    if (flagStep == 3) {
                        btnNext.setText("Hoàn thành");
                        flagFinish = true;
                    } else {
                        btnNext.setText("Tiếp tục");
                        flagFinish = false;
                    }
                    if (flagStep == 1) {
                        btnBack.setVisibility(View.INVISIBLE);
                    } else {
                        btnBack.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        stepBar = (StepBarView) view.findViewById(R.id.stepbar);
        indexStep = stepBar.getReachedStep();
        return view;
    }

    private Fragment nextFragment(int option) {
        Fragment fragment;
        switch (indexStep){
            case 1:
                fragment = new StepTwoFrag();
                flagStep = 2;
                break;
            case 2:
                if (option == 1) {
                    fragment = new StepThreeFrag();
                    flagStep = 3;
                }else {
                    fragment = new StepOneFrag();
                    flagStep = 1;
                }
                break;
            default:
                fragment = new StepTwoFrag();
                flagStep = 2;
                break;
        }
        return fragment;
    }

    public void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Xác nhận");
        builder.setMessage("Bạn muốn hoàn tất chứ ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Hoàn tất", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "Thiết lập thành công", Toast.LENGTH_SHORT).show();
                Fragment fragment = new StepOneFrag();
                loadFragMent(fragment);
                btnBack.setVisibility(View.INVISIBLE);
                btnNext.setText("Tiếp tục");
                indexStep = 1;
                stepBar.setReachedStep(indexStep);
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

    private void loadFragMent(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_setup, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
