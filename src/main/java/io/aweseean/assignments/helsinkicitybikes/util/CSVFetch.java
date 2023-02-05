package io.aweseean.assignments.helsinkicitybikes.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.aweseean.assignments.helsinkicitybikes.data.model.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

@Component
public class CSVFetch {

    public static String TYPE = "text/csv";
    public static String TYPE2 = "application/octet-stream";

    public static boolean hasCSVFormat(URLConnection urlConnection) {

        if (TYPE.equals(urlConnection.getContentType()) ^ TYPE2.equals(urlConnection.getContentType())) {
            System.out.println("CSV URL: " + urlConnection.getURL());
            System.out.println("Content type:" + urlConnection.getContentType());
            return true;
        }

        return false;
    }

    public List<Station> csvToStations(String url) {

        // Might be an issue, if CSV is empty
        InputStream is = null;

        try {
            URL csvURL = new URL(url);
            URLConnection urlConnection = csvURL.openConnection();
            is = urlConnection.getInputStream();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            // CSVFormat.with methods deprecated, but work for now
            List<Station> stations = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            Iterator<CSVRecord> it = csvRecords.iterator();

            while (it.hasNext()) {
                CSVRecord csvRecord = it.next();
                 Station station = new Station(
                        csvRecord.get("Name"),
                        Integer.parseInt(csvRecord.get("\uFEFFFID")), // empty character at start of the file
                        csvRecord.get("ID"),
                        csvRecord.get("Nimi"),
                        csvRecord.get("Namn"),
                        csvRecord.get("Osoite"),
                        csvRecord.get("Adress"),
                        csvRecord.get("Kaupunki"),
                        csvRecord.get("Stad"),
                        csvRecord.get("Operaattor"),
                        Integer.parseInt(csvRecord.get("Kapasiteet")),
                        Double.parseDouble(csvRecord.get("x")),
                        Double.parseDouble(csvRecord.get("y"))
                );
                stations.add(station);
            }
            return stations;
        } catch (IOException e) {
            throw new RuntimeException("failed to parse CSV input: " + e.getMessage());
        }
    }

    public List<Journey> csvToJourneys(URLConnection urlConnection) {

        // Might be an issue, if CSV is empty
        InputStream is = null;

        try {
            is = urlConnection.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            // CSVFormat.with methods deprecated, but work for now
            List<Journey> journeys = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            Iterator<CSVRecord> it = csvRecords.iterator();

            while (it.hasNext()) {
                CSVRecord csvRecord = it.next();
                if (csvRecord.get("Covered distance (m)").isEmpty()) {
                    System.out.println("NO METERS " + csvRecord);
                } else if (Double.parseDouble(csvRecord.get("Covered distance (m)")) % 1.0 > 0) {
                    System.out.println("METERBUG " + csvRecord); //print every record with bugged meters
                } else if (Integer.parseInt(csvRecord.get("Covered distance (m)")) < 10 ||
                        Integer.parseInt(csvRecord.get("Duration (sec.)")) < 10) {
                } else {
                    Journey journey = new Journey(
                            csvRecord.get("\uFEFFDeparture"),
                            csvRecord.get("Return"),
                            csvRecord.get("Departure station id"),
                            csvRecord.get("Departure station name"),
                            csvRecord.get("Return station id"),
                            csvRecord.get("Return station name"),
                            Integer.parseInt(csvRecord.get("Covered distance (m)")),
                            Integer.parseInt(csvRecord.get("Duration (sec.)"))
                    );
                    journeys.add(journey);
                }

            }
            return journeys;
        } catch (IOException e) {
            throw new RuntimeException("failed to parse CSV input: " + e.getMessage());
        }
    }
}
