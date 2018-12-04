package com.example.noname.ttnm12;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements
        DashBoardFrag.OnFragmentInteractionListener,DroneFrag.OnFragmentInteractionListener,
        GeneralFrag.OnFragmentInteractionListener {

    private ActionBar toolbar;
    NotificationCompat.Builder mBuilder;
    NotificationManager mNotifyMgr;
    int flag = 0;
    Vibrator vibrator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = getSupportActionBar();
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationView);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        Intent intent1 = getIntent();
        if(intent1 != null && intent1.getBooleanExtra("detail",false)) {
            navigation.setSelectedItemId(R.id.navigation_drone);
            loadFragment(new DetailDroneFrag());
        }
        else if(intent1 !=null && intent1.getBooleanExtra("login",false)){
            createNotification();
            navigation.setSelectedItemId(R.id.navigation_dashboard);
            Toast.makeText(this, "Xin chào, chúc một ngày tốt lành.", Toast.LENGTH_SHORT).show();
        }
        else {
            navigation.setSelectedItemId(R.id.navigation_dashboard);
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment;
            switch (menuItem.getItemId()) {
                case R.id.navigation_dashboard:
                    fragment = new DashBoardFrag();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_drone:
                    fragment = new DroneFrag();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_map:
                    Intent intent = new Intent(getApplicationContext(),MapActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_general:
                    fragment = new GeneralFrag();
                    loadFragment(fragment);
                    return true;

                case R.id.navigation_report:
                    fragment = new ReportFrag();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };


    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private void createNotification() {
        final List<String> contentNoti = new ArrayList<String>();
        contentNoti.add("Drone ma so drone_ggwp_01 da khoi dong");
        contentNoti.add("Drone ma so drone_ggwp_02 da khoi dong");
        contentNoti.add("Drone ma so drone_ggwp_03 da khoi dong");
        contentNoti.add("Drone ma so drone_ggwp_04 da khoi dong");

        //mNotifyMgr.notify(001,mBuilder.build());
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.arg1 == 1) {
                    mBuilder = new NotificationCompat.Builder(getApplicationContext())
                            .setSmallIcon(R.drawable.ic_notification)
                            .setContentTitle("Thong bao")
                            .setContentText(contentNoti.get(msg.arg2));
                    mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    mNotifyMgr.notify(msg.arg2,mBuilder.build());
                    vibrator.vibrate(500);
                }
            }
        };

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag<4) {
                    SystemClock.sleep(60000);
                    Message msg = handler.obtainMessage();
                    msg.arg1 = 1;
                    msg.arg2 = flag;
                    handler.sendMessage(msg);
                    flag++;
                }

            }
        }) ;
        thread.start();
    }
}
