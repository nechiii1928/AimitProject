package com.nelson.aimitproject.Pages;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nelson.aimitproject.MainActivity;
import com.nelson.aimitproject.Notifetch;
import com.nelson.aimitproject.ProfileActivity;
import com.nelson.aimitproject.R;

import java.util.ArrayList;


public class Notifications extends Fragment  {
    FloatingActionButton fb;
    SwipeRefreshLayout refreshLayout;
    ListView lvNotifs ;
    FirebaseDatabase datebase;
    DatabaseReference ref;
    ArrayList<String>list;
    ArrayAdapter<String>adapter;
    Notifetch notifetch;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View fragment_two = inflater.inflate(R.layout.fragment_notifications, container, false);
        fb = fragment_two.findViewById(R.id.fabset);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ProfileActivity.class);
                startActivity(i);
            }
        });
        notifetch = new Notifetch();
        refreshLayout = fragment_two.findViewById(R.id.swipelay);
        lvNotifs = fragment_two.findViewById(R.id.lvNotif);

        datebase = FirebaseDatabase.getInstance();
        ref = datebase.getReference("notifs");
        list = new ArrayList<>();

        adapter = new ArrayAdapter<String>(getContext(),R.layout.notif_frame,R.id.notinfo,list);



        refreshLayout.setColorSchemeColors(getResources().getColor(R.color.black));
        refreshLayout.setRefreshing(true);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(false);
                lvNotifs.setAdapter(null);
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds:dataSnapshot.getChildren()){
                            notifetch = ds.getValue(Notifetch.class);
                            Log.d("abs","df"+notifetch.getTextsend());

                            list.add(notifetch.getTextsend().toString());


                        }
                        lvNotifs.setAdapter(adapter);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        },2000);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.setRefreshing(false);
                        ref.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                for(DataSnapshot ds:dataSnapshot.getChildren()){
                                    notifetch = ds.getValue(Notifetch.class);
                                    Log.d("abs","df"+notifetch.getTextsend());
                                    list.add(notifetch.getTextsend().toString());
                                }
                                lvNotifs.setAdapter(adapter);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                },3000);
            }
        });



        return fragment_two;
    }




}