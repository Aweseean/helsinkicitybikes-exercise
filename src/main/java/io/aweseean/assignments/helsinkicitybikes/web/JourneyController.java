package io.aweseean.assignments.helsinkicitybikes.web;

import io.aweseean.assignments.helsinkicitybikes.data.model.Journey;
import io.aweseean.assignments.helsinkicitybikes.data.repository.JourneyRepository;
import io.aweseean.assignments.helsinkicitybikes.service.JourneyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/journeys")
public class JourneyController {

    private final JourneyRepository journeyRepository;
    private final JourneyService journeyService;

    public JourneyController(JourneyRepository journeyRepository, JourneyService journeyService) {
        this.journeyRepository = journeyRepository;
        this.journeyService = journeyService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return getAllJourneysPageable(1, model);
    }

    @GetMapping("/{page}")
    public String getAllJourneysPageable(@PathVariable(value = "page") int page, Model model){
        List<Journey> journeys = this.journeyService.getAllJourneysForView(PageRequest.of(page - 1, 15, Sort.by("id")));
        Page<Journey> journeysPageable = this.journeyRepository.findAll(PageRequest.of(page - 1, 15));
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", journeysPageable.getTotalPages());
        model.addAttribute("totalItems", journeysPageable.getTotalElements());
        model.addAttribute("journeys", journeys);
        model.addAttribute("module", "journeys");
        return "journeys";
    }
}
