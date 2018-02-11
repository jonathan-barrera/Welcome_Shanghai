package com.example.android.welcomeshanghaiapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Set;
import java.util.zip.Inflater;

/**
 * Created by jonathanbarrera on 2/9/18.
 * This custom InfoBarAdapter class can adapt instances from the Word class to
 * an array for TextView inflation.
 */

public class InfoBarAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private ArrayList<InfoBar> mInfoBars;

    // Constructor for the InfoBarAdapter class
    public InfoBarAdapter(Activity context, ArrayList<InfoBar> infoBars) {
        mContext = context;
        mInfoBars = infoBars;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mInfoBars.get(groupPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        View childView = convertView;

        if (childView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            childView = layoutInflater.inflate(R.layout.list_item_infobar_dropdown, null);
        }

        final InfoBar currentInfoBar = (InfoBar) getGroup(groupPosition);

        // Find the ImageView for the place picture in the list_item_infobar.xml
        ImageView infoBarPicture = (ImageView) childView.findViewById(R.id.infobar_pic);

        // Set the proper picture to the above ImageView.
        infoBarPicture.setImageResource(currentInfoBar.getImageResourceId());

        // Find the TextView for the address in the list_item_infobar.xml
        TextView infoBarAddress = (TextView) childView.findViewById(R.id.infobar_address);

        // Set the proper address to the above text view
        infoBarAddress.setText(currentInfoBar.getAddress());

        return childView;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mInfoBars.get(groupPosition);
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public int getGroupCount() {
        return mInfoBars.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        View groupView = convertView;

        if (groupView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            groupView = layoutInflater.inflate(R.layout.list_item_infobar, null);
        }

        // get the InfoBar object at this position in the list.
        final InfoBar currentInfoBar = (InfoBar) getGroup(groupPosition);

        // Find the ImageView for the icon in the list_item_infobar.xml
        ImageView infoBarIcon = (ImageView) groupView.findViewById(R.id.infobar_icon);

        // Set the icon image to this iconImage ImageView
        infoBarIcon.setImageResource(currentInfoBar.getIconId());

        // Find the TextView for name in the list_item_infobar.xml
        TextView infoBarName = (TextView) groupView.findViewById(R.id.infobar_name);

        // Set the proper text for the current site to this TextView
        infoBarName.setText(currentInfoBar.getName());

        return groupView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
