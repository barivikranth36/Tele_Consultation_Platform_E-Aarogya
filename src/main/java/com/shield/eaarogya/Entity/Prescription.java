package com.shield.eaarogya.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prescriptionId;

    // Working with date as a string, Later if required we can change it to some other Object

//    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @Column(name = "consultation_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date consultationDate;

    @Column(name = "observation", nullable = false)
    private String observation;

    @Column(name = "medicine")
    private String medicine;

    @Column(name = "remark", nullable = false)
    private String remark;

    @Column(name = "follow_up_date")
    @Temporal(TemporalType.DATE)
    private Date followUpDate;

    // Add many-to-one mapping to Doctor
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor", referencedColumnName = "doctorId")
    private Doctor doctor;

    // Add many-to-one mapping to Patient
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient", referencedColumnName = "patientId")
    private Patient patient;


    // ------------------------------------- Constructors -------------------------------------

    public Prescription() {
    }

    public Prescription(Date consultationDate, String observation, String medicine, String remark, Date followUpDate, Doctor doctor, Patient patient) {
        this.consultationDate = consultationDate;
        this.observation = observation;
        this.medicine = medicine;
        this.remark = remark;
        this.followUpDate = followUpDate;
        this.doctor = doctor;
        this.patient = patient;
    }

    // ----------------------------------- Getters and Setters --------------------------------------

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int pres_id) {
        this.prescriptionId = pres_id;
    }

    public Date getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(Date date) {
        this.consultationDate = date;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String prescription) {
        this.observation = prescription;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getRemark() {
        return remark;
    }

    public Date getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(Date followUpDate) {
        this.followUpDate = followUpDate;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // ------------------------------------ toString() method -------------------------------------

    @Override
    public String toString() {
        return "Prescription{" +
                "pres_id=" + prescriptionId +
                ", date='" + consultationDate + '\'' +
                ", prescription='" + observation + '\'' +
                ", remark='" + remark + '\'' +
                ", doctor=" + doctor.getFirstName() +
                ", patient=" + patient.getFirstName() +
                '}';
    }
}
