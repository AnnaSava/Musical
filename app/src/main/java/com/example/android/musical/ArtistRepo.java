package com.example.android.musical;

import android.content.res.Resources;

import java.util.ArrayList;

/**
 * Created by Sava on 25.05.2018.
 */

public class ArtistRepo {

    ArrayList<Artist> artists;

    public ArtistRepo(Resources res) {
        artists = new ArrayList<Artist>();
        artists.add(new Artist(res.getString(R.string.artist_songs_from_north_woods),
                "Anonymous",
                R.drawable.artist_songs_from_north_woods));
        artists.add(new Artist(res.getString(R.string.artist_asche_und_staub),
                "Mother Nature",
                R.drawable.artist_asche_und_staub));
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }
}
