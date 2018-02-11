package com.example.android.welcomeshanghaiapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class WhatToSeeActivity extends AppCompatActivity {

    // set global variable to keep track of the last expanded ExpandableList item position
    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_bar_list);

        // Create an array list to contain all of the infobars for recommended tourist sites.
        final ArrayList<InfoBar> infoBars = new ArrayList<InfoBar>();

        // Add each infobar to the Array List
        infoBars.add(new InfoBar("The Bund", R.drawable.icons8_bund_48, R.drawable.shanghai_bund,
                "Zhongshan East 1st Rd, WaiTan, Huangpu Qu, Shanghai Shi, China, 200000"));
        infoBars.add(new InfoBar("Lujiazui", R.drawable.icons8_lujiazui_48, R.drawable.shanghai_lujiazui,
                "Lujiazui, Pudong, Shanghai, China"));
        infoBars.add(new InfoBar("French Concession", R.drawable.icons8_frenchconcession_48,
                R.drawable.shanghai_frenchconcession, "Huaihai Road West Section, Xuhui, Shanghai, China"));
        infoBars.add(new InfoBar("People's Square", R.drawable.icons8_peoplessquare_48,
                R.drawable.shanghai_peoplessquare, "People's Square, Huangpu, Shanghai, China"));
        infoBars.add(new InfoBar("East Nanjing Road", R.drawable.icons8_nanjingeast_48,
                R.drawable.shanghai_eastnanjing, "Nan Jing Dong Lu, Huangpu Qu, Shanghai Shi, China"));
        infoBars.add(new InfoBar("West Nanjing Road", R.drawable.icons8_nanjingwest_48,
                R.drawable.shanghai_westnanjing, "Nan Jing Xi Lu, NanJing XiLu, Shanghai Shi, China"));
        infoBars.add(new InfoBar("Yuyuan Garden", R.drawable.icons8_yuyuan_48, R.drawable.shanghai_yuyuan,
                "218 Anren St, Huangpu Qu, Shanghai Shi, China"));
        infoBars.add(new InfoBar("Shanghai Expo Park", R.drawable.icons8_expopark_48,
                R.drawable.shanghai_expo, "1700 Shibo Ave, Pudong Xinqu, Shanghai Shi, China"));

        // Declare a new InfoBarAdapter (custom ArrayAdapter) and initialize with the information
        // for What To See
        InfoBarAdapter itemsAdapter = new InfoBarAdapter(this, infoBars);

        // Declare a new Listview and set the layout in info_bar_list.xml
        final ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.list);

        // Set the adapter
        expandableListView.setAdapter(itemsAdapter);

        /**
         * Set an OnItemLongClickListener so that when the user long presses on a child view,
         * the app will send an implicit intent to open a maps application.
         */
        expandableListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (ExpandableListView.getPackedPositionType(id) == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
                    int groupPosition = ExpandableListView.getPackedPositionGroup(id);

                    // Get the child view that was clicked
                    InfoBar infoBar = infoBars.get(groupPosition);

                    // Get the address of the clicked child view
                    String address = infoBar.getAddress();

                    // Encode the address in Uri format
                    Uri uriAddress = Uri.parse("geo:0,0?q=" + Uri.encode(address));

                    // Call showMap intent method
                    showMap(uriAddress);

                    return true;
                }
                return true;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });

    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
