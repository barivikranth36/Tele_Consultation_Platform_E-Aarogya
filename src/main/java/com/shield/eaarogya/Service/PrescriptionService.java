package com.shield.eaarogya.Service;

import com.shield.eaarogya.DTO.PrescriptionDetails;

import java.util.List;

public interface PrescriptionService {

//    public List<Prescription> getPrescriptions(Long patientId);
    public List<PrescriptionDetails> getPrescriptions(long patientId);

    public List<PrescriptionDetails> getAllPrescriptions();

    public PrescriptionDetails addPrescription(PrescriptionDetails prescriptionDetails);

    public PrescriptionDetails getPrescriptionById(int prescriptionId);
}
