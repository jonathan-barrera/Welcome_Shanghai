package com.example.android.welcomeshanghaiapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class WhenToGoActivity extends AppCompatActivity {

    // set global variable to keep track of the last expanded ExpandableList item position
    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_bar_list);

        // Create an array list to contain all of the infobars for recommended tourist sites.
        final ArrayList<InfoBarWhenToGo> infoBarsWhenToGo = new ArrayList<InfoBarWhenToGo>();

        // Add each infobar to the Array List
        infoBarsWhenToGo.add(new InfoBarWhenToGo("January", R.drawable.icons8_winter_48,
                47, 34, 1.5));
        infoBarsWhenToGo.add(new InfoBarWhenToGo("February", R.drawable.icons8_winter_48,
                49, 37, 2.3));
        infoBarsWhenToGo.add(new InfoBarWhenToGo("March", R.drawable.icons8_spring_48,
                56, 43, 3.2));
        infoBarsWhenToGo.add(new InfoBarWhenToGo("April", R.drawable.icons8_spring_48,
                67, 53, 4));
        infoBarsWhenToGo.add(new InfoBarWhenToGo("May", R.drawable.icons8_spring_48,
                76, 62, 4.5));
        infoBarsWhenToGo.add(new InfoBarWhenToGo("June", R.drawable.icons8_summer_48,
                82, 70, 6));
        infoBarsWhenToGo.add(new InfoBarWhenToGo("July", R.drawable.icons8_summer_48,
                90, 78, 5.1));
        infoBarsWhenToGo.add(new InfoBarWhenToGo("August", R.drawable.icons8_summer_48,
                89, 78, 5.2));
        infoBarsWhenToGo.add(new InfoBarWhenToGo("September", R.drawable.icons8_autumn_48,
                82, 70, 6.1));
        infoBarsWhenToGo.add(new InfoBarWhenToGo("October", R.drawable.icons8_autumn_48,
                73, 60, 2.4));
        infoBarsWhenToGo.add(new InfoBarWhenToGo("November", R.drawable.icons8_autumn_48,
                63, 49, 2));
        infoBarsWhenToGo.add(new InfoBarWhenToGo("December", R.drawable.icons8_winter_48,
                52, 38, 1.4));
        // Declare a new InfoBarAdapter (custom ArrayAdapter) and initialize with the information
        // for What To See
        InfoBarWhenToGoAdapter itemsAdapter = new InfoBarWhenToGoAdapter(this, infoBarsWhenToGo);

        // Declare a new Listview and set the layout in info_bar_list.xml
        final ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.list);

        // Set the adapter
        expandableListView.setAdapter(itemsAdapter);

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
}
