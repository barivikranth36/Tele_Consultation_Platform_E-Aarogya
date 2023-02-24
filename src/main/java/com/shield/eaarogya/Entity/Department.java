package com.shield.eaarogya.Entity;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @Column(name = "department_name", nullable = false, unique = true)
    private String departmentName;

    @Column(name = "description", nullable = false)
    private String description;

    // One-to-Many Mapping with Doctor table
//    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
//    private List<Doctor> doctorList;

    // ----------------------------------- Constructors ---------------------------------------

    public Department() {
    }

    public Department(String departmentName, String description) {
        this.departmentName = departmentName;
        this.description = description;
    }

    // -------------------------------- Getters and Setters -------------------------------------

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String dept_name) {
        this.departmentName = dept_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<Doctor> getDoctorList() {
//        return doctorList;
//    }
//
//    public void setDoctorList(List<Doctor> doctorList) {
//        this.doctorList = doctorList;
//    }

    // ---------------------------------- toString() ----------------------------------------

    @Override
    public String toString() {
        return "Department{" +
                "dept_id=" + departmentId +
                ", dept_name='" + departmentName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
