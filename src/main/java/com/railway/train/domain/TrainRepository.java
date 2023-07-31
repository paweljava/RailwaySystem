package com.railway.train.domain;

import com.railway.station.domain.exception.StationNotFoundException;
import com.railway.train.domain.exception.TrainNotFoundException;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
interface TrainRepository extends JpaRepository<Train, TrainId> {
    Train save(Train train);

    Page<Train> findAll(Pageable pageable);

    default Train findOneOrThrow(TrainId trainId) {
        final var train = findById(trainId).orElseThrow(() -> new TrainNotFoundException(trainId));;
        if (train == null) {
            throw new TrainNotFoundException(trainId);
        }
        return train;
    }
}