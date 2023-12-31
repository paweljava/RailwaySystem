package com.railway.track.domain.dto;

import com.railway.station.domain.common.StationId;
import com.railway.train.domain.TrainId;
import lombok.Builder;
import lombok.Getter;

import java.time.*;
import java.util.UUID;

@Getter
@Builder
public class CreateTrackDto {

    private final UUID trainId;
    private final UUID sourceStationId;
    private final UUID destinationStationId;
    private final LocalDateTime timeIn;
    private final LocalDateTime timeOut;

    public CreateTrackDto(UUID trainId, UUID sourceStationId, UUID destinationStationId, LocalDateTime timeIn, LocalDateTime timeOut) {
        this.trainId = trainId;
        this.sourceStationId = sourceStationId;
        this.destinationStationId = destinationStationId;
        this.timeIn = LocalDateTime.of(LocalDate.now(), LocalTime.parse(timeIn.toString()));
        this.timeOut = LocalDateTime.of(LocalDate.now(), LocalTime.parse(timeOut.toString()));



        /*this.timeIn = timeIn;
        this.timeOut = timeOut;*/

        /*this.timeIn = LocalTime.parse(timeIn.toString() + "+02:00", DateTimeFormatter.ISO_OFFSET_TIME);
        this.timeOut = LocalTime.parse(timeOut.toString() + "+02:00", DateTimeFormatter.ISO_OFFSET_TIME);*/

        /*this.timeIn = LocalTime.parse(timeIn.format(DateTimeFormatter.ofPattern("HH:mm:00")));
        this.timeOut = LocalTime.parse(timeOut.format(DateTimeFormatter.ofPattern("HH:mm:00")));*/

        /*this.timeIn = LocalTime.parse(timeIn.format(DateTimeFormatter.ofPattern("HH:mm")))
                .atOffset(ZoneOffset.ofHours(4)).toLocalTime();
        this.timeOut = LocalTime.parse(timeOut.format(DateTimeFormatter.ofPattern("HH:mm")))
                .atOffset(ZoneOffset.ofHours(4)).toLocalTime();*/

        /*this.timeIn = LocalTime.parse(timeIn.plus(2, ChronoUnit.HOURS)
                .format(DateTimeFormatter.ofPattern("HH:mm")))
                .atOffset(ZoneOffset.UTC).toLocalTime();
        this.timeOut = LocalTime.parse(timeOut.plus(2, ChronoUnit.HOURS)
                .format(DateTimeFormatter.ofPattern("HH:mm")))
                .atOffset(ZoneOffset.UTC).toLocalTime();*/
    }
}

