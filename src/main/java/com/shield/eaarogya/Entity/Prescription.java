package com.shield.eaarogya.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pres_id;

    // Working with date as a string, Later if required we can change it to some other Object
    @Column(name = "consultation_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private String date;

    @Column(name = "prescription", nullable = false)
    private String prescription;

    @Column(name = "remark", nullable = false)
    private String remark;

    // Add many-to-one mapping to Doctor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor", referencedColumnName = "dr_id")
    private Doctor doctor;

    // Add many-to-one mapping to Patient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient", referencedColumnName = "patientId")
    private Patient patient;


    // ------------------------------------- Constructors -------------------------------------

    public Prescription() {
    }

    public Prescription(String date, String prescription, String remark, Doctor doctor, Patient patient) {
        this.date = date;
        this.prescription = prescription;
        this.remark = remark;
        this.doctor = doctor;
        this.patient = patient;
    }

    // ----------------------------------- Getters and Setters --------------------------------------

    public int getPres_id() {
        return pres_id;
    }

    public void setPres_id(int pres_id) {
        this.pres_id = pres_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
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
                "pres_id=" + pres_id +
                ", date='" + date + '\'' +
                ", prescription='" + prescription + '\'' +
                ", remark='" + remark + '\'' +
                ", doctor=" + doctor.getfName() +
                ", patient=" + patient.getfName() +
                '}';
    }
}
