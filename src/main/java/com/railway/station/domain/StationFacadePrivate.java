package com.railway.station.domain;

import com.railway.station.domain.dto.CreateStationDto;
import com.railway.station.domain.dto.StationQueryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

class StationFacadePrivate implements StationFacade {
    private final StationRepository stationRepository;
    private final StationCreator stationCreator;

    StationFacadePrivate(StationRepository stationRepository, StationCreator stationCreator) {
        this.stationRepository = stationRepository;
        this.stationCreator = stationCreator;
    }
@Override
    public CreateStationDto addStation(CreateStationDto createStationDto) {
        requireNonNull(createStationDto);
        final var station = stationCreator.createStation(createStationDto);
        stationRepository.save(station);
        return station.createStationDto();
    }

    @Override
    public StationQueryDto getStation(UUID stationId) {
        requireNonNull(stationId);
        final var station = stationRepository.getByIdOrThrow(stationId);
        return station.stationQueryDto();
    }

    public Page<StationQueryDto> findAll(Pageable pageable) {
        requireNonNull(pageable);
        return stationRepository
                .findAll(pageable)
                .map(Station::stationQueryDto);
    }

    /*public void delete(UUID stationId) {
        requireNonNull(stationId);
        stationRepository.deleteById(stationId);
    }*/
}
