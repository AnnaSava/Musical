package com.example.android.musical;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    boolean isPlaying = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView songImageView = (ImageView) findViewById(R.id.details_image);
        int imageResourseId = getIntent().getIntExtra("EXTRA_IMAGE", 0);

        songImageView.setImageResource(imageResourseId);

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

        final ImageView playPause = (ImageView) findViewById(R.id.play_pause);
        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text;

                if (isPlaying) {
                    text = "Pause";
                    isPlaying = false;
                    playPause.setImageResource(R.drawable.ic_play);

                } else {
                    text = "Playing";
                    isPlaying = true;
                    playPause.setImageResource(R.drawable.ic_pause);
                }

                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        ImageView skipPrev = (ImageView) findViewById(R.id.skip_prev);
        skipPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Previous song", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        ImageView skipNext = (ImageView) findViewById(R.id.skip_next);
        skipNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Next song", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
