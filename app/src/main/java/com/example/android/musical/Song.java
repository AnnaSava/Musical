package com.example.android.musical;

/**
 * Created by Sava on 17.04.2018.
 */

public class Song {
    private String mSongName;
    private String mArtistName;

    public Song(String songName, String artistName) {
        mSongName = songName;
        mArtistName = artistName;
    }

    public String getSongName() {
        return mSongName;
    }

    public String getArtistName() {
        return mArtistName;
    }
}
