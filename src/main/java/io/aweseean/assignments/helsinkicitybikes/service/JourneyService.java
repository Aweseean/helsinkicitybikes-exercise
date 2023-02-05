package io.aweseean.assignments.helsinkicitybikes.service;

import io.aweseean.assignments.helsinkicitybikes.data.model.Journey;
import io.aweseean.assignments.helsinkicitybikes.data.repository.JourneyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class JourneyService {

    private final JourneyRepository journeyRepository;

    public JourneyService(JourneyRepository journeyRepository) {
        this.journeyRepository = journeyRepository;
    }

    public List<Journey> getAllJourneysForView(Pageable pageable) {
        Page<Journey> journeysPageable = this.journeyRepository.findAll(pageable);
        List<Journey> journeysInBatch = journeysPageable.getContent();
        DecimalFormat df = new DecimalFormat("0.0");
        journeysInBatch.forEach(journey -> {
            double km = journey.getDistanceMeters() * 0.001;
            String kmForm = df.format(km);
            // rounds seconds to minutes up and down
            int min = (int)Math.round((double) journey.getDurationSeconds() / 60);
            journey.setDistanceKilometers(kmForm);
            journey.setDurationSeconds(min);
        });

        return journeysInBatch;
    }
}
