package com.example.android.musical;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView songTextView = (TextView) findViewById(R.id.song_title);

        String song = getIntent().getStringExtra("EXTRA_SONG");
        songTextView.setText(song);

        TextView artistTextView = (TextView) findViewById(R.id.artist_name);

        final String artist = getIntent().getStringExtra("EXTRA_ARTIST");
        artistTextView.setText(artist);

        // Set a click listener on that View
        artistTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistIntent = new Intent(DetailsActivity.this, ArtistActivity.class);
                artistIntent.putExtra("EXTRA_ARTIST", artist);
                startActivity(artistIntent);
            }
        });
    }
}
