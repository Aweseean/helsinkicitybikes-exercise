package io.aweseean.assignments.helsinkicitybikes.service;

import io.aweseean.assignments.helsinkicitybikes.data.model.Station;
import io.aweseean.assignments.helsinkicitybikes.data.repository.StationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class StationService {

    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public Page<Station> getAllStationsForView(Pageable pageable) {
        Page<Station> stationsPageable = this.stationRepository.findAll(pageable);
        return stationsPageable;
    }
    //public String getStationByStationId
}
