package io.aweseean.assignments.helsinkicitybikes.web;

import io.aweseean.assignments.helsinkicitybikes.data.model.Station;
import io.aweseean.assignments.helsinkicitybikes.data.repository.StationRepository;
import io.aweseean.assignments.helsinkicitybikes.service.StationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/stations")
public class StationController {

    private final StationRepository stationRepository;
    private final StationService stationService;

    public StationController(StationRepository stationRepository, StationService stationService) {
        this.stationRepository = stationRepository;
        this.stationService = stationService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return getAllStationsPageable(1, model);
    }

    @GetMapping("/{page}")
    public String getAllStationsPageable(@PathVariable(value = "page") int page, Model model){
        Page<Station> stations = this.stationService.getAllStationsForView(PageRequest.of(page - 1, 15, Sort.by("fid")));
        Page<Station> stationsPageable = this.stationRepository.findAll(PageRequest.of(page - 1, 15));
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", stationsPageable.getTotalPages());
        model.addAttribute("totalItems", stationsPageable.getTotalElements());
        model.addAttribute("stations", stations);
        model.addAttribute("module", "stations");
        return "stations";
    }

    @GetMapping("/station/{stationId}")
    public String getStationByStationId(@PathVariable(value = "stationId") String stationId, Model model) {
        Optional<Station> station = this.stationRepository.findByStationId(stationId);
        if (station.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        model.addAttribute("station", station.get());

        int departures = this.stationService.getDeparturesByStation(stationId);
        int returns = this.stationService.getReturnsByStation(stationId);

        System.out.println("departures "+departures);
        System.out.println("returns "+returns);

        model.addAttribute("departures", departures);
        model.addAttribute("returns", returns);
        model.addAttribute("module", "stations");
        return "station";
    }
}
