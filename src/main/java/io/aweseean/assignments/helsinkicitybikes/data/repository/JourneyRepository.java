package io.aweseean.assignments.helsinkicitybikes.data.repository;

import io.aweseean.assignments.helsinkicitybikes.data.model.Journey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JourneyRepository extends JpaRepository<Journey, Long> {
    List<Journey> findByDepartureStationId(String departureStationId);
}