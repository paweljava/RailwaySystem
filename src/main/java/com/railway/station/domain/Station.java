package com.railway.station.domain;

import com.railway.station.domain.common.StationAddress;
import com.railway.station.domain.common.StationId;
import com.railway.station.domain.common.StationName;
import com.railway.station.domain.dto.CreateStationDto;
import com.railway.station.domain.dto.StationQueryDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

//@Builder
@ToString
@Entity
@EqualsAndHashCode(of = "stationId")
@Table(name = "station")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Station {

    @Id
    @Column(name = "stationId", insertable = false, updatable = false, nullable = false)
    private StationId stationId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "stationName", insertable = false, updatable = false, nullable = false))
    })    private StationName stationName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "stationAddress", insertable = false, updatable = false, nullable = false))
    })
    private StationAddress stationAddress;

    final CreateStationDto createStationDto() {
        return CreateStationDto.builder()
                .stationId(StationId.of(UUID.randomUUID()))
                .stationName(stationName)
                .stationAddress(stationAddress)
                .build();
    }

    final StationQueryDto stationQueryDto() {
        return StationQueryDto.builder()
                .stationName(stationName)
                .stationAddress(stationAddress)
                .build();
    }
}