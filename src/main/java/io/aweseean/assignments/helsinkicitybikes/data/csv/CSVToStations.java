package io.aweseean.assignments.helsinkicitybikes.data.csv;

import io.aweseean.assignments.helsinkicitybikes.data.model.Station;
import io.aweseean.assignments.helsinkicitybikes.util.CSVFetch;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVToStations {
/*
    static String[] HEADERS = { "ID", "Nimi", "Namn", "Name",
            "Osoite", "Adress", "Kaupunki", "Stad", "Operaattor",
            "Kapasiteet", "x", "y" };

    public static List<Station> csvToStations(InputStream is) {
        CSVFetch.hasCSVFormat();
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Station> stations = new ArrayList<Station>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Station station = new Station(
                        Integer.parseInt(csvRecord.get("FID")),
                        csvRecord.get("ID"),
                        csvRecord.get("Nimi"),
                        csvRecord.get("Namn"),
                        csvRecord.get("Name"),
                        csvRecord.get("Osoite"),
                        csvRecord.get("Adress"),
                        csvRecord.get("Kaupunki"),
                        csvRecord.get("Stad"),
                        csvRecord.get("Operaattor"),
                        Integer.parseInt(csvRecord.get("Kapasiteet")),
                        Double.parseDouble(csvRecord.get("x")),
                        Double.parseDouble(csvRecord.get("y")),
                        );

                stations.add(station);
            }

            return stations;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }*/
}
