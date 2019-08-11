package com.nelson.aimitproject.Pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nelson.aimitproject.HomePage.FirstPage;
import com.nelson.aimitproject.HomePage.SecondPage;
import com.nelson.aimitproject.PageAdapter.SectionPagerAdapter;
import com.nelson.aimitproject.R;


public class TimeTable extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragment_two = inflater.inflate(R.layout.fragment_timetable, container, false);



        SectionPagerAdapter adapter = new SectionPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new FirstPage()); // index 0
        adapter.addFragment(new SecondPage());//here 1
        ViewPager viewPager = (ViewPager)fragment_two.findViewById(R.id.viewcontainer);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout)fragment_two.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dashboard_black_24dp);

        return fragment_two;
    }

}