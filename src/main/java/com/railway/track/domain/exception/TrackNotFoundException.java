package com.railway.track.domain.exception;

public class TrackNotFoundException extends RuntimeException{

    public TrackNotFoundException(String id) {
        super("No track of id " + id + " found");
    }
}