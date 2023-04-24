package com.shield.eaarogya.Service.ServiceImpl;

import com.shield.eaarogya.DTO.DateWiseConsultations;
import com.shield.eaarogya.Entity.Consultation;
import com.shield.eaarogya.Repository.ConsultationRepository;
import com.shield.eaarogya.Service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Override
    public long getAllConsultationsCount() {
        return (consultationRepository.findAll()).stream().count();
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

//        // We'll compare the dates in string format, we'll convert consultation date and current date to the below pattern
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        Map<String, Long> totalConsultations = new HashMap<>();
//
//        for(Consultation consultation: consultationList) {
//            String date = dateFormat.format(consultation.getConsultationDate());
//            if(totalConsultations.containsKey(date)) {
//                totalConsultations.put(date, totalConsultations.get(date) + 1);
//            }
//            else totalConsultations.put(date, 1L);
//
//        }
        return dateWiseConsultationsList;
    }
}
