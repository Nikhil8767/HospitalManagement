package com.example.HospitalManagement.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Medication {

    @Id
    private Integer code;

    private String name;
    private String brand;
    private String description;
}
