package com.railway.station.domain.exception;

import java.util.UUID;

public class StationNotFoundException extends RuntimeException{

    public StationNotFoundException(UUID id) {
        super("No station of id " + id + " found");
    }
}