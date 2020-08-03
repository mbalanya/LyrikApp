package com.chalookoba.lyrikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrendingSongsActivity extends AppCompatActivity {
    @BindView(R.id.artistSearchTextView) TextView mArtistSearchTextView;
    @BindView(R.id.listView) ListView mListView;
    private String[] artists = new String[] {"Juice WRLD", "The Chicks",
            "Pop Smoke", "Harry Styles", "Lil Baby", "Post Malone",
            "DaBaby", "Luke Combs", "The Weekend", "BTS",
            "Drake", "Jhene Aiko", "Roddy Ricch",
            "Dua Lipa", "Morgan Wallen", "Lewis Capaldi", "Dj Khaled", "Billie Eilish", "Megan Thee Stallion", "Justin Bieber"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending_songs);
        ButterKnife.bind(this);


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, artists);
        mListView.setAdapter(adapter);

        Intent intent = getIntent();
        String artistSearch = intent.getStringExtra("artistSearch");
        mArtistSearchTextView.setText("Here are all the songs by: " + artistSearch);
    }
}