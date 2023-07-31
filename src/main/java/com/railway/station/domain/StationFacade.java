package com.railway.station.domain;

import com.railway.station.domain.dto.CreateStationDto;
import com.railway.station.domain.dto.StationQueryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface StationFacade {

    CreateStationDto addStation(CreateStationDto createStationDto);

    StationQueryDto getStation(UUID stationId);

    Page<StationQueryDto> findAll(Pageable pageable);
}
