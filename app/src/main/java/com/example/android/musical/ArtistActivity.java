package com.example.android.musical;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        String artistName = getIntent().getStringExtra("EXTRA_ARTIST");
        artistTextView.setText(artistName);

        Artist artist = new ArtistRepo(getResources()).getArtistByName(artistName);

        TextView infoTextView = (TextView) findViewById(R.id.artist_details_info);

        infoTextView.setText(artist.getArtistInfo());

        ImageView artistImageView = (ImageView) findViewById(R.id.artist_details_image);
        artistImageView.setImageResource(artist.getImageResourceId());

        ArrayList<Song> songs = new SongRepo(getResources()).getSongsByArtist(artistName);

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.artist_songs_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent songIntent = new Intent(ArtistActivity.this, DetailsActivity.class);

                Song song = (Song) adapter.getItemAtPosition(position);

                songIntent.putExtra("EXTRA_SONG", song.getSongName());
                songIntent.putExtra("EXTRA_ARTIST", song.getArtistName());
                songIntent.putExtra("EXTRA_IMAGE", song.getImageResourceId());
                startActivity(songIntent);
            }
        });
    }
}
