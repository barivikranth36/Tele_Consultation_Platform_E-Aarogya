package com.shield.eaarogya.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/*
    This Class is to merge the department and doctor data and transfer it through the API
*/

@Getter
@Setter
public class DoctorDetails {

    private long doctorId;

    private String title;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String registration_number;

    @Temporal(TemporalType.DATE)
    private Date dob;

    private String gender;

    private String addr;

    private String city;

    private long pincode;

    private String departmentName;

//    private String description;

    // ---------------------------------- Constructors ----------------------------------


    public DoctorDetails() {
    }

    public DoctorDetails(long doctorId, String title, String firstName, String lastName, String email, String phoneNumber, String registration_number, Date dob, String gender, String addr, String city, long pincode, String departmentName) {
        this.doctorId = doctorId;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.registration_number = registration_number;
        this.dob = dob;
        this.gender = gender;
        this.addr = addr;
        this.city = city;
        this.pincode = pincode;
        this.departmentName = departmentName;
    }

    // ----------------------------------- Getters and Setters --------------------------------------

    // ------------------------------- toString() method -------------------------------

    @Override
    public String toString() {
        return "DoctorDepartment{" +
                "dr_id=" + doctorId +
                ", title='" + title + '\'' +
                ", fName='" + firstName + '\'' +
                ", lName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", registration_number='" + registration_number + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", addr='" + addr + '\'' +
                ", city='" + city + '\'' +
                ", pincode=" + pincode +
                ", dept_name='" + departmentName + '\'' +
                '}';
    }
}
