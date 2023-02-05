package io.aweseean.assignments.helsinkicitybikes.util;

import io.aweseean.assignments.helsinkicitybikes.data.repository.JourneyRepository;
import io.aweseean.assignments.helsinkicitybikes.data.repository.StationRepository;
import io.aweseean.assignments.helsinkicitybikes.service.CSVService;
import io.aweseean.assignments.helsinkicitybikes.service.JourneyService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final JourneyRepository journeyRepository;
    private final StationRepository stationRepository;
    private final JourneyService journeyService;
    private final CSVService csvService;



    public AppStartupEvent(JourneyRepository journeyRepository, StationRepository stationRepository, JourneyService journeyService, CSVService csvService) {
        this.journeyRepository = journeyRepository;
        this.stationRepository = stationRepository;
        this.journeyService = journeyService;
        this.csvService = csvService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        String url = "https://opendata.arcgis.com/datasets/726277c507ef4914b0aec3cbcfcbfafc_0.csv";
        String url2 = "https://dev.hsl.fi/citybikes/od-trips-2021/2021-05.csv";

        csvService.saveStations(url);
        csvService.saveJourneys(url2);

        //journeyService.getAllJourneysPageable();

        /*<Journey> journeys = journeyRepository.findAll(PageRequest.of(0, 10));
        System.out.println("\nTotal number of journeys=" + journeys.getTotalElements());
        System.out.println("Total number of 10-element-pages=" + journeys.getTotalPages());
        journeys.forEach(System.out::println);

        /*journeyRepository.findByDepartureStationId("004").forEach(System.out::println);
        stationRepository.findAll().forEach(System.out::println);

        /*String url = "https://opendata.arcgis.com/datasets/726277c507ef4914b0aec3cbcfcbfafc_0.csv";
        csvService.save(url);
        csvService.getAllStations().forEach(System.out::println);*/

        /*List<Station> stations = csvFetch.csvToStations(is);
        stationRepository.saveAll(stations);
        stationRepository.findAll().forEach(System.out::println);

        //test stations
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
