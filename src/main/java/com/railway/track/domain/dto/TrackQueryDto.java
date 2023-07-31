package com.railway.track.domain.dto;

import com.railway.station.domain.common.StationId;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class TrackQueryDto {
    private final StationId sourceStationId;
    private final StationId destinationStationId;
    private final LocalDateTime timeIn;
    private final LocalDateTime timeOut;

    public TrackQueryDto(StationId sourceStationId, StationId destinationStationId, LocalDateTime timeIn, LocalDateTime timeOut) {
        this.sourceStationId = sourceStationId;
        this.destinationStationId = destinationStationId;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

}
