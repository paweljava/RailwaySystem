package com.railway.train.domain;

import com.railway.train.domain.dto.CreateTrainDto;
import com.railway.train.domain.dto.TrainQueryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static java.util.Objects.requireNonNull;

public class TrainFacade {
    private final TrainRepository trainRepository;
    private final TrainCreator trainCreator;

    TrainFacade(TrainRepository trainRepository, TrainCreator trainCreator) {
        this.trainRepository = trainRepository;
        this.trainCreator = trainCreator;
    }

    public CreateTrainDto addTrain(CreateTrainDto createTrainDto) {
        requireNonNull(createTrainDto);
        final var train = trainCreator.from(createTrainDto);
        trainRepository.save(train);
        return train.trainCreateDto();
    }

    public TrainQueryDto show(TrainId id) {
        requireNonNull(id);
        final var train = trainRepository.findOneOrThrow(id);
        return train.trainQueryDto();
    }

    public Page<TrainQueryDto> findAll(Pageable pageable) {
        requireNonNull(pageable);
        return trainRepository
                .findAll(pageable)
                .map(Train::trainQueryDto);
    }

    public void delete(TrainId trainId) {
        requireNonNull(trainId);
        trainRepository.deleteById(trainId);
    }
}
