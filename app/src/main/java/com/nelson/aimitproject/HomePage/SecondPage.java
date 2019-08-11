package com.nelson.aimitproject.HomePage;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nelson.aimitproject.R;


public class SecondPage extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View secondpag = inflater.inflate(R.layout.tab_second_page, container, false);

        return secondpag;
    }
}

