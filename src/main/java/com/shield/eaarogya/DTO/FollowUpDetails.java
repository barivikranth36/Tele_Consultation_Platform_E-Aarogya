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
public class FollowUpDetails {

    @Temporal(TemporalType.DATE)
    private Date followUpDate;

    private String departmentName;

    private String doctorName;

    private String observation;
}
