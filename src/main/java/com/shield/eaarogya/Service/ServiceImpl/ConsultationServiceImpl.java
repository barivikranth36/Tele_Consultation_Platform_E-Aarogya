package com.shield.eaarogya.Service.ServiceImpl;

import com.shield.eaarogya.DTO.DateWiseConsultations;
import com.shield.eaarogya.Entity.Consultation;
import com.shield.eaarogya.Repository.ConsultationRepository;
import com.shield.eaarogya.Service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Override
    public long getAllConsultationsCount() {
        return (consultationRepository.findAll()).size();
    }

    // --------------------------------------------- Add Consultation ----------------------------------------------
    @Override
    public boolean addConsultation(Consultation consultation) {
        try {
            consultationRepository.save(consultation);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // ---------------------------------------- Get Date-wise Consultations --------------------------------------------

    @Override
    public List<DateWiseConsultations> totalDateWiseConsultations() {
        List<Consultation> consultationList = consultationRepository.findAll();

        List<DateWiseConsultations> dateWiseConsultationsList = new ArrayList<>();

        Map<Date, Long> totalConsultations = new TreeMap<>();

        for(Consultation consultation: consultationList) {
            totalConsultations.merge(consultation.getConsultationDate(), 1L, Long::sum);
        }

        for (Map.Entry<Date, Long> entry : totalConsultations.entrySet()) {
            Date key = entry.getKey();
            Long value = entry.getValue();
            dateWiseConsultationsList.add(
                    new DateWiseConsultations(key, value)
            );
        }

        return dateWiseConsultationsList;
    }
}
