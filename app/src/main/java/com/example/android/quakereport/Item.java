package com.example.android.quakereport;

public class Item {

    private String mLocationRadius, mLocationArea, mDate, mTime, mUrl;
    private double mMagnitude;

    public Item(double magnitude, String locationRadius, String locationArea, String date, String time, String url){
        mMagnitude = magnitude;
        mLocationRadius = locationRadius;
        mLocationArea = locationArea;
        mDate = date;
        mTime = time;
        mUrl = url;
    }

    public double getMagnitude() { return mMagnitude; }
    public String getLocationRadius() { return mLocationRadius; }
    public String getLocationArea() { return mLocationArea; }
    public String getDate() { return mDate; }
    public String getTime() { return mTime; }
    public String getUrl() { return mUrl; }
}
