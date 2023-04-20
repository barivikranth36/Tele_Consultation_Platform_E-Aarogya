package com.shield.eaarogya.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Set;

/*
    This Class is to merge the department and doctor data and transfer it through the API
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    private Set<String> doctorLanguages;


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
