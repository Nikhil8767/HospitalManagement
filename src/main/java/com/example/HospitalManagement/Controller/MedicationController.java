package com.example.HospitalManagement.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HospitalManagement.Entity.Medication;
import com.example.HospitalManagement.Repository.MedicationRepository;

@RestController
@RequestMapping("/medications")
public class MedicationController {

    // @Autowired
    // private MedicationRepository medicationRepository;

    // @GetMapping("/{code}")
    // public Medication getMedication(@PathVariable Integer code) {
    //     return medicationRepository.findById(code)
    //             .orElseThrow(() -> new RuntimeException("Medication not found"));
    // } 
}
