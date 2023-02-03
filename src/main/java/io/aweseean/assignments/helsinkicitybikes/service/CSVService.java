package io.aweseean.assignments.helsinkicitybikes.service;

import io.aweseean.assignments.helsinkicitybikes.util.CSVFetch;
import io.aweseean.assignments.helsinkicitybikes.data.model.Station;
import io.aweseean.assignments.helsinkicitybikes.data.repository.StationRepository;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

@Service
public class CSVService {

    //private final JourneyRepository journeyRepository;
    private final StationRepository stationRepository;
    private final CSVFetch csvFetch;


    public CSVService(StationRepository stationRepository, CSVFetch csvFetch) {
        this.stationRepository = stationRepository;
        this.csvFetch = csvFetch;
    }

    public void save(String url) {
        List<Station> stations = csvFetch.csvToStations(url);
        stationRepository.saveAll(stations);
    }

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }
}
