package com.railway.track.domain;

import com.railway.track.domain.dto.CreateTrackDto;
import com.railway.track.domain.dto.TrackQueryDto;

public class MapperCreateToQuery {

    public static TrackQueryDto mapp(CreateTrackDto createTrackDto) {
        return new TrackQueryDto(createTrackDto.getSourceStationId(),
                createTrackDto.getDestinationStationId(),
                createTrackDto.getTimeIn(),
                createTrackDto.getTimeOut());
    }
}
