package io.aweseean.assignments.helsinkicitybikes.service;

import io.aweseean.assignments.helsinkicitybikes.data.model.Journey;
import io.aweseean.assignments.helsinkicitybikes.data.model.Station;
import io.aweseean.assignments.helsinkicitybikes.data.repository.JourneyRepository;
import io.aweseean.assignments.helsinkicitybikes.data.repository.StationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    private final StationRepository stationRepository;
    private final JourneyRepository journeyRepository;

    public StationService(StationRepository stationRepository, JourneyRepository journeyRepository) {
        this.stationRepository = stationRepository;
        this.journeyRepository = journeyRepository;
    }

    public Page<Station> getAllStationsForView(Pageable pageable) {
        Page<Station> stationsPageable = this.stationRepository.findAll(pageable);
        return stationsPageable;
    }
    public int getDeparturesByStation(String stationId) {
        List<Journey> departures = this.journeyRepository.findByDepartureStationId(stationId);
        return departures.size();
    }
    public int getReturnsByStation(String stationId) {
        List<Journey> departures = this.journeyRepository.findByReturnStationId(stationId);
        return departures.size();
    }

}
