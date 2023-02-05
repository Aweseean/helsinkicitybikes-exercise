package io.aweseean.assignments.helsinkicitybikes.web;

import io.aweseean.assignments.helsinkicitybikes.data.model.Journey;
import io.aweseean.assignments.helsinkicitybikes.data.model.Station;
import io.aweseean.assignments.helsinkicitybikes.data.repository.JourneyRepository;
import io.aweseean.assignments.helsinkicitybikes.data.repository.StationRepository;
import io.aweseean.assignments.helsinkicitybikes.service.StationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    private final JourneyRepository journeyRepository;
    private final StationRepository stationRepository;
    private final StationService stationService;

    public StationController(JourneyRepository journeyRepository, StationRepository stationRepository, StationService stationService) {
        this.journeyRepository = journeyRepository;
        this.stationRepository = stationRepository;
        this.stationService = stationService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return getAllStationsPageable(1, model);
    }

    @GetMapping("/{page}")
    public String getAllStationsPageable(@PathVariable(value = "page") int page, Model model){
        Page<Station> stationsPageable = this.stationService.getAllStationsForView(PageRequest.of(page - 1, 15));
        List<Station> stations = stationsPageable.getContent();
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

        //Optional<Journey> departures = this.journeyRepository.findByDepartureStationId(stationId);
        model.addAttribute("module", "stations");
        return "station";
    }
}
