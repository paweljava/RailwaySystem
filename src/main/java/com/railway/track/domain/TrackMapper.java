package com.railway.track.domain;

import com.railway.track.domain.dto.TrackQueryDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

class TrackMapper {

    static List<TrackQueryDto> mapper(List<Track> track) {
        return track.stream().map(
                        city -> new TrackQueryDto(
                                city.getSourceStationId(),
                                city.getDestinationStationId(),
                                city.getTimeIn(),
                                city.getTimeOut()))
                .collect(toList());
    }
}
