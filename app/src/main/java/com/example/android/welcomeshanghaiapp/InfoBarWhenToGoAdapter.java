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

public class InfoBarWhenToGoAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private ArrayList<InfoBarWhenToGo> mInfoBarsWhenToGo;

    // Constructor for the InfoBarWhenToGoAdapter class
    public InfoBarWhenToGoAdapter(Activity context, ArrayList<InfoBarWhenToGo> infoBarsWhenToGo) {
        mContext = context;
        mInfoBarsWhenToGo = infoBarsWhenToGo;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mInfoBarsWhenToGo.get(groupPosition);
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
            childView = layoutInflater.inflate(R.layout.list_item_infobar_whentogo_dropdown, null);
        }

        final InfoBarWhenToGo currentInfoBarWhenToGo = (InfoBarWhenToGo) getGroup(groupPosition);

        // Find the TextView for the avg high temperature
        TextView highTemp = (TextView) childView.findViewById(R.id.avg_high);

        // Set the proper information to the textview
        highTemp.setText("Avg High: " + currentInfoBarWhenToGo.getHighTemp() + "°");

        // Find the TextView for the avg low temperature
        TextView lowTemp = (TextView) childView.findViewById(R.id.avg_low);

        // Set the proper information to the textview
        lowTemp.setText("Avg Low: " + currentInfoBarWhenToGo.getLowTemp() + "°");

        // Find the TextView for the avg rainfall for the month
        TextView rainfall = (TextView) childView.findViewById(R.id.avg_rainfall);

        // Set the proper information to the textview
        rainfall.setText("Avg Rainfall: " + currentInfoBarWhenToGo.getRainfall() + '"');

        return childView;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mInfoBarsWhenToGo.get(groupPosition);
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public int getGroupCount() {
        return mInfoBarsWhenToGo.size();
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
        final InfoBarWhenToGo currentInfoBar = (InfoBarWhenToGo) getGroup(groupPosition);

        // Find the ImageView for the icon in the list_item_infobar.xml
        ImageView infoBarIcon = (ImageView) groupView.findViewById(R.id.infobar_icon);

        // Set the icon image to this iconImage ImageView
        infoBarIcon.setImageResource(currentInfoBar.getIconId());

        // Find the TextView for name in the list_item_infobar.xml
        TextView infoBarName = (TextView) groupView.findViewById(R.id.infobar_name);

        // Set the proper text for the current site to this TextView
        infoBarName.setText(currentInfoBar.getMonth());

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
