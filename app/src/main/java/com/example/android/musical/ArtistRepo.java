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
                res.getString(R.string.info_songs_from_north_woods),
                R.drawable.artist_songs_from_north_woods));
        artists.add(new Artist(res.getString(R.string.artist_asche_und_staub),
                res.getString(R.string.info_asche_und_staub),
                R.drawable.artist_asche_und_staub));
        artists.add(new Artist(res.getString(R.string.artist_manticore),
                res.getString(R.string.info_manticore),
                R.drawable.artist_manticore));
        artists.add(new Artist(res.getString(R.string.artist_night_ride),
                res.getString(R.string.info_night_ride),
                R.drawable.artist_night_ride));
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public Artist getArtistByName(String artistName)
    {
        for(int i=0;i<artists.size();i++)
        {
            if(artists.get(i).getArtistName().equals(artistName)){
                return artists.get(i);
            }
        }
        return null;
    }
}
