package com.shield.eaarogya.Service;

import java.io.ByteArrayInputStream;

public interface PdfService {

    public ByteArrayInputStream generatePdf(int prescriptionId);
}
