package com.chalookoba.lyrikapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MusixMatchApi {

    @GET("track.search")
    Call<MusixMatchTrackSearchResponse> getMusic(
            @Query("track") String track,
            @Query("artist") String artist
    );
}