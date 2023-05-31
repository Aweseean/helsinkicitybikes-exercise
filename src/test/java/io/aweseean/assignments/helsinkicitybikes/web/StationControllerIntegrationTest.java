package io.aweseean.assignments.helsinkicitybikes.web;

import io.aweseean.assignments.helsinkicitybikes.data.repository.StationRepository;
import io.aweseean.assignments.helsinkicitybikes.service.StationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StationController.class)
class StationControllerIntegrationTest { // not working, no idea why, autowiring is not recommended by some developers

    @Autowired
    private MockMvc mvc;
    @Autowired
    private StationRepository stationRepository;
    @Autowired
    private StationService stationService;


    @Test
    void getStationByStationId501() throws Exception {
        this.mvc.perform(get("/stations/station/501")).andExpect(status().isOk());
    }
    @Test
    void getStationByNonExistentStationId() throws Exception {
        this.mvc.perform(get("/stations/station/6000")).andExpect(status().isBadRequest());
    }
}