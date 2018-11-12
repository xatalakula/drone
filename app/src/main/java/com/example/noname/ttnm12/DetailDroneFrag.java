package com.example.noname.ttnm12;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailDroneFrag extends Fragment {

    SectionsPagerAdapter sectionsPagerAdapter;
    ViewPager viewPager;
    public DetailDroneFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_drone, container, false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_detail);
        sectionsPagerAdapter = new SectionsPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager = (ViewPager) view.findViewById(R.id.container_detail);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_detail);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }


    class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            if(i == 0) {
                return new InfoDroneFrag();
            }
            else {
                return new OperationDroneFrag();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Thông tin";
                case 1:
                    return "Hoạt động";
            }
            return null;
        }
    }

}
