package com.shield.eaarogya.DTO;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class PatientDetails {

    private long patientId;

    private String title;

    private String fullName;

    private String lastName;

    private String gender;

    private long phoneNo;

    private String email;

    @Temporal(TemporalType.DATE)
    private Date dob;

    private String addr;

    private String city;

    private long pincode;

//    private List<Prescription> prescriptionList;
    // --------------------------------- Constructor ---------------------------------------

    public PatientDetails() {
    }

    public PatientDetails(long patientId, String title, String fullName, String lastName, String gender, long phoneNo, String email, Date dob, String addr, String city, long pincode) {
        this.patientId = patientId;
        this.title = title;
        this.fullName = fullName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.email = email;
        this.dob = dob;
        this.addr = addr;
        this.city = city;
        this.pincode = pincode;
    }

    // ----------------------------------- Getters and Setters -------------------------------------

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
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

    // ------------------------------------ toString() method ---------------------------------------

    @Override
    public String toString() {
        return "PatientDetails{" +
                "patientId=" + patientId +
                ", title='" + title + '\'' +
                ", fName='" + fullName + '\'' +
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
