package com.shield.eaarogya.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long doctorId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phoneNumber", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "registration_number", nullable = false, unique = true)
    private String registration_number;

    @Column(name = "dob", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "gender", nullable = false)
    private String gender;

    @ElementCollection
    @CollectionTable(name = "languages_of_doctor", joinColumns = @JoinColumn(name = "doctorId"))
    private Set<String> doctorLanguages;

    @Column(name = "address", nullable = false)
    private String addr;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "pincode", nullable = false)
    private long pincode;

    // Many-to-One Mapping with Department Table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department", referencedColumnName = "departmentId")
    private Department department;


    // One-to-Many Mapping with Prescription Table
//    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
//    private List<Prescription> prescriptionList;


    // ------------------------------------- Constructor ------------------------------------

    public Doctor() {
    }

    public Doctor(String title, String firstName, String lastName, String phoneNumber, String email, String registration_number, Date dob, String gender, Set<String> doctorLanguages, String addr, String city, long pincode, Department department) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.registration_number = registration_number;
        this.dob = dob;
        this.gender = gender;
        this.doctorLanguages = doctorLanguages;
        this.addr = addr;
        this.city = city;
        this.pincode = pincode;
        this.department = department;
    }

    // ------------------------------------ toString() method ------------------------------


    @Override
    public String toString() {
        return "Doctor{" +
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
                ", department=" + department.toString() +
                '}';
    }
}
