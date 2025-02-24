package com.smartCity.CityManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.lowagie.text.DocumentException;
import com.smartCity.CityManagement.Dao.RequestDao;
import com.smartCity.CityManagement.Model.Department;
import com.smartCity.CityManagement.Model.ServiceRequest;

import jakarta.mail.MessagingException;

@Service
public class SchedulerService {
	
	@Autowired
	RequestDao requestDao;
	
	@Autowired
	PdfService pdfService;
	
	@Autowired
	EmailService emailService;
	
	@Scheduled(cron = "0 0 * * * *")
	public void sendPendingRequestToDepartment() throws DocumentException, MessagingException {
		List<ServiceRequest> pendingRequest = requestDao.findByStatus("PENDING");
		
		for(ServiceRequest request:pendingRequest ) {
			request.setStatus("IN PROGRESS");
			Department department = request.getDepartment();
			
			String subject="Pending request";
			String text = "Please find the pending request";
			String filename = "PendingRequest"+request.getId()+".pdf"; 
			byte[] pdf = pdfService.generateServiceRequestPdf(request);
			
			
			emailService.sendEmailWithAttachment(department.getEmail(), subject, text, pdf, filename);
			
		}
	}

}
