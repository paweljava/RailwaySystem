package com.railway.train.domain;

import com.railway.train.domain.dto.CreateTrainDto;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

class TrainCreator {
    Train from(CreateTrainDto createTrainDto) {
        requireNonNull(createTrainDto);
        return Train.builder()
                .trainId(UUID.randomUUID().toString())
                .trainName(createTrainDto.getName())
                .build();
    }
}
