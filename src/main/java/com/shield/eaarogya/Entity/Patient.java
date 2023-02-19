package com.shield.eaarogya.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patientId;

    @Column(name="first_name", nullable = false)
    private String fName;

    @Column(name="last_name", nullable = false)
    private String lName;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "phone_no", nullable = false)
    private long phoneNo;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "dob", nullable = false)
    private String dob;

    @Column(name = "address", nullable = false)
    private String addr;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "pincode", nullable = false)
    private long pincode;

    // One-to-Many Mapping with Prescription Table
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private List<Prescription> prescriptionList;



    // ----------------------- Generating Constructor -----------------------------

    public Patient() {
    }

    public Patient(String fName, String lName, String gender, long phoneNo, String email, String dob, String addr, String city, long pincode) {
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.email = email;
        this.dob = dob;
        this.addr = addr;
        this.city = city;
        this.pincode = pincode;
    }

    // ----------------------- Generating Getters and Setters --------------------------

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    // ------------------------------ toString() method -----------------------------


    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
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
