package com.example.android.musical;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        ArrayList<Artist> artists = new ArtistRepo(getResources()).getArtists();

        ArtistAdapter adapter = new ArtistAdapter(this, artists);

        GridView gridView = (GridView) findViewById(R.id.artist_list);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent artistIntent = new Intent(LibraryActivity.this, ArtistActivity.class);

                Artist artist = (Artist) adapter.getItemAtPosition(position);
                artistIntent.putExtra("EXTRA_ARTIST", artist.getArtistName());
                startActivity(artistIntent);
            }
        });
    }
}
