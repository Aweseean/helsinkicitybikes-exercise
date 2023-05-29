package io.aweseean.assignments.helsinkicitybikes.util;

import io.aweseean.assignments.helsinkicitybikes.service.CSVService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final CSVService csvService;

    public AppStartupEvent(CSVService csvService) {
        this.csvService = csvService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        // Fetches all the datasets at startup

        String stationURL = "https://opendata.arcgis.com/datasets/726277c507ef4914b0aec3cbcfcbfafc_0.csv";
        String journeyURL1 = "https://dev.hsl.fi/citybikes/od-trips-2021/2021-07.csv";
        String journeyURL2 = "https://dev.hsl.fi/citybikes/od-trips-2021/2021-06.csv";
        String journeyURL3 = "https://dev.hsl.fi/citybikes/od-trips-2021/2021-05.csv";

        // Journeys from newest to oldest to database

        csvService.saveStations(stationURL);
        csvService.saveJourneys(journeyURL1);
        //csvService.saveJourneys(journeyURL2);
        //csvService.saveJourneys(journeyURL3);


        /*test stations
        Station hanasaari = stationRepository.save(new Station("Hanasaari",1,"501",
                "Hanasaari", "Hanaholmen",
                 "Hanasaarenranta 1",
                "Hanaholmsstranden 1", "Espoo",
                "Esbo", "CityBike Finland",
                10, 24.840319,60.16582));
        Station keilalahti = stationRepository.save(new Station("Keilalahti",2,"503",
                 "Keilalahti",
                "Kägelviken",
                "Keilalahdentie 2", "Kägelviksvägen 2",
                "Espoo", "Esbo", "CityBike Finland",
                28, 24.827467, 60.171524));

        //test journeys
        journeyRepository.save(new Journey("2021-05-31T23:57:25",
                "2021-06-01T00:05:46", "501",
                hanasaari, "503",
                keilalahti, 2043, 500));
        journeyRepository.save(new Journey("2021-05-31T23:52:10",
                "2021-06-01T00:05:20", "503",
                keilalahti, "501",
                hanasaari, 2023, 100));

        journeyRepository.findAll().forEach(System.out::println);
        stationRepository.findAll().forEach(System.out::println);

        System.out.println(journeyRepository.findByDepartureStationId("501"));
         */
    }
}
