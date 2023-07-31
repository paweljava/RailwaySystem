package com.railway.train.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TrainQueryDto {

    private final String id;
    private final String name;

    public TrainQueryDto(String id, String name) {
        this.id = id;
        this.name = name;
    }
}