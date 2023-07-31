package com.railway.station.domain;

import org.springframework.data.domain.*;
import org.springframework.data.repository.query.FluentQuery;

import java.util.*;
import java.util.function.Function;

import static java.util.Objects.requireNonNull;

class InMemoryStationRepository implements StationRepository {

    private final HashMap<UUID, Station> map = new HashMap<>();

    @Override
    public Station save(Station station) {
        requireNonNull(station);
        map.put(station.createStationDto().getStationId().getUuid(), station);
        return station;
    }

    @Override
    public Page<Station> findAll(Pageable pageable) {
        return new PageImpl<>(new ArrayList<>(map.values()), pageable, map.size());
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Station> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Station> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Station> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<UUID> uuids) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Station getOne(UUID uuid) {
        return null;
    }

    @Override
    public Station getById(UUID uuid) {
        return null;
    }

    @Override
    public Station getReferenceById(UUID uuid) {
        return null;
    }

    @Override
    public <S extends Station> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Station> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Station> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Station> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Station> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Station> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Station, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Station> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Station> findById(UUID uuid) {
        return Optional.ofNullable(map.get(uuid));
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public List<Station> findAll() {
        return null;
    }

    @Override
    public List<Station> findAllById(Iterable<UUID> uuids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(Station entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    @Override
    public void deleteAll(Iterable<? extends Station> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Station> findAll(Sort sort) {
        return null;
    }
}