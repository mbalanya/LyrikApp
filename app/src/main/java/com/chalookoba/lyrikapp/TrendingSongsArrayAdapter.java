package com.chalookoba.lyrikapp;

import android.content.Context;
import android.widget.ArrayAdapter;

public class TrendingSongsArrayAdapter extends ArrayAdapter { //array adapter class functionality (wk1)
    private Context mContext;
    private String[] mArtists;
    private String[] mGenres;

    public TrendingSongsArrayAdapter(Context mContext, int resource, String[] mArtists, String[] mGenres) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mArtists = mArtists;
        this.mGenres = mGenres;
    }

    @Override
    public Object getItem(int position) {
        String artists = mArtists[position];
        String genres = mGenres[position];
        return String.format("%s \nSings: %s", artists, genres);
    }

    @Override
    public int getCount() {
        return mArtists.length;
    }
}
