package com.nelson.aimitproject;


import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.nelson.aimitproject.PageAdapter.FragmentAdapter;
import com.nelson.aimitproject.Pages.Home;
import com.nelson.aimitproject.Pages.Notifications;
import com.nelson.aimitproject.Pages.TimeTable;


public class MainActivity extends AppCompatActivity {
    private static final String TAG ="nech";
    ViewPager viewPager;
    BottomNavigationView navigation;
    FloatingActionButton fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        viewPager = findViewById(R.id.viewpager);
        setupFm(getSupportFragmentManager(), viewPager);
        viewPager.setCurrentItem(0);

        viewPager.addOnPageChangeListener(new PageChange());


    }


    public static void setupFm(FragmentManager fragmentManager, ViewPager viewPager){
        FragmentAdapter Adapter = new FragmentAdapter(fragmentManager);

        Adapter.add(new Home(), "Page One");
        Log.d(TAG,"Nnnnegergergehnnnn");
        Adapter.add(new TimeTable(), "Page Two");
        Adapter.add(new Notifications(), "Page Three");

        viewPager.setAdapter(Adapter);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    viewPager.setCurrentItem(0);
                    Log.d(TAG,"Nnnnrhhrrhhr");
                    return true;
                case R.id.navigation_timetable:

                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };


    public class PageChange implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            switch (position) {
                case 0:
                    navigation.setSelectedItemId(R.id.navigation_home);
                    Log.d(TAG,"Nnnnnnnn");
                    return;
                case 1:
                    navigation.setSelectedItemId(R.id.navigation_timetable);
                    return;
                case 2:
                    navigation.setSelectedItemId(R.id.navigation_notifications);
                    return;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    private boolean loadPage(Fragment fragment) {

        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.viewcontainer, fragment)
                    .commit();
            return true;
        }
        return false;
    }


}
