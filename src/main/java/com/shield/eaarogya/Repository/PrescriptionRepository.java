package com.shield.eaarogya.Repository;

import com.shield.eaarogya.Entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {
    public List<Prescription> findPrescriptionsByPatient_PatientId(long patientId);
}
