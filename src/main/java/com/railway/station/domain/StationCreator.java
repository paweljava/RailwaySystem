package com.railway.station.domain;

import com.railway.station.domain.dto.CreateStationDto;

import static java.util.Objects.requireNonNull;

class StationCreator {
    Station createStation(CreateStationDto createStationDto) {
        requireNonNull(createStationDto);
        return new Station();

        /*return new Station.builder()
                .stationId(UUID.randomUUID())
                .stationName(createStationDto.getStationName())
                .stationAddress(createStationDto.getStationAddress())
                .build();*/
    }
}
