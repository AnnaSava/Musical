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
        songs.add(new Song("Just A Song", "Anonymous"));
        songs.add(new Song("The Second Song", "Anonymous"));
        songs.add(new Song("La la la", "Mother Nature"));

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
