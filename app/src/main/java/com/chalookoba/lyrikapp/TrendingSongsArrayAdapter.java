package com.chalookoba.lyrikapp;

import android.content.Context;
import android.widget.ArrayAdapter;

public class TrendingSongsArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mArtists;
    private String[] mGenres;

    public TrendingSongsArrayAdapter(Context mContext, int resource, String[] mArtists, String[] mGenres) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mArtists = mArtists;
        this.mGenres = mGenres;
    }
}
