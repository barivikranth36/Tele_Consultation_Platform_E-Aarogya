package com.shield.eaarogya.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDetails {

    private long appointmentId;
//    private String patientName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date appointmentTimestamp;
    private long patientId;
    private String departmentName;
//    private boolean approval;

    // ---------------------------------------- Constructor --------------------------------------------


    public AppointmentDetails(long appointmentId, Date appointmentTimestamp, long patientId, String departmentName) {
        this.appointmentId = appointmentId;
        this.appointmentTimestamp = appointmentTimestamp;
        this.patientId = patientId;
        this.departmentName = departmentName;
    }

    public AppointmentDetails(Date appointmentTimestamp, long patientId, String departmentName) {
        this.appointmentTimestamp = appointmentTimestamp;
        this.patientId = patientId;
        this.departmentName = departmentName;
    }
}
