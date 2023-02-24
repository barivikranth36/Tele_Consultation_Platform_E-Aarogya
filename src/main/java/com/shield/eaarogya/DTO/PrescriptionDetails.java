package com.shield.eaarogya.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
public class PrescriptionDetails {

    private int prescriptionId;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String observation;
    private String medicine;
    private String remark;
    private String doctorName;
    private long doctorId;
    private String patientName;
    private long patientId;

    // -------------------------Constructors ---------------------------


    public PrescriptionDetails() {
    }

    public PrescriptionDetails(int prescriptionId, Date date, String observation, String medicine, String remark, String doctorName, long doctorId, String patientName, long patientId) {
        this.prescriptionId = prescriptionId;
        this.date = date;
        this.observation = observation;
        this.medicine = medicine;
        this.remark = remark;
        this.doctorName = doctorName;
        this.doctorId = doctorId;
        this.patientName = patientName;
        this.patientId = patientId;
    }

    // ------------------------------------- toString() --------------------

    @Override
    public String toString() {
        return "PrescriptionDetails{" +
                "pres_id=" + prescriptionId +
                ", date='" + date + '\'' +
                ", prescription='" + observation + '\'' +
                ", remark='" + remark + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", patientName='" + patientName + '\'' +
                '}';
    }
}
