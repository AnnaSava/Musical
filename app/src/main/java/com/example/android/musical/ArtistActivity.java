package com.example.android.musical;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        TextView artistTextView = (TextView) findViewById(R.id.artist_title);

        String artist = getIntent().getStringExtra("EXTRA_ARTIST");
        artistTextView.setText(artist);

        TextView infoTextView = (TextView) findViewById(R.id.artist_details_info);

        String info = getIntent().getStringExtra("EXTRA_INFO");
        infoTextView.setText(info);

        ImageView artistImageView = (ImageView) findViewById(R.id.artist_details_image);
        int imageResourseId = getIntent().getIntExtra("EXTRA_IMAGE", 0);
        artistImageView.setImageResource(imageResourseId);

        ArrayList<Song> songs = new SongRepo(getResources()).getSongsByArtist(artist);



        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.artist_songs_list);

        listView.setAdapter(adapter);
    }
}
