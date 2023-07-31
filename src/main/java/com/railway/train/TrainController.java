package com.railway.train;

import com.railway.train.domain.TrainFacade;
import com.railway.train.domain.TrainId;
import com.railway.train.domain.dto.CreateTrainDto;
import com.railway.train.domain.dto.TrainQueryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
class TrainController {
    private final TrainFacade trainFacade;

    private TrainController(TrainFacade trainFacade) {
        this.trainFacade = trainFacade;
    }

    @GetMapping("/trains")
    Page<TrainQueryDto> getTrains(Pageable pageable) {
        return trainFacade.findAll(pageable);
    }

    @GetMapping("/train/{id}")
    TrainQueryDto getTrain(@PathVariable TrainId id) {
        return trainFacade.show(id);
    }

    @PostMapping("/train/add")
    CreateTrainDto createTrain(@RequestBody CreateTrainDto createTrainDto) {
        return trainFacade.addTrain(createTrainDto);
    }
}
