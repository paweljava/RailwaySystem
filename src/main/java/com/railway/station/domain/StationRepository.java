package com.railway.station.domain;

import com.railway.station.domain.exception.StationNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface StationRepository extends JpaRepository<Station, UUID> {

    //<S extends Station> S save(S station);
    Station save(Station station);

    //Station findByName(@NonNull String name);

    Page<Station> findAll(Pageable pageable);

    //void delete(Station entity);

    default Station getByIdOrThrow(UUID stationId) {
        return findById(stationId).orElseThrow(() -> new StationNotFoundException(stationId));
    }
}