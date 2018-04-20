package com.example.android.musical;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        ArrayList<Artist> artists = new ArrayList<Artist>();
        artists.add(new Artist("Anonymous", "Anonymous"));
        artists.add(new Artist("Mother Nature", "Mother Nature"));

        ArtistAdapter adapter = new ArtistAdapter(this, artists);

        ListView listView = (ListView) findViewById(R.id.artist_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
