package com.railway.track;

import com.railway.station.domain.common.StationId;
import com.railway.track.domain.MapperCreateToQuery;
import com.railway.track.domain.TrackFacade;
import com.railway.track.domain.dto.CreateTrackDto;
import com.railway.track.domain.dto.TrackQueryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
class TrackController {

    private final TrackFacade trackFacade;

    private TrackController(TrackFacade trackFacade) {
        this.trackFacade = trackFacade;
    }

    @GetMapping("/tracks")
    Page<TrackQueryDto> getTracks(Pageable pageable) {
        return trackFacade.findAll(pageable);
    }

    @GetMapping("/track")
    List<TrackQueryDto> getTracks(@RequestParam ("sourceStationId") StationId sourceStationId, @RequestParam ("destinationStationId") StationId destinationStationId) {
        return trackFacade.findTracks(sourceStationId, destinationStationId);
    }

    @PostMapping("/track/add")
    TrackQueryDto createTrack(@RequestBody CreateTrackDto createTrackDto) {
        return MapperCreateToQuery.mapp(trackFacade.addTrack(createTrackDto));
    }

}
