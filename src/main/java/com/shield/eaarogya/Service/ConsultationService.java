package com.shield.eaarogya.Service;

import com.shield.eaarogya.DTO.DateWiseConsultations;
import com.shield.eaarogya.Entity.Consultation;

import java.util.List;

public interface ConsultationService {
    long getAllConsultationsCount();

    boolean addConsultation(Consultation consultation);

    List<DateWiseConsultations> totalDateWiseConsultations();
}
