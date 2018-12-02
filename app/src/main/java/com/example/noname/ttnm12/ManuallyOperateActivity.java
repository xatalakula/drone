package com.example.noname.ttnm12;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;


public class ManuallyOperateActivity extends AppCompatActivity {

    Button btnExitOperate;
    Switch changeMode;
    TextView tvMode;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manually_operate);
        btnExitOperate = (Button) findViewById(R.id.button_exit_operate);
        btnExitOperate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvMode = (TextView) findViewById(R.id.text_mode);
        changeMode = (Switch) findViewById(R.id.switch_change_mode);
        changeMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    tvMode.setText("Điều khiển");
                }else {
                    tvMode.setText("Tự động");
                }
            }
        });
    }

}
