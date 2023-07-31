package com.railway.train.domain.exception;

import com.railway.train.domain.TrainId;

public class TrainNotFoundException extends RuntimeException{

    public TrainNotFoundException(TrainId id) {
        super("No train of id " + id + " found");
    }

}
