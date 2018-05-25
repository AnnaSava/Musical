package com.example.android.musical;

/**
 * Created by Sava on 20.04.2018.
 */

public class Artist {
    private String mArtistName;
    private String mArtistInfo;
    private int mImageResourceId;

    public Artist(String artistName, String artistInfo, int imageResourceId) {
        mArtistName = artistName;
        mArtistInfo = artistInfo;
        mImageResourceId = imageResourceId;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public String getArtistInfo() {
        return mArtistInfo;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
