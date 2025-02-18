package com.smartCity.CityManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.smartCity.CityManagement.Dao.RequestDao;
import com.smartCity.CityManagement.Model.ServiceRequest;
import com.smartCity.CityManagement.Model.Users;

@Service

public class RequestService {
	@Autowired
	RequestDao requestDao;

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
	
	
	
	

}
