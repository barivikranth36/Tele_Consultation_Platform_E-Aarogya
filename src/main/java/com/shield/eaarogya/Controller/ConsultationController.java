package com.shield.eaarogya.Controller;

import com.shield.eaarogya.DTO.DateWiseConsultations;
import com.shield.eaarogya.Service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @GetMapping("/getAllConsultationsCount")
    public long getAllConsultaionCount() {
        return consultationService.getAllConsultationsCount();
    }

    // ----------------------------- Total consultations datewise ------------------------------------------
    @GetMapping("/totalDateWiseConsultations")
    public List<DateWiseConsultations> totalDateWiseConsultations() {
        return consultationService.totalDateWiseConsultations();
    }
}
