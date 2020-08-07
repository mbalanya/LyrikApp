
package com.chalookoba.lyrikapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MusixMatchTrackSearchResponse {

    @SerializedName("message")
    @Expose
    private Message message;

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
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

}
