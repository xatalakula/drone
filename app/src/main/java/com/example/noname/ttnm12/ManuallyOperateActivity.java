package com.example.noname.ttnm12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ManuallyOperateActivity extends AppCompatActivity {

    Button btnExitOperate;

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
    }
}
