package com.shield.eaarogya.Service.ServiceImpl;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.shield.eaarogya.DTO.PrescriptionDetails;
import com.shield.eaarogya.Entity.Patient;
import com.shield.eaarogya.Service.PatientService;
import com.shield.eaarogya.Service.PdfService;
import com.shield.eaarogya.Service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfServiceImpl implements PdfService {

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private PatientService patientService;

    @Override
    public ByteArrayInputStream generatePdf(int prescriptionId) {

        // Fetching the prescription which has to be printed
        PrescriptionDetails prescription = prescriptionService.getPrescriptionById(prescriptionId);

        // Fetching Patient Details using Patient Id.
        Patient patient = patientService.getPatientByPatientId(prescription.getPatientId());

        // Create a ByteArrayOutputStream object
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        // Document object of lowgie class
        Document document = new Document();

        // now whatever we'll write in document should be reflected in out attribute, so we'll use the following method.
        PdfWriter.getInstance(document, out);

        // Open the document and start writing
        document.open();

        // ################################ Trying to Create Table ###################################

        // ---------------------------------- Adding Patient Details -------------------------------
        PdfPTable patientTable = new PdfPTable(2);

        patientTable.setWidthPercentage(100);
        patientTable.setSpacingBefore(15);
        patientTable.setHorizontalAlignment(0);

        PdfPCell key = new PdfPCell();
        PdfPCell value = new PdfPCell();

        key.setPadding(6);
        key.setBorderWidth(0);

        value.setPadding(6);
        value.setBorderWidth(0);

        Font keyFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 15);
        Font valueFont = FontFactory.getFont(FontFactory.HELVETICA, 15);

        key.setPhrase(new Phrase("Patient Id:", keyFont));
        patientTable.addCell(key);
        value.setPhrase(new Phrase("" + prescription.getPatientId(), valueFont));
        patientTable.addCell(value);

        key.setPhrase(new Phrase("Patient Name:", keyFont));
        patientTable.addCell(key);
        value.setPhrase(new Phrase(prescription.getPatientName(), valueFont));
        patientTable.addCell(value);

        key.setPhrase(new Phrase("Gender:", keyFont));
        patientTable.addCell(key);
        value.setPhrase(new Phrase(patient.getGender(), valueFont));
        patientTable.addCell(value);

        key.setPhrase(new Phrase("Contact Number:", keyFont));
        patientTable.addCell(key);
        value.setPhrase(new Phrase("" + patient.getPhoneNo(), valueFont));
        patientTable.addCell(value);

        key.setPhrase(new Phrase("Doctor Name:", keyFont));
        patientTable.addCell(key);
        value.setPhrase(new Phrase("" + prescription.getDoctorName(), valueFont));
        patientTable.addCell(value);

        key.setPhrase(new Phrase("Doctor Id:", keyFont));
        patientTable.addCell(key);
        value.setPhrase(new Phrase("" + prescription.getDoctorId(), valueFont));
        patientTable.addCell(value);

        document.add(patientTable);

        // ---------------------------------- Patient Details Added ------------------------------------------

        // ---------------------------------- Adding Prescription ------------------------------------------

        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);
        table.setHorizontalAlignment(0);


        PdfPCell headerCell = new PdfPCell();
        PdfPCell paraCell = new PdfPCell();

        // Styling header cell
        headerCell.setBackgroundColor(Color.LIGHT_GRAY);
        headerCell.setBorderWidth(0);
        headerCell.setPadding(5);
        com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
        font.setColor(Color.BLACK);

        // Styling paragraph cell
        Font paraFont = FontFactory.getFont(FontFactory.HELVETICA, 14);
        paraCell.setPadding(6);
        paraCell.setBorderWidth(0);

        headerCell.setPhrase(new Phrase("Observation", font));
        table.addCell(headerCell);

        paraCell.setPhrase(new Phrase(prescription.getObservation(), paraFont));
        table.addCell(paraCell);

        headerCell.setPhrase(new Phrase("Medicine", font));
        table.addCell(headerCell);

        paraCell.setPhrase(new Phrase(prescription.getMedicine(), paraFont));
        table.addCell(paraCell);

        headerCell.setPhrase(new Phrase("Remark", font));
        table.addCell(headerCell);

        paraCell.setPhrase(new Phrase(prescription.getRemark(), paraFont));
        table.addCell(paraCell);

        document.add(table);

        // Close the document
        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
}
