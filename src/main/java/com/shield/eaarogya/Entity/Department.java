package com.shield.eaarogya.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dept_id;

    @Column(name = "dept_name", nullable = false, unique = true)
    private String dept_name;

    @Column(name = "description", nullable = false)
    private String description;

    // One-to-Many Mapping with Doctor table
    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private List<Doctor> doctorList;

    // ----------------------------------- Constructors ---------------------------------------

    public Department() {
    }

    public Department(String dept_name, String description) {
        this.dept_name = dept_name;
        this.description = description;
    }

    // -------------------------------- Getters and Setters -------------------------------------

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    // ---------------------------------- toString() ----------------------------------------

    @Override
    public String toString() {
        return "Department{" +
                "dept_id=" + dept_id +
                ", dept_name='" + dept_name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
