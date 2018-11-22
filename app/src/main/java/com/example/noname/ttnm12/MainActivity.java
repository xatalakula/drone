package com.example.noname.ttnm12;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;



public class MainActivity extends AppCompatActivity implements
        DashBoardFrag.OnFragmentInteractionListener,DroneFrag.OnFragmentInteractionListener,
        GeneralFrag.OnFragmentInteractionListener {

    private ActionBar toolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = getSupportActionBar();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationView);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        Intent intent1 = getIntent();
        if(intent1 != null && intent1.getBooleanExtra("detail",false)) {
            navigation.setSelectedItemId(R.id.navigation_drone);
            loadFragment(new DetailDroneFrag());
        }else {
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
}
