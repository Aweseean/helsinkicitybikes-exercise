package io.aweseean.assignments.helsinkicitybikes.data.repository;

import io.aweseean.assignments.helsinkicitybikes.data.model.Station;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface StationRepository extends JpaRepository<Station, Long> {

    Page<Station> findAll(Pageable pageable);

    Optional<Station> findByStationId(String stationId);
}