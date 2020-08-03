package com.chalookoba.lyrikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mSearchSongButton;
    private EditText mArtistSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "Welcome to LyrikApp World!", Toast.LENGTH_LONG).show();
        mArtistSearch = (EditText) findViewById(R.id.artistSearch);
        mSearchSongButton = (Button)findViewById(R.id.searchSongButton);
        mSearchSongButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, TrendingSongsActivity.class);
                startActivity(intent);
                String artistSearch = mArtistSearch.getText().toString();
                Toast.makeText(MainActivity.this, artistSearch, Toast.LENGTH_LONG).show();
            }
        });
    }
}