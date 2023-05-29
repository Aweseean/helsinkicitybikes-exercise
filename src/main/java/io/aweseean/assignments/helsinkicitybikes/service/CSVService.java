package io.aweseean.assignments.helsinkicitybikes.service;

import io.aweseean.assignments.helsinkicitybikes.data.model.Journey;
import io.aweseean.assignments.helsinkicitybikes.data.repository.JourneyRepository;
import io.aweseean.assignments.helsinkicitybikes.util.CSVFetch;
import io.aweseean.assignments.helsinkicitybikes.data.model.Station;
import io.aweseean.assignments.helsinkicitybikes.data.repository.StationRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Service
public class CSVService {

    private final JourneyRepository journeyRepository;
    private final StationRepository stationRepository;
    private final CSVFetch csvFetch;


    public CSVService(StationRepository stationRepository, CSVFetch csvFetch,
                      JourneyRepository journeyRepository) {
        this.stationRepository = stationRepository;
        this.csvFetch = csvFetch;
        this.journeyRepository = journeyRepository;
    }

    public void saveStations(String url) {

        // Might be an issue, if CSV is empty
        URLConnection urlConnection = null;

        try {
            URL csvURL = new URL(url);
            urlConnection = csvURL.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (CSVFetch.hasCSVFormat(urlConnection)) {
            List<Station> stations = csvFetch.csvToStations(url);
            stationRepository.saveAll(stations);
            System.out.println("Stations added!");
        }
    }

    public void saveJourneys(String url) {

        // Might be an issue, if CSV is empty
        URLConnection urlConnection = null;

        try {
            URL csvURL = new URL(url);
            urlConnection = csvURL.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (CSVFetch.hasCSVFormat(urlConnection)) {
            List<Journey> journeys = csvFetch.csvToJourneys(urlConnection);
            journeyRepository.saveAll(journeys);
            System.out.println("Journeys added!");
        }
    }

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public List<Journey> getAllJourneys() {
        return journeyRepository.findAll();
    }
}
