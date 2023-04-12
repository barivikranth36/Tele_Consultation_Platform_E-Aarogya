package com.shield.eaarogya.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
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
