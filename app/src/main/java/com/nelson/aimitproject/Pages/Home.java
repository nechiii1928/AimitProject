package com.nelson.aimitproject.Pages;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nelson.aimitproject.R;


public class Home extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragment_three = inflater.inflate(R.layout.fragment_home, container, false);

        return fragment_three;
    }




    //LOAD PAGE FRAGMENT METHOD

}