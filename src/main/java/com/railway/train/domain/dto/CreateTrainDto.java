package com.railway.train.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateTrainDto {

    private final String name;
}
