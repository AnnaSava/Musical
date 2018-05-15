package com.example.android.musical;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView details = (TextView) findViewById(R.id.details_text);
        details.setText("Current song");

        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song(getResources().getString(R.string.song_winter_lullaby),
                getResources().getString(R.string.artist_songs_from_north_woods)));
        songs.add(new Song(getResources().getString(R.string.song_wolf_and_bear),
                getResources().getString(R.string.artist_songs_from_north_woods)));
        songs.add(new Song(getResources().getString(R.string.song_song_for_spinning),
                getResources().getString(R.string.artist_songs_from_north_woods)));
        songs.add(new Song(getResources().getString(R.string.song_licht_der_aeterna),
                getResources().getString(R.string.artist_asche_und_staub)));
        songs.add(new Song(getResources().getString(R.string.song_asche_und_staub),
                getResources().getString(R.string.artist_asche_und_staub)));
        songs.add(new Song(getResources().getString(R.string.song_flugel_der_krahe),
                getResources().getString(R.string.artist_asche_und_staub)));
        songs.add(new Song(getResources().getString(R.string.song_iris_oder_schwert),
                getResources().getString(R.string.artist_asche_und_staub)));

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent songIntent = new Intent(MainActivity.this, DetailsActivity.class);

                Song song = (Song) adapter.getItemAtPosition(position);
                songIntent.putExtra("EXTRA_SONG", song.getSongName());
                songIntent.putExtra("EXTRA_ARTIST", song.getArtistName());
                startActivity(songIntent);
            }
        });

        TextView artistTextView = (TextView) findViewById(R.id.artists_text);

        // Set a click listener on that View
        artistTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistIntent = new Intent(MainActivity.this, LibraryActivity.class);
                startActivity(artistIntent);
            }
        });
    }
}
