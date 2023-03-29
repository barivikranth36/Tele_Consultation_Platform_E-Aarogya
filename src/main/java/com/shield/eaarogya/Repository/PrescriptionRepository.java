package com.shield.eaarogya.Repository;

import com.shield.eaarogya.Entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {
    public List<Prescription> findPrescriptionsByPatient_PatientId(long patientId);

//    public List<Prescription> findPrescriptionsByConsultationDateEqualsaAndDoctor_DoctorId(Date consultationDate,
//                                                                                           long doctorId);

    public List<Prescription> findPrescriptionsByDoctor_DoctorId(long doctorId);
}
