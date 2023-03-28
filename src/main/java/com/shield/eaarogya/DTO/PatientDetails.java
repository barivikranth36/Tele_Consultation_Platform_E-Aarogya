package com.shield.eaarogya.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
public class PatientDetails {

    private long patientId;

    private String title;

    private String fullName;

    private String lastName;

    private String gender;

    private String phoneNo;

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

    public PatientDetails(long patientId, String title, String fullName, String lastName, String gender, String phoneNo, String email, Date dob, String addr, String city, long pincode) {
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
