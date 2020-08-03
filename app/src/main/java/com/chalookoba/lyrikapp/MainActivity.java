package com.chalookoba.lyrikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.searchSongButton) Button mSearchSongButton;
    @BindView(R.id.artistSearch) EditText mArtistSearch;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toast.makeText(MainActivity.this, "Welcome to LyrikApp World!", Toast.LENGTH_LONG).show();

        mSearchSongButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mSearchSongButton){
            String artistSearch = mArtistSearch.getText().toString();
            Intent intent = new Intent(MainActivity.this, TrendingSongsActivity.class);
            intent.putExtra("artistSearch", artistSearch);
            startActivity(intent);
        }
    }
}