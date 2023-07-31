package com.railway.station.domain.dto;

import com.railway.station.domain.common.StationAddress;
import com.railway.station.domain.common.StationId;
import com.railway.station.domain.common.StationName;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
/*@Entity
@Table(name = "station")*/
public class StationQueryDto {

    private final StationId stationId;
    private final StationName stationName;
    private final StationAddress stationAddress;

    public StationQueryDto(StationId stationId, StationName stationName, StationAddress stationAddress) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.stationAddress = stationAddress;
    }
}
