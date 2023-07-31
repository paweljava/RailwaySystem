package com.railway.station.domain.dto;

import com.railway.station.domain.common.StationAddress;
import com.railway.station.domain.common.StationId;
import com.railway.station.domain.common.StationName;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateStationDto {

    private final StationId stationId;
    private final StationName stationName;
    private final StationAddress stationAddress;
}
