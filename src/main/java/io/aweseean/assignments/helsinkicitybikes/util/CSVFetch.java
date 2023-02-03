package io.aweseean.assignments.helsinkicitybikes.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public static boolean hasCSVFormat(URLConnection urlConnection) {

        if (!TYPE.equals(urlConnection.getContentType())) {
            return false;
        }

        return true;
    }

    public List<Station> csvToStations(String url) {
        InputStream is = null;
        {
            try {
                URL csvURL = new URL(url);
                URLConnection urlConnection = csvURL.openConnection();
                hasCSVFormat(urlConnection);
                is = urlConnection.getInputStream();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Station> stations = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            /*for (CSVRecord csvRecord : csvRecords) {
                System.out.println(csvRecord);
            }*/

            Iterator<CSVRecord> it = csvRecords.iterator();

            while (it.hasNext()) {
                CSVRecord csvRecord = it.next();
                 Station station = new Station(
                        csvRecord.get("Name"),
                        Integer.parseInt(csvRecord.get("\uFEFFFID")), // ??? empty character at start of the file
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

            /*for (CSVRecord csvRecord : csvRecords) {
                Station station = new Station(
                        csvRecord.get("Name"),
                        Integer.parseInt(csvRecord.get("\uFEFFFID")), // ??? empty character at start of the file
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


            }*/
            return stations;
        } catch (IOException e) {
            throw new RuntimeException("failed to parse CSV input: " + e.getMessage());
        }
    }

    public List<Journey> csvToJourneys(String url) {
        InputStream is = null;
        {
            try {
                URL csvURL = new URL(url);
                URLConnection urlConnection = csvURL.openConnection();
                hasCSVFormat(urlConnection);
                is = urlConnection.getInputStream();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Journey> journeys = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            /*for (CSVRecord csvRecord : csvRecords) {
                System.out.println(csvRecord);
            }*/

            Iterator<CSVRecord> it = csvRecords.iterator();

            while (it.hasNext()) {
                CSVRecord csvRecord = it.next();
                if (Double.parseDouble(csvRecord.get("Covered distance (m)")) % 1.0 > 0 /*== 10566.67*/){
                    System.out.println("METRIBUGI " + csvRecord);
                /*} else if (Double.parseDouble(csvRecord.get("Covered distance (m)")) == 3358.33) {
                    System.out.println("METRIBUGI 2 " + csvRecord);
                } else if (Double.parseDouble(csvRecord.get("Covered distance (m)")) == 1883.33) {
                    System.out.println("METRIBUGI 3 " + csvRecord);
                } else if (Double.parseDouble(csvRecord.get("Covered distance (m)")) == 3741.67) {
                    System.out.println("METRIBUGI 4 " + csvRecord);*/
                } else if (Integer.parseInt(csvRecord.get("Covered distance (m)")) < 10 ||
                        Integer.parseInt(csvRecord.get("Duration (sec.)")) < 10) {
                    System.out.println("SKIPPAA NÄMÄ " + csvRecord);
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
