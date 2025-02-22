package com.smartCity.CityManagement.Service;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.smartCity.CityManagement.Model.ServiceRequest;

@Service
public class PdfService {

	public byte[] generateServiceRequestPdf(ServiceRequest request) throws DocumentException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Document document = new Document();
		PdfWriter.getInstance(document, outputStream);
		
		document.add(new Paragraph("Service Request Details\n\n"));
		document.add(new Paragraph("Request ID: " + request.getId()));
		document.add(new Paragraph("Type: " + request.getType()));
		document.add(new Paragraph("Description: " + request.getDescription()));
        
        document.add(new Paragraph("Status: " + request.getStatus()));
        
        document.close();
		return outputStream.toByteArray();
	}

}
