package com.shield.eaarogya.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionDetails {

    private int prescriptionId;

    @Temporal(TemporalType.DATE)
    private Date consultationDate;

    private String observation;

    private Set<String> medicine;

    private String remark;

    private String doctorName;

    private long doctorId;

    private String patientName;

    private long patientId;

    @Temporal(TemporalType.DATE)
    private Date followUpDate;
}
