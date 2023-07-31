package com.railway.train.domain;

import org.springframework.data.domain.*;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static java.util.Objects.requireNonNull;

class InMemoryTrainRepository implements TrainRepository {

    private final HashMap<String, Train> map = new HashMap<>();

    @Override
    public Train save(Train train) {
        requireNonNull(train);
        map.put(train.trainCreateDto().getName(), train);
        return train;
    }

    @Override
    public Page<Train> findAll(Pageable pageable) {
        return new PageImpl<>(new ArrayList<>(map.values()), pageable, map.size());
    }

    @Override
    public Train findOneOrThrow(TrainId trainId) {
        return TrainRepository.super.findOneOrThrow(trainId);
    }

    @Override
    public <S extends Train> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public void flush() {
    }

    @Override
    public <S extends Train> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Train> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Train> entities) {
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<TrainId> trainIds) {

    }

    @Override
    public void deleteAllInBatch() {
    }

    @Override
    public Train getOne(TrainId trainId) {
        return null;
    }

    @Override
    public Train getById(TrainId trainId) {
        return null;
    }

    @Override
    public Train getReferenceById(TrainId trainId) {
        return null;
    }

    @Override
    public <S extends Train> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Train> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Train> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Train> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Train> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Train, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Train> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Train> findById(TrainId trainId) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(TrainId trainId) {
        return false;
    }

    @Override
    public List<Train> findAll() {
        return null;
    }

    @Override
    public List<Train> findAllById(Iterable<TrainId> trainIds) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(TrainId trainId) {
    }

    @Override
    public void delete(Train entity) {
    }

    @Override
    public void deleteAllById(Iterable<? extends TrainId> trainIds) {

    }

    @Override
    public void deleteAll(Iterable<? extends Train> entities) {
    }

    @Override
    public void deleteAll() {
    }

    @Override
    public List<Train> findAll(Sort sort) {
        return null;
    }
}