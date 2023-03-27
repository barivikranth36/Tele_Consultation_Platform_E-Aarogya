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
    private Date consultationDate;
    private String observation;
    private String medicine;
    private String remark;
    private String doctorName;
    private long doctorId;
    private String patientName;
    private long patientId;

    @Temporal(TemporalType.DATE)
    private Date followUpDate;

    // -------------------------Constructors ---------------------------


    public PrescriptionDetails() {
    }

    public PrescriptionDetails(int prescriptionId, Date consultationDate, String observation, String medicine, String remark, String doctorName, long doctorId, String patientName, long patientId, Date followUpDate) {
        this.prescriptionId = prescriptionId;
        this.consultationDate = consultationDate;
        this.observation = observation;
        this.medicine = medicine;
        this.remark = remark;
        this.doctorName = doctorName;
        this.doctorId = doctorId;
        this.patientName = patientName;
        this.patientId = patientId;
        this.followUpDate = followUpDate;
    }

    // ------------------------------------- toString() --------------------

    @Override
    public String toString() {
        return "PrescriptionDetails{" +
                "pres_id=" + prescriptionId +
                ", date='" + consultationDate + '\'' +
                ", prescription='" + observation + '\'' +
                ", remark='" + remark + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", patientName='" + patientName + '\'' +
                '}';
    }
}
