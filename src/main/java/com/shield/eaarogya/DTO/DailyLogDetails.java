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
public class DailyLogDetails {

    private long doctorId;

    @Temporal(TemporalType.DATE)
    private Date currentDate;

    private long patientId;

    private String observation;

    private String remark;
}
