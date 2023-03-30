package com.shield.eaarogya.Service.ServiceImpl;

import com.shield.eaarogya.DTO.DailyLogDetails;
import com.shield.eaarogya.DTO.FollowUpDetails;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        try {
            List<Prescription> prescriptionList = prescriptionRepository.findPrescriptionsByPatient_PatientId(patientId);

            List<PrescriptionDetails> prescriptionDetailsList = new ArrayList<>();

            for (Prescription prescription : prescriptionList) {
                prescriptionDetailsList.add(new PrescriptionDetails(prescription.getPrescriptionId(),
                        prescription.getConsultationDate(), prescription.getObservation(),
                        prescription.getMedicine(), prescription.getRemark(),
                        prescription.getDoctor().getFirstName() + " " + prescription.getDoctor().getLastName(),
                        prescription.getDoctor().getDoctorId(),
                        prescription.getPatient().getFirstName() + " " + prescription.getPatient().getLastName(),
                        prescription.getPatient().getPatientId(),
                        prescription.getFollowUpDate()));
            }

            return prescriptionDetailsList;
        } catch (Exception e) {
            System.out.println("Error occurred in getting prescription details of a patient");
            e.printStackTrace();
            return null;
        }
    }

    // ---------------------- Get All the Prescription present in database --------------------------------
    @Override
    public List<PrescriptionDetails> getAllPrescriptions() {

        try {
            List<Prescription> prescriptionList = this.prescriptionRepository.findAll();

            List<PrescriptionDetails> prescriptionDetailsList = new ArrayList<>();

            for (Prescription prescription : prescriptionList) {
                prescriptionDetailsList.add(new PrescriptionDetails(prescription.getPrescriptionId(),
                        prescription.getConsultationDate(), prescription.getObservation(),
                        prescription.getMedicine(),
                        prescription.getRemark(),
                        prescription.getDoctor().getFirstName() + " " + prescription.getDoctor().getLastName(),
                        prescription.getDoctor().getDoctorId(),
                        prescription.getPatient().getFirstName() + " " + prescription.getPatient().getLastName(),
                        prescription.getPatient().getPatientId(),
                        prescription.getFollowUpDate()));
            }
            return prescriptionDetailsList;
        } catch (Exception e) {
            System.out.println("Error Occurred in getting all Prescriptions");
            e.printStackTrace();
            return null;
        }
    }

    // ------------------------ Add a prescription to database ---------------------------------------
    @Override
    public PrescriptionDetails addPrescription(PrescriptionDetails prescriptionDetails) {

        Doctor prescribingDoctor;
        Patient prescribedPatient;
        try {
            if(doctorRepository.findById(prescriptionDetails.getDoctorId()).isPresent() &&
                    patientRepository.findById(prescriptionDetails.getPatientId()).isPresent()) {

                prescribingDoctor = doctorRepository.findById(prescriptionDetails.getDoctorId()).get();
                prescribedPatient = patientRepository.findById(prescriptionDetails.getPatientId()).get();

                Prescription prescription = new Prescription(
                        prescriptionDetails.getConsultationDate(),
                        prescriptionDetails.getObservation(),
                        prescriptionDetails.getMedicine(),
                        prescriptionDetails.getRemark(),
                        prescriptionDetails.getFollowUpDate(),
                        prescribingDoctor,
                        prescribedPatient);

                prescriptionRepository.save(prescription);
                return prescriptionDetails;
            }
            else return null;

        } catch (Exception e) {
            System.out.println("Error Occurred while saving the prescription.");
            e.printStackTrace();
            return null;
        }
    }

    // ------------------------ Fetch Prescription based on Prescription Id -----------------------------------
    @Override
    public PrescriptionDetails getPrescriptionById(int prescriptionId) {

        Prescription prescription;
        try {
            if(prescriptionRepository.findById(prescriptionId).isPresent()) {
                prescription = prescriptionRepository.findById(prescriptionId).get();

                return new PrescriptionDetails(prescription.getPrescriptionId(),
                        prescription.getConsultationDate(), prescription.getObservation(),
                        prescription.getMedicine(),
                        prescription.getRemark(),
                        prescription.getDoctor().getFirstName() + " " + prescription.getDoctor().getLastName(),
                        prescription.getDoctor().getDoctorId(),
                        prescription.getPatient().getFirstName() + " " + prescription.getPatient().getLastName(),
                        prescription.getPatient().getPatientId(),
                        prescription.getFollowUpDate());
            }
            return null;

        } catch (Exception e) {
            System.out.println("Error Occurred in getting prescription by prescriptionId");
            e.printStackTrace();
            return null;
        }
    }

    // ---------------------- Return Follow-up details for the particular patient -----------------------------

    @Override
    public List<FollowUpDetails> getFollowUpDetails(long patientId) {

        try {
            List<Prescription> prescriptionList = prescriptionRepository.findPrescriptionsByPatient_PatientId(patientId);

            List<FollowUpDetails> followUpDetailsList = new ArrayList<>();

            for (Prescription prescription : prescriptionList) {
                if (prescription.getFollowUpDate() != null) {
                    followUpDetailsList.add(new FollowUpDetails(
                            prescription.getFollowUpDate(),
                            prescription.getDoctor().getDepartment().getDepartmentName(),
                            prescription.getDoctor().getFirstName() + prescription.getDoctor().getLastName(),
                            prescription.getObservation()
                    ));
                }
            }

            return followUpDetailsList;
        } catch (Exception e) {
            System.out.println("Error Occurred in getting followup dates");
            e.printStackTrace();
            return null;
        }
    }

    // ---------------------------------------- Doctor's Daily Log ----------------------------------------------

    @Override
    public List<DailyLogDetails> doctorDailyLog(long doctorId) {

        List<Prescription> prescriptionList = prescriptionRepository.findPrescriptionsByDoctor_DoctorId(doctorId);

        List<DailyLogDetails> dailyLogDetailsList = new ArrayList<>();

        // We'll compare the dates in string format, we'll convert consultation date and current date to the below pattern
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if(prescriptionList != null) {

            String currentDate = dateFormat.format(new Date());

            for(Prescription prescription: prescriptionList) {
                String consultationDate = dateFormat.format(prescription.getConsultationDate());
                if(currentDate.equals(consultationDate)) {
                    dailyLogDetailsList.add(new DailyLogDetails(
                            prescription.getDoctor().getDoctorId(),
                            prescription.getConsultationDate(),
                            prescription.getPatient().getPatientId(),
                            prescription.getObservation()
                    ));
                }
            }
            return dailyLogDetailsList;
        }
        return null;
    }
}
