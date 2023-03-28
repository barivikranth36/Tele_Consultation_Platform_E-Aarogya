package com.shield.eaarogya.Repository;

import com.shield.eaarogya.Entity.Doctor;
import com.shield.eaarogya.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // you can use CUSTOM FINDER METHODS for implementing some custom fetch get methods
    /* follow this for custom finder methods https://www.youtube.com/watch?v=QeRCW28jhFY&list=PL0zysOflRCelmjxj-g4jLr3WKraSU_e8q&index=14
        follow this for sql native query or jpql https://www.youtube.com/watch?v=6bxxsoCqll4&list=PL0zysOflRCelmjxj-g4jLr3WKraSU_e8q&index=15
     */

//    public List<Doctor> findDoctorsByDepartmentDept_id(int dept_id);
    public Doctor findByEmail(String email);

    public Doctor findByPhoneNumber(String phoneNumber);
}
