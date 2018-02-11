package com.example.android.welcomeshanghaiapp;

/**
 * Created by jonathanbarrera on 2/9/18.
 * {@link InfoBarWhenToGo} represents the weather information for a month for the user.
 * It contains the name (month) and icon (season), the avg high temp, avg low temp, and avg rainfall.
 */

public class InfoBarWhenToGo {
    // Name of the site
    private String mMonth;

    // Icon resource for the site
    private int mIconId;

    // Average high temperature
    private int mHighTemp;

    // Average low temperature
    private int mLowTemp;

    // Average rainfall
    private double mRainfall;

    /** The constructor for the When To Go infobars. */
    public InfoBarWhenToGo(String name, int iconId, int highTemp, int lowTemp, double rainfall){
        mMonth = name;
        mIconId = iconId;
        mHighTemp = highTemp;
        mLowTemp = lowTemp;
        mRainfall = rainfall;
    }

    /** Get the name of the month */
    public String getMonth() {
        return mMonth;
    }

    /** Get the icon id for the month */
    public int getIconId() {
        return mIconId;
    }

    /** Get the average high temp for the month */
    public int getHighTemp() {
        return mHighTemp;
    }

    /** Get the avg low temp for the month */
    public int getLowTemp() {
        return mLowTemp;
    }

    /** Get the avg rainfall for the month */
    public double getRainfall() {
        return mRainfall;
    }

}
