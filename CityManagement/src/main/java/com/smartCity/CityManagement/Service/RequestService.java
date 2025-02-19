package com.smartCity.CityManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.lowagie.text.DocumentException;
import com.smartCity.CityManagement.Dao.RequestDao;
import com.smartCity.CityManagement.Model.ServiceRequest;
import com.smartCity.CityManagement.Model.Users;

import jakarta.mail.MessagingException;

@Service

public class RequestService {
	@Autowired
	RequestDao requestDao;
	
	@Autowired
	PdfService pdfService;
	
	@Autowired
	EmailService emailService;

	public ResponseEntity<ServiceRequest> createServiceRequest(ServiceRequest request) {
		request.setStatus("PENDING");
		ServiceRequest createdRequest = requestDao.save(request);
		return new ResponseEntity<>(createdRequest,HttpStatus.CREATED);
	}

	public ResponseEntity<List<ServiceRequest>> getAllRequest() {
		List<ServiceRequest> AllServiceRequests = requestDao.findAll();
		return new ResponseEntity<>(AllServiceRequests,HttpStatus.FOUND);
	}

	public ResponseEntity<List<ServiceRequest>> getUserRequest() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Users currentUser = (Users) authentication.getPrincipal();
		List<ServiceRequest> requests = requestDao.findByRequestedBy(currentUser);
		return new ResponseEntity<>(requests,HttpStatus.FOUND);
	}

	public ResponseEntity<String> sendRequestPdfByEmail(int requestId) throws DocumentException, MessagingException {
		Optional<ServiceRequest> optionalRequest = requestDao.findById(requestId);
		if(!optionalRequest.isPresent()) {
			return new ResponseEntity<>("Service Request Not Found",HttpStatus.NOT_FOUND);
		}
		
		ServiceRequest request = optionalRequest.get();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Users currentUser = (Users) authentication.getPrincipal();
		String Email = currentUser.getEmail();
		
		byte[] attachment = pdfService.generateServiceRequestPdf(request);
		
		String subject ="Service Request details for Request ID :" + requestId;
		String text ="Please find the details of your Service Request in the attachment";
		String fileName ="ServiceRequest_"+requestId+".pdf";
		
		emailService.sendEmailWithAttachment(Email, subject, text, attachment, fileName);
		
		return new ResponseEntity<>("PDF sent successfully to your mail",HttpStatus.OK);
		
	}
	
	
	
	

}
