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

        TextView details = (TextView) findViewById(R.id.now_playing_text);
        details.setText("Current song");

        ArrayList<Song> songs = new SongRepo(getResources()).getSongs();

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent songIntent = new Intent(MainActivity.this, DetailsActivity.class);
                TextView playingView = (TextView) findViewById(R.id.now_playing_text);

                Song song = (Song) adapter.getItemAtPosition(position);

                playingView.setText(song.getArtistName() + " - " + song.getSongName());
                songIntent.putExtra("EXTRA_SONG", song.getSongName());
                songIntent.putExtra("EXTRA_ARTIST", song.getArtistName());
                songIntent.putExtra("EXTRA_IMAGE", song.getImageResourceId());
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
