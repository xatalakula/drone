package com.example.noname.ttnm12;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ir.neo.stepbarview.StepBarView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SetupRouteFrag extends Fragment {

    private Button btnBack,btnNext;
    private StepBarView stepBar;
    private int indexStep;

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
            }
        });
        btnNext = (Button) view.findViewById(R.id.btn_next_setup);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(indexStep==3) return;
                Fragment nextFragment = nextFragment(1);
                loadFragMent(nextFragment);
                stepBar.setReachedStep(++indexStep);
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
                break;
            case 2:
                if (option == 1) {
                    fragment = new StepThreeFrag();
                }else {
                    fragment = new StepOneFrag();
                }
                break;
            default:
                fragment = new StepTwoFrag();
                break;
        }
        return fragment;
    }

    private void loadFragMent(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_setup, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
