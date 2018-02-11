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

public class WhatToEatActivity extends AppCompatActivity {

    // set global variable to keep track of the last expanded ExpandableList item position
    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_bar_list);

        // Create an array list to contain all of the infobars for recommended tourist sites.
        final ArrayList<InfoBar> infoBars = new ArrayList<InfoBar>();

        // Add each infobar to the Array List
        infoBars.add(new InfoBar("Shanghainese Food", R.drawable.icons8_crab_48, R.drawable.shanghaifood,
                "Shouning Road Crayfish, 58 Shouning Rd, Huangpu Qu, Shanghai Shi, China"));
        infoBars.add(new InfoBar("Yunnan Food", R.drawable.icons8_natural_food_48,
                R.drawable.yunnanfood,"Lotus Eatery, 85 Yangzhai Rd, Changning Qu, Shanghai Shi, China"));
        infoBars.add(new InfoBar("Sichuan Food", R.drawable.icons8_chili_pepper_48,
                R.drawable.sichuanfood, "Sichuan Citizen, 30号-4 Donghu Rd, Xuhui Qu, Shanghai Shi, China"));
        infoBars.add(new InfoBar("Beijing Food", R.drawable.icons8_grill_48,
                R.drawable.beijingfood, "Lao Bei Jing Qian Men Kao Ya,1 Henan S Rd, Huangpu Qu, " +
                "Shanghai Shi, China"));
        infoBars.add(new InfoBar("Hunan Food", R.drawable.icons8_fish_48,
                R.drawable.hunanfood, "Lake Nanxiangcun Flavor Restaurant, 168 Wulumuqi Middle Rd, " +
                "Xuhui Qu, Shanghai Shi, China"));
        infoBars.add(new InfoBar("Western Food", R.drawable.icons8_hamburger_48,
                R.drawable.westernfood, "Liquid Laundry, Huaihai Road West Section, Xuhui, China"));
        infoBars.add(new InfoBar("Cantonese Food", R.drawable.icons8_dim_sum_48, R.drawable.cantonesefood,
                "Sunya Cantonese Restaurant, 719 Nanjing Rd Pedestrian St, NanJing Lu, Huangpu Qu, " +
                        "Shanghai Shi, China"));
        infoBars.add(new InfoBar("Xinjiang Food", R.drawable.icons8_kebab_48,
                R.drawable.xinjiangfood, "Guanguan Jiwu Alcohol Restaurant, Huangpu, Shanghai, China"));

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
