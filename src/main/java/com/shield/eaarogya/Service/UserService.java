package com.shield.eaarogya.Service;


import com.shield.eaarogya.Entity.Doctor;
import com.shield.eaarogya.Entity.Patient;
import com.shield.eaarogya.Repository.DoctorRepository;
import com.shield.eaarogya.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public UserDetails loadUserByUsername(String phoneNumber){
        // Check if user is a doctor
        Doctor doctor = doctorRepository.findByPhoneNumber(phoneNumber);
        if (doctor != null) {
            return new User(doctor.getPhoneNumber(), doctor.getPhoneNumber(),
                    AuthorityUtils.createAuthorityList("ROLE_DOCTOR"));
        }

        // Check if user is a patient
        Patient patient = patientRepository.findByPhoneNo(phoneNumber);
        if (patient != null) {
            return new User(patient.getPhoneNo(), patient.getPhoneNo(),
                    AuthorityUtils.createAuthorityList("ROLE_PATIENT"));
        }

        throw new UsernameNotFoundException("User Not Found");
    }
}
