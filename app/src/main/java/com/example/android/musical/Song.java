package com.example.android.musical;

/**
 * Created by Sava on 17.04.2018.
 */

public class Song {
    private String mSongName;
    private String mArtistName;
    private int mImageResourceId;

    public Song(String songName, String artistName, int imageResourceId) {
        mSongName = songName;
        mArtistName = artistName;
        mImageResourceId = imageResourceId;
    }

    public String getSongName() {
        return mSongName;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
