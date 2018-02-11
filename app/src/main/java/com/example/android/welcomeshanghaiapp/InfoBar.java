package com.example.android.welcomeshanghaiapp;

/**
 * Created by jonathanbarrera on 2/9/18.
 * {@link InfoBar} represents a point of interest for the user.
 * It contains the name, an icon, an image, and an address for the sites to see
 * and restaurants to visit.
 */

public class InfoBar {
    // Name of the site
    private String mName;

    // Icon resource for the site
    private int mIconId;

    // Image resource for the site
    private int mImageResourceId;

    // Address of the site
    private String mAddress;

    /** The constructor for the What To See and What To Eat infobars.
     *@param name is the name of the tourist site
     *@param address is the address of the tourist site
     *@param iconId is the id for the icon used for this inforbar
     *@param imageResourceId is the id for the image used for this infobar
     */
    public InfoBar(String name, int iconId, int imageResourceId, String address){
        mName = name;
        mIconId = iconId;
        mImageResourceId = imageResourceId;
        mAddress = address;
    }

    /** Get the name of the site */
    public String getName() {
        return mName;
    }

    /** Get the icon id for the site */
    public int getIconId() {
        return mIconId;
    }

    /** Get the image resource id for the site */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /** Get the site's address */
    public String getAddress() {
        return mAddress;
    }

}
