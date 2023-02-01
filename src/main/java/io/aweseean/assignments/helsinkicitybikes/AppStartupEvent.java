package io.aweseean.assignments.helsinkicitybikes;

import io.aweseean.assignments.helsinkicitybikes.data.model.Journey;
import io.aweseean.assignments.helsinkicitybikes.data.repository.JourneyRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final JourneyRepository journeyRepository;

    public AppStartupEvent(JourneyRepository journeyRepository) {
        this.journeyRepository = journeyRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        journeyRepository.findAll().forEach(System.out::println);
    }
}
