package io.aweseean.assignments.helsinkicitybikes;

import io.aweseean.assignments.helsinkicitybikes.data.repository.JourneyRepository;
import io.aweseean.assignments.helsinkicitybikes.data.repository.StationRepository;
import io.aweseean.assignments.helsinkicitybikes.service.JourneyService;
import io.aweseean.assignments.helsinkicitybikes.service.StationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class HelsinkicitybikesApplicationTests {

	private final StationRepository stationRepository;
	private final JourneyRepository journeyRepository;
	private final StationService stationService;
	private final JourneyService journeyService;

	HelsinkicitybikesApplicationTests(StationRepository stationRepository,
									  JourneyRepository journeyRepository,
									  StationService stationService,
									  JourneyService journeyService) {
		this.stationRepository = stationRepository;
		this.journeyRepository = journeyRepository;
		this.stationService = stationService;
		this.journeyService = journeyService;
	}

	@Test
	public void contextLoads() {

	}

}
