package com.railway.track.domain;

import com.railway.station.domain.common.StationId;
import com.railway.track.domain.dto.CreateTrackDto;
import com.railway.track.domain.dto.TrackQueryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.railway.track.domain.TrackMapper.mapper;
import static java.util.Objects.requireNonNull;

public class TrackFacade {

    private final TrackRepository trackRepository;
    private final TrackCreator trackCreator;

    TrackFacade(TrackRepository trackRepository, TrackCreator trackCreator) {
        this.trackRepository = trackRepository;
        this.trackCreator = trackCreator;
    }

    public CreateTrackDto addTrack(CreateTrackDto createTrackDto) {
        requireNonNull(createTrackDto);
        final var track = trackCreator.createTrack(createTrackDto);
        trackRepository.save(track);
        return track.createTrackDto();
    }

    public Page<TrackQueryDto> findAll(Pageable pageable) {
        requireNonNull(pageable);
        return trackRepository
                .findAll(pageable)
                .map(Track::trackQueryDto);
    }

    public List<TrackQueryDto> findTracks(StationId sourceStationId, StationId destinationStationId) {
        requireNonNull(sourceStationId);
        requireNonNull(destinationStationId);
        return mapper(trackRepository.findAll().stream()
                .filter(s -> s.getSourceStationId().equals(sourceStationId))
                .filter(d -> d.getDestinationStationId().equals(destinationStationId))
                .toList());
    }

    public void delete(String trackId) {
        requireNonNull(trackId);
        trackRepository.deleteById(trackId);
    }

}
