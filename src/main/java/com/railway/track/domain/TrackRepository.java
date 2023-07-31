package com.railway.track.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TrackRepository extends JpaRepository<Track, String> {

    Track save(Track track);

    //<S extends Track> S insert(S entity);

    //<S extends Track> List<S> insert(Iterable<S> entities);

    //List<Track> findBySourceStationId(String id);

    //List<Track> findBySourceStationId(StationId id);
}
