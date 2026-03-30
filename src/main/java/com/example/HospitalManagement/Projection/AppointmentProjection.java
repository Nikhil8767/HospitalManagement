package com.example.HospitalManagement.Projection;

import com.example.HospitalManagement.Entity.Appointment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "appointmentView", types = Appointment.class)
public interface AppointmentProjection {
    Date getStarto();
    Date getEndo();
    String getExaminationRoom();

    // ✅ physician name — correct field is "physician" not "pcp"
    @Value("#{target.physician.name}")
    String getPhysicianName();

    // ✅ patient name
    @Value("#{target.patient.name}")
    String getPatientName();
}