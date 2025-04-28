package com.example.hospitalmanagement.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentModel {
	
		private Long appointmentId;
	    private Long patientId;
	    private Long doctorId;
	    private LocalDateTime appointmentDate;
	    private String appointmentType;
	    private String symptoms;
	    private String review;
	    private String status;
}
