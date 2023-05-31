package io.aweseean.assignments.helsinkicitybikes.service;

import io.aweseean.assignments.helsinkicitybikes.data.repository.JourneyRepository;
import io.aweseean.assignments.helsinkicitybikes.data.repository.StationRepository;
import io.aweseean.assignments.helsinkicitybikes.util.CSVFetch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CSVServiceTest {

    private final JourneyRepository journeyRepository;
    private final StationRepository stationRepository;
    private final CSVFetch csvFetch;


    public CSVServiceTest(StationRepository stationRepository, CSVFetch csvFetch,
                      JourneyRepository journeyRepository) {
        this.stationRepository = stationRepository;
        this.csvFetch = csvFetch;
        this.journeyRepository = journeyRepository;
    }
    @Test
    void saveStations() {
    }

    @Test
    void saveJourneys() {
    }

    @Test
    void getAllStations() {
    }

    @Test
    void getAllJourneys() {
    }
}