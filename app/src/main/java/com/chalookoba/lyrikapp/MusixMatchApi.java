package com.chalookoba.lyrikapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MusixMatchApi {
    //call querys for musixmatch database
    @GET("track.search")
    Call<MusixMatchTrackSearchResponse> getMusic(
            @Query("q_artist") String q_artist
            /*@Query("q_track") String q_track*/

    );
}