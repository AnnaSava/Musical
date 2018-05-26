package com.example.android.musical;

import android.content.res.Resources;

import java.util.ArrayList;

/**
 * Created by Sava on 25.05.2018.
 */

public class SongRepo {
    ArrayList<Song> songs;

    public SongRepo(Resources res) {
        songs = new ArrayList<Song>();
        songs.add(new Song(res.getString(R.string.song_winter_lullaby),
                res.getString(R.string.artist_songs_from_north_woods),
                R.drawable.artist_songs_from_north_woods));
        songs.add(new Song(res.getString(R.string.song_wolf_and_bear),
                res.getString(R.string.artist_songs_from_north_woods),
                R.drawable.artist_songs_from_north_woods));
        songs.add(new Song(res.getString(R.string.song_song_for_spinning),
                res.getString(R.string.artist_songs_from_north_woods),
                R.drawable.artist_songs_from_north_woods));
        songs.add(new Song(res.getString(R.string.song_licht_der_aeterna),
                res.getString(R.string.artist_asche_und_staub),
                R.drawable.artist_asche_und_staub));
        songs.add(new Song(res.getString(R.string.song_asche_und_staub),
                res.getString(R.string.artist_asche_und_staub),
                R.drawable.artist_asche_und_staub));
        songs.add(new Song(res.getString(R.string.song_flugel_der_krahe),
                res.getString(R.string.artist_asche_und_staub),
                R.drawable.artist_asche_und_staub));
        songs.add(new Song(res.getString(R.string.song_iris_oder_schwert),
                res.getString(R.string.artist_asche_und_staub),
                R.drawable.artist_asche_und_staub));
        songs.add(new Song(res.getString(R.string.song_rune_stone),
                res.getString(R.string.artist_manticore),
                R.drawable.artist_manticore));
        songs.add(new Song(res.getString(R.string.song_something_between_trees),
                res.getString(R.string.artist_manticore),
                R.drawable.artist_manticore));
        songs.add(new Song(res.getString(R.string.song_emerald_eyes),
                res.getString(R.string.artist_manticore),
                R.drawable.artist_manticore));
        songs.add(new Song(res.getString(R.string.song_amethyst),
                res.getString(R.string.artist_manticore),
                R.drawable.artist_manticore));
        songs.add(new Song(res.getString(R.string.song_wolf_step),
                res.getString(R.string.artist_night_ride),
                R.drawable.artist_night_ride));
        songs.add(new Song(res.getString(R.string.song_bones),
                res.getString(R.string.artist_night_ride),
                R.drawable.artist_night_ride));
        songs.add(new Song(res.getString(R.string.song_day_song),
                res.getString(R.string.artist_night_ride),
                R.drawable.artist_night_ride));
        songs.add(new Song(res.getString(R.string.song_shadows_after_dark),
                res.getString(R.string.artist_night_ride),
                R.drawable.artist_night_ride));
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public ArrayList<Song> getSongsByArtist(String artistName) {
        ArrayList<Song> songsByArtist = new ArrayList<Song>();

        for (int i = 0; i < songs.size(); i++) {
            Song song = songs.get(i);
            if (song.getArtistName().equals(artistName)) {
                songsByArtist.add(song);
            }
        }
        return songsByArtist;
    }
}
