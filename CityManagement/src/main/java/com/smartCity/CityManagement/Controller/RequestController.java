package com.smartCity.CityManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.smartCity.CityManagement.Model.ServiceRequest;
import com.smartCity.CityManagement.Service.RequestService;

import jakarta.mail.MessagingException;

@RestController

@RequestMapping("/ServiceRequest")
public class RequestController {

	@Autowired
	RequestService requestService;

	@PostMapping("/RaiseRequest")
	public ResponseEntity<ServiceRequest> createServiceRequest(@RequestBody ServiceRequest request) {
		return requestService.createServiceRequest(request);
	}

	@GetMapping("/Admin/all")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<ServiceRequest>> getAllRequest() {
		return requestService.getAllRequest();
	}

	@GetMapping("/User/My-ServiceRequests")
	public ResponseEntity<List<ServiceRequest>> getUserRequest() {
		return requestService.getUserRequest();
	}

	@PostMapping("/User/My-ServiceRequests/{requestId}/Send-Pdf")
	public ResponseEntity<String> sendServiceRequestPdf(@PathVariable int requestId) throws DocumentException, MessagingException {
		return requestService.sendRequestPdfByEmail(requestId);
	}

}
