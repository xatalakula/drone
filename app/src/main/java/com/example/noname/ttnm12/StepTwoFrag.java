package com.example.noname.ttnm12;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StepTwoFrag extends Fragment implements View.OnClickListener{

    ImageButton btn[] = new ImageButton[12];
    ImageButton btnUnfocus;
    int idButton[] = {R.id.img_btn_1,R.id.img_btn_2,R.id.img_btn_3,R.id.img_btn_4,R.id.img_btn_5,R.id.img_btn_6,
            R.id.img_btn_7,R.id.img_btn_8,R.id.img_btn_9,R.id.img_btn_10,R.id.img_btn_11,R.id.img_btn_12};

    public StepTwoFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step_two, container, false);
        for(int i = 0; i < btn.length; i++){
            btn[i] = (ImageButton) view.findViewById(idButton[i]);
            btn[i].setOnClickListener(this);
        }
        this.btnUnfocus = btn[0];
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_btn_1 :
                setFocus(btnUnfocus, btn[0]);
                break;

            case R.id.img_btn_2 :
                setFocus(btnUnfocus, btn[1]);
                break;

            case R.id.img_btn_3 :
                setFocus(btnUnfocus, btn[2]);
                break;

            case R.id.img_btn_4 :
                setFocus(btnUnfocus, btn[3]);
                break;
            case R.id.img_btn_5 :
                setFocus(btnUnfocus, btn[4]);
                break;

            case R.id.img_btn_6 :
                setFocus(btnUnfocus, btn[5]);
                break;

            case R.id.img_btn_7 :
                setFocus(btnUnfocus, btn[6]);
                break;

            case R.id.img_btn_8 :
                setFocus(btnUnfocus, btn[7]);
                break;
            case R.id.img_btn_9 :
                setFocus(btnUnfocus, btn[8]);
                break;

            case R.id.img_btn_10 :
                setFocus(btnUnfocus, btn[9]);
                break;

            case R.id.img_btn_11 :
                setFocus(btnUnfocus, btn[10]);
                break;

            case R.id.img_btn_12 :
                setFocus(btnUnfocus, btn[11]);
                break;
        }
    }

    private void setFocus(ImageButton unFocus,ImageButton focus) {
        unFocus.setPressed(false);
        focus.setPressed(true);
        this.btnUnfocus = focus;
    }
}
