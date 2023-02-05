package io.aweseean.assignments.helsinkicitybikes.web;

import io.aweseean.assignments.helsinkicitybikes.service.CSVService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/csv")
public class CSVController {

    private final CSVService csvService;

    public CSVController(CSVService csvService) {
        this.csvService = csvService;
    }

    // Never used, meant for using CSVService as an endpoint to store new journeys or stations from a view
}
