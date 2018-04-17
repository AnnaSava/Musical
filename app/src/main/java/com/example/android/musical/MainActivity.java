package com.example.android.musical;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    }
}
