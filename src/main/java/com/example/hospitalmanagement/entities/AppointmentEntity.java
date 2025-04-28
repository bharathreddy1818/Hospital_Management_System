package com.example.hospitalmanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@AllArgsConstructor
public class AppointmentEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    
    private Long patientId;
    
    private Long doctorId;
    
    private LocalDateTime appointmentDate;
    private String appointmentType;
    private String symptoms;
    private String review;
    private String status;
}
