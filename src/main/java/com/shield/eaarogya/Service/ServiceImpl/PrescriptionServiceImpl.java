package com.shield.eaarogya.Service.ServiceImpl;

import com.shield.eaarogya.Repository.DoctorRepository;
import com.shield.eaarogya.Repository.PatientRepository;
import com.shield.eaarogya.DTO.PrescriptionDetails;
import com.shield.eaarogya.Repository.PrescriptionRepository;
import com.shield.eaarogya.Entity.Doctor;
import com.shield.eaarogya.Entity.Patient;
import com.shield.eaarogya.Entity.Prescription;
import com.shield.eaarogya.Service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    PrescriptionRepository prescriptionRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    // --------------------- Get Prescription of a patient based on his ID --------------------------------
    @Override
    public List<PrescriptionDetails> getPrescriptions(long patientId) {
        List<Prescription> prescriptionList = prescriptionRepository.findPrescriptionsByPatient_PatientId(patientId);

        List<PrescriptionDetails> prescriptionDetailsList = new ArrayList<PrescriptionDetails>();

        for(Prescription prescription: prescriptionList) {
            prescriptionDetailsList.add(new PrescriptionDetails(prescription.getPrescriptionId(),
                    prescription.getDate(), prescription.getObservation(),
                    prescription.getMedicine(), prescription.getRemark(),
                    prescription.getDoctor().getFirstName() + " " + prescription.getDoctor().getLastName(),
                    prescription.getDoctor().getDoctorId(),
                    prescription.getPatient().getFirstName() + " " + prescription.getPatient().getLastName(),
                    prescription.getPatient().getPatientId()));
        }

        return prescriptionDetailsList;
    }

    // ---------------------- Get All the Prescription present in database --------------------------------
    @Override
    public List<PrescriptionDetails> getAllPrescriptions() {

        List<Prescription> prescriptionList = (List<Prescription>) this.prescriptionRepository.findAll();

        List<PrescriptionDetails> prescriptionDetailsList = new ArrayList<PrescriptionDetails>();

        for(Prescription prescription: prescriptionList) {
            prescriptionDetailsList.add(new PrescriptionDetails(prescription.getPrescriptionId(),
                    prescription.getDate(), prescription.getObservation(),
                    prescription.getMedicine(),
                    prescription.getRemark(),
                    prescription.getDoctor().getFirstName() + " " + prescription.getDoctor().getLastName(),
                    prescription.getDoctor().getDoctorId(),
                    prescription.getPatient().getFirstName() + " " + prescription.getPatient().getLastName(),
                    prescription.getPatient().getPatientId()));
        }
        return prescriptionDetailsList;
    }

    // ------------------------ Add a prescription to database ---------------------------------------
    @Override
    public PrescriptionDetails addPrescription(PrescriptionDetails prescriptionDetails) {

        Doctor prescribingDoctor = doctorRepository.findById(prescriptionDetails.getDoctorId()).get();

        Patient prescribedPatient = patientRepository.findById(prescriptionDetails.getPatientId()).get();

        Prescription prescription = new Prescription(prescriptionDetails.getDate(),
                prescriptionDetails.getObservation(),
                prescriptionDetails.getMedicine(),
                prescriptionDetails.getRemark(), prescribingDoctor,
                prescribedPatient);
        
        try {
            prescriptionRepository.save(prescription);
        }
        catch (Exception e) {
            return null;
        }

        return prescriptionDetails;
    }

    // ------------------------ Fetch Prescription based on Prescription Id -----------------------------------
    @Override
    public PrescriptionDetails getPrescriptionById(int pres_id) {
        Prescription prescription = prescriptionRepository.findById(pres_id).get();

        return new PrescriptionDetails(prescription.getPrescriptionId(),
                prescription.getDate(), prescription.getObservation(),
                prescription.getMedicine(),
                prescription.getRemark(),
                prescription.getDoctor().getFirstName() + " " + prescription.getDoctor().getLastName(),
                prescription.getDoctor().getDoctorId(),
                prescription.getPatient().getFirstName() + " " + prescription.getPatient().getLastName(),
                prescription.getPatient().getPatientId());
    }
//    @Override
//    public List<Prescription> getPrescriptions(Long pres_id) {
////        Integer presId = new Integer(pres_id);
//        return this.prescriptionDAO.findByPatientId(pres_id);
//    }


}
