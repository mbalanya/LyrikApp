package com.chalookoba.lyrikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TrendingSongsActivity extends AppCompatActivity {
    private TextView mSearchArtistTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending_songs);
        mSearchArtistTextView = (TextView) findViewById(R.id.artistSearchTextView);
        Intent intent = getIntent();
        String artistSearch = intent.getStringExtra("artistSearch");
        mSearchArtistTextView.setText("Here are all the songs by: " + artistSearch);
    }
}