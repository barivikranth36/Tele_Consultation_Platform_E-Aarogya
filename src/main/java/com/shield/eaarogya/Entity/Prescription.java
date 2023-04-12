package com.shield.eaarogya.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "prescription")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prescriptionId;

    //    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @Column(name = "consultation_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date consultationDate;

    @Column(name = "observation", nullable = false)
    private String observation;

    @ElementCollection
    @CollectionTable(name = "medicines", joinColumns = @JoinColumn(name = "prescriptionId"))
    private Set<String> medicine;

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

    public Prescription(Date consultationDate, String observation, Set<String> medicine, String remark, Date followUpDate, Doctor doctor, Patient patient) {
        this.consultationDate = consultationDate;
        this.observation = observation;
        this.medicine = medicine;
        this.remark = remark;
        this.followUpDate = followUpDate;
        this.doctor = doctor;
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
