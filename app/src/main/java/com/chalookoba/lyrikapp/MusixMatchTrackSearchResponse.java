
package com.chalookoba.lyrikapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MusixMatchTrackSearchResponse {

    @SerializedName("message")
    @Expose
    private Message message;
    /*@SerializedName("tracks")
    @Expose
    private List<Track> tracks = null;*/

    /**
     * No args constructor for use in serialization
     * 
     */
    public MusixMatchTrackSearchResponse() {
    }

    /**
     * 
     * @param message
     */
    public MusixMatchTrackSearchResponse(Message message) {
        super();
        this.message = message;
        /*this.tracks = tracks;*/
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    /*public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks() {
        this.tracks = tracks;
    }*/

}
