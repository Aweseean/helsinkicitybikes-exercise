package io.aweseean.assignments.helsinkicitybikes.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import io.aweseean.assignments.helsinkicitybikes.data.model.Journey;
import io.aweseean.assignments.helsinkicitybikes.data.model.Station;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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

            List<Station> stations = new ArrayList<Station>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            /*for (CSVRecord csvRecord : csvRecords) {
                System.out.println(csvRecord);
            }*/

            for (CSVRecord csvRecord : csvRecords) {
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

            return stations;
        } catch (IOException e) {
            throw new RuntimeException("failed to parse CSV input: " + e.getMessage());
        }
    }
}
