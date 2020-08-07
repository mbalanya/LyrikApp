package com.chalookoba.lyrikapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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
    private String[] artists = new String[] {"Juice WRLD", "The Chicks",
            "Pop Smoke", "Harry Styles", "Lil Baby", "Post Malone",
            "DaBaby", "Luke Combs", "The Weekend", "BTS",
            "Drake", "Jhene Aiko", "Roddy Ricch",
            "Dua Lipa", "Morgan Wallen", "Lewis Capaldi", "Dj Khaled", "Billie Eilish", "Megan Thee Stallion", "Justin Bieber"};
    private String[] genres = new String[] {"Hiphop", "Genge",
            "Pop", "Rhumba", "Zilizopendwa", "Gengetone",
            "Hiphop", "RnB", "Reggae", "Metal",
            "Rock", "House", "RnB",
            "Genge", "Trap", "House", "Rhumba", "Reggae", "Pop", "Zilizopendwa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending_songs);
        ButterKnife.bind(this);

        // gets artist and genres arrays (wk1)
        TrendingSongsArrayAdapter adapter = new TrendingSongsArrayAdapter(this, android.R.layout.simple_list_item_1, artists, genres);
        mListView.setAdapter(adapter);

        // set intent and add custom views (wk1)
        Intent intent = getIntent();
        String artistSearch = intent.getStringExtra("artistSearch");
        mArtistSearchTextView.setText("Here are all the songs by: " + artistSearch);

        mFeedbackButton.setOnClickListener(this);

        MusixMatchApi client = MusixMatchClient.getClient();
        Call<MusixMatchTrackSearchResponse> call = client.getMusic(artistSearch, artistSearch);

        call.enqueue(new Callback<MusixMatchTrackSearchResponse>() {
            @Override
            public void onResponse(Call<MusixMatchTrackSearchResponse> call, Response<MusixMatchTrackSearchResponse> response) {
                if (response.isSuccessful()) {
                    List<TrackList> trackList = response.body().getTrackList();
                    String[] tracks = new String[trackList.size()];
                    String[] artists = new String[trackList.size()];
                }
            }

            @Override
            public void onFailure(Call<MusixMatchTrackSearchResponse> call, Throwable t) {

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

}