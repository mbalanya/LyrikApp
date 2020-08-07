package com.chalookoba.lyrikapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrendingSongsActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.artistSearchTextView) TextView mArtistSearchTextView;
    @BindView(R.id.listView) ListView mListView;
    @BindView(R.id.feedbackButton) Button mFeedbackButton;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    /*private String[] artists = new String[] {"Juice WRLD", "The Chicks",
            "Pop Smoke", "Harry Styles", "Lil Baby", "Post Malone",
            "DaBaby", "Luke Combs", "The Weekend", "BTS",
            "Drake", "Jhene Aiko", "Roddy Ricch",
            "Dua Lipa", "Morgan Wallen", "Lewis Capaldi", "Dj Khaled", "Billie Eilish", "Megan Thee Stallion", "Justin Bieber"};
    private String[] genres = new String[] {"Hiphop", "Genge",
            "Pop", "Rhumba", "Zilizopendwa", "Gengetone",
            "Hiphop", "RnB", "Reggae", "Metal",
            "Rock", "House", "RnB",
            "Genge", "Trap", "House", "Rhumba", "Reggae", "Pop", "Zilizopendwa"};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending_songs);
        ButterKnife.bind(this);

        // gets artist and genres arrays (wk1)
        /*TrendingSongsArrayAdapter adapter = new TrendingSongsArrayAdapter(this, android.R.layout.simple_list_item_1, artists, genres);
        mListView.setAdapter(adapter);*/

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String track = ((TextView)view).getText().toString();
                Toast.makeText(TrendingSongsActivity.this, track, Toast.LENGTH_LONG).show();
            }
        });

        // set intent and add custom views (wk1)
        Intent intent = getIntent();
        String artistSearch = intent.getStringExtra("artistSearch");
        mArtistSearchTextView.setText("Here are all the songs by: " + artistSearch);

        mFeedbackButton.setOnClickListener(this);

        MusixMatchApi client = MusixMatchClient.getClient();
        Call<MusixMatchTrackSearchResponse> call = client.getMusic(artistSearch);

        call.enqueue(new Callback<MusixMatchTrackSearchResponse>() {
            @Override
            public void onResponse(Call<MusixMatchTrackSearchResponse> call, Response<MusixMatchTrackSearchResponse> response) {
                hideProgressBar();

                if (response.isSuccessful()) {
                    List<Track> trackList = response.body().getTracks();
                    String[] tracks = new String[trackList.size()];
                    String[] artists = new String[trackList.size()];

                    for (int i = 0; i < tracks.length; i++) {
                        tracks[i] = trackList.get(i).getTrackName();
                    }

                    for (int i = 0; i < artists.length; i++) {
                        Track track = trackList.get(i).getArtistName().get(0);
                        artists[i] = track.getArtistName();

                    }

                    ArrayAdapter adapter = new TrendingSongsArrayAdapter(TrendingSongsActivity.this, android.R.layout.simple_list_item_1, tracks, artists);
                    mListView.setAdapter(adapter);

                    showTracks();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<MusixMatchTrackSearchResponse> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == mFeedbackButton) { // fragment link logic (wk1)
            FragmentManager fm = getSupportFragmentManager();
            FeedbackDialogFragment feedbackDialogFragment = new FeedbackDialogFragment();
            feedbackDialogFragment.show(fm, "Feedback Fragment");
        }
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showTracks() {
        mListView.setVisibility(View.VISIBLE);
        mArtistSearchTextView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

}