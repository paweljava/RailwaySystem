package com.railway.train.domain;

import com.railway.train.domain.dto.CreateTrainDto;
import com.railway.train.domain.dto.TrainQueryDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@Entity
@EqualsAndHashCode(of = "trainId")
@Table(name = "train")
class Train {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "trainId"))
    })
    private final String trainId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "trainName"))
    })
    private final String trainName;

    final CreateTrainDto trainCreateDto() {
        return CreateTrainDto.builder()
                .name(trainName)
                .build();
    }

    final TrainQueryDto trainQueryDto() {
        return TrainQueryDto.builder()
                .name(trainName)
                .build();
    }
}

