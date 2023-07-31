package com.railway.station.infrastructure;

import com.railway.station.domain.StationFacade;
import com.railway.station.domain.dto.CreateStationDto;
import com.railway.station.domain.dto.StationQueryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
class StationController {

    private final StationFacade stationFacade;

    private StationController(StationFacade stationFacade) {
        this.stationFacade = stationFacade;
    }

    @GetMapping("/stations")
    Page<StationQueryDto> getStations(Pageable pageable) {
        return stationFacade.findAll(pageable);
    }

    @GetMapping("/station/{id}")
    StationQueryDto getStation(@PathVariable UUID stationId) {
        return stationFacade.getStation(stationId);
    }

    @PostMapping("/station/add")
    CreateStationDto createStation(@RequestBody CreateStationDto createStationDto) {
        return stationFacade.addStation(createStationDto);
    }
}
