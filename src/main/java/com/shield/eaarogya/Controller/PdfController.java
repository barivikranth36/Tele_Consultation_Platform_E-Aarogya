package com.shield.eaarogya.Controller;

import com.shield.eaarogya.DTO.PrescriptionDetails;
import com.shield.eaarogya.Service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.Date;

@RestController
@RequestMapping("/pdf")
public class PdfController {

    @Autowired
    private PdfService pdfService;

    // ------------------------ Generating Pdf based on Prescription Id -------------------------------
    @PostMapping("/getPdf")
    public ResponseEntity<InputStreamResource> getPdf(@RequestBody PrescriptionDetails prescriptionDetails) {

        int pres_id = prescriptionDetails.getPrescriptionId();
        System.out.println(pres_id);
//        int pres_id = 1;

        ByteArrayInputStream pdf = pdfService.generatePdf(pres_id);

        String date = String.valueOf((new Date()));

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition",
                "inline;filename=" + pres_id + " " + date +".pdf");
// Adding headerValue to attachment will make it download the pdf and setting it to inline will show in browser only.

        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }
}
