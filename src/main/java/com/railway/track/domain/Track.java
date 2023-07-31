package com.railway.track.domain;

import com.railway.station.domain.common.StationId;
import com.railway.track.domain.dto.CreateTrackDto;
import com.railway.track.domain.dto.TrackQueryDto;
import com.railway.train.domain.TrainId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
class Track {

    @Id
    @Column(name = "trackId")
    private final UUID trackId;

    @Column(name = "trainId")
    private final UUID trainId;

    @Column(name = "sourceStationId")
    private final UUID sourceStationId;

    @Column(name = "destinationStationId")
    private final UUID destinationStationId;

    @Column(name = "timeIn")
    private final LocalDateTime timeIn;

    @Column(name = "timeOut")
    private final LocalDateTime timeOut;

    public Track(UUID trackId, UUID trainId, UUID sourceStationId, UUID destinationStationId, LocalDateTime timeIn, LocalDateTime timeOut) {
        this.trackId = trackId;
        this.trainId = trainId;
        this.sourceStationId = sourceStationId;
        this.destinationStationId = destinationStationId;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        /*this.timeIn = LocalTime.parse(timeIn.format(ofPattern("HH:mm")));
        this.timeOut = LocalTime.parse(timeOut.format(ofPattern("HH:mm")));*/
    }

    final CreateTrackDto createTrackDto() {
        return CreateTrackDto.builder()
                .trainId(trainId)
                .sourceStationId(sourceStationId)
                .destinationStationId(destinationStationId)
                .timeIn(timeIn)
                .timeOut(timeOut)
                .build();
    }

    final TrackQueryDto trackQueryDto() {
        return TrackQueryDto.builder()
                .sourceStationId(sourceStationId)
                .destinationStationId(destinationStationId)
                .timeIn(timeIn)
                .timeOut(timeOut)
                .build();
    }
}
