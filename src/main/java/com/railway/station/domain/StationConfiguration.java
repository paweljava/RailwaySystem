package com.railway.station.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
class StationConfiguration {
    StationFacadePrivate stationFacade() {
        return stationFacade(new InMemoryStationRepository());
    }

    private final StationRepository stationRepository;

    StationConfiguration(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Bean
    StationFacadePrivate stationFacade(StationRepository stationRepository) {
        final var stationCreator = new StationCreator();
        return new StationFacadePrivate(stationRepository, stationCreator);
    }

    @Bean
    StationFacade stationService() {
        final var stationCreator = new StationCreator();
        return new StationFacadePrivate(stationRepository, stationCreator);
    }
}
