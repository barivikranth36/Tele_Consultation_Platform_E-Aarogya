package com.shield.eaarogya.Entity;

import javax.persistence.*;
import java.util.Date;

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

    public Doctor(String title, String firstName, String lastName, String phoneNumber, String email, String registration_number, Date dob, String gender, String addr, String city, long pincode, Department department) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.registration_number = registration_number;
        this.dob = dob;
        this.gender = gender;
        this.addr = addr;
        this.city = city;
        this.pincode = pincode;
        this.department = department;
    }

    // ---------------------------------- Getters and Setters -------------------------------------

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long dr_id) {
        this.doctorId = dr_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
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
