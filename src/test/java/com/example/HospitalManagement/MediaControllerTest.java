package com.example.HospitalManagement;
import static org.mockito.Mockito.when;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.example.HospitalManagement.Entity.Medication;
import com.example.HospitalManagement.Repository.MedicationRepository;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MediaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MedicationRepository repository;

    @BeforeEach
    void setup() {
        //  prescribesRepository.deleteAll();
        //  repository.deleteAll(); // clean DB

        Medication med = new Medication();
        med.setCode(100); // use controlled value
        med.setName("TestMed");

        repository.save(med);
    }

    @Test
    void testGetMedication() throws Exception {
        mockMvc.perform(get("/medications/100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("TestMed"));
    }

    @Test
    void testMedicationNotFound() throws Exception {
        mockMvc.perform(get("/medications/999"))
                .andExpect(status().is5xxServerError());
    }
}
