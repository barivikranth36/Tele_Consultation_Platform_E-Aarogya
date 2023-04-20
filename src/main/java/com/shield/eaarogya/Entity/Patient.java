package com.shield.eaarogya.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name="patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patientId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "phone_no", nullable = false)
    private String phoneNo;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "dob", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "address", nullable = false)
    private String addr;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "pincode", nullable = false)
    private long pincode;

    // One-to-Many Mapping with Prescription Table
//    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
//    private List<Prescription> prescriptionList;



    // ----------------------- Generating Constructor -----------------------------

    public Patient() {
    }

    public Patient(String title, String firstName, String lastName, String gender, String phoneNo, String email, Date dob, String addr, String city, long pincode) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.email = email;
        this.dob = dob;
        this.addr = addr;
        this.city = city;
        this.pincode = pincode;
    }

    // ------------------------------ toString() method -----------------------------


    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", title='" + title + '\'' +
                ", fName='" + firstName + '\'' +
                ", lName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNo=" + phoneNo +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", addr='" + addr + '\'' +
                ", city='" + city + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}
