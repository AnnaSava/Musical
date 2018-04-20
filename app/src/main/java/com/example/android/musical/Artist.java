package com.example.android.musical;

/**
 * Created by Sava on 20.04.2018.
 */

public class Artist {
    private String mArtistName;
    private String mArtistInfo;

    public Artist(String artistName, String artistInfo) {
        mArtistName = artistName;
        mArtistInfo = artistInfo;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public String getArtistInfo() {
        return mArtistInfo;
    }
}
