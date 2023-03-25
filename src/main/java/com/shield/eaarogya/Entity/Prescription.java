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
    private Date date;

    @Column(name = "observation", nullable = false)
    private String observation;

    @Column(name = "medicine")
    private String medicine;

    @Column(name = "remark", nullable = false)
    private String remark;

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

    public Prescription(Date date, String observation, String medicine, String remark, Doctor doctor, Patient patient) {
        this.date = date;
        this.observation = observation;
        this.medicine = medicine;
        this.remark = remark;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
                ", date='" + date + '\'' +
                ", prescription='" + observation + '\'' +
                ", remark='" + remark + '\'' +
                ", doctor=" + doctor.getFirstName() +
                ", patient=" + patient.getFirstName() +
                '}';
    }
}
