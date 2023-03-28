package com.shield.eaarogya.Service.ServiceImpl;

import com.shield.eaarogya.DTO.DoctorDetails;
import com.shield.eaarogya.Entity.Department;
import com.shield.eaarogya.Entity.Doctor;
import com.shield.eaarogya.Repository.DoctorRepository;
import com.shield.eaarogya.Service.DepartmentService;
import com.shield.eaarogya.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DoctorRepository doctorRepository;

    // --------------------------------- Add Doctor to Database -------------------------------------
    @Override
    public DoctorDetails addDoctor(DoctorDetails doctorDetails) {

        try {
            Department department = departmentService.getDepartmentByName(doctorDetails.getDepartmentName());

            Doctor doctor = new Doctor(doctorDetails.getTitle(),
                    doctorDetails.getFirstName(), doctorDetails.getLastName(),
                    doctorDetails.getPhoneNumber(),
                    doctorDetails.getEmail(), doctorDetails.getRegistration_number(),
                    doctorDetails.getDob(), doctorDetails.getGender(),
                    doctorDetails.getAddr(), doctorDetails.getCity(),
                    doctorDetails.getPincode(), department);

            doctorRepository.save(doctor);
            return doctorDetails;
        } catch (Exception e) {
            System.out.println("Error Occured while adding doctor to the databse");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DoctorDetails> getAllDoctors() {

        try {
            List<Doctor> doctorList = doctorRepository.findAll();

            List<DoctorDetails> doctorDetailsList = new ArrayList<DoctorDetails>();

            for (Doctor doctor : doctorList) {
                doctorDetailsList.add(new DoctorDetails(doctor.getDoctorId(),
                        doctor.getTitle(), doctor.getFirstName(),
                        doctor.getLastName(), doctor.getEmail(),
                        doctor.getPhoneNumber(),
                        doctor.getRegistration_number(), doctor.getDob(),
                        doctor.getGender(), doctor.getAddr(), doctor.getCity(),
                        doctor.getPincode(), doctor.getDepartment().getDepartmentName()));
            }

            return doctorDetailsList;
        } catch (Exception e) {
            System.out.println("Error Occured while getting list of all doctors");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public DoctorDetails findByEmail(String email) {
        try {
            Doctor doctor = doctorRepository.findByEmail(email);

            return new DoctorDetails(doctor.getDoctorId(),
                    doctor.getTitle(), doctor.getFirstName(),
                    doctor.getLastName(), doctor.getEmail(),
                    doctor.getPhoneNumber(),
                    doctor.getRegistration_number(),
                    doctor.getDob(), doctor.getGender(),
                    doctor.getAddr(), doctor.getCity(),
                    doctor.getPincode(),
                    doctor.getDepartment().getDepartmentName());
        } catch (Exception e) {
            System.out.println("Error Occured while getting doctor details from email");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean verifyPhoneNumber(long phoneNumber) {
        try {
            Doctor doctor = doctorRepository.findByPhoneNumber(phoneNumber);
            if (doctor != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error Occured while verifying phone number");
            e.printStackTrace();
            return false;
        }
    }
}
