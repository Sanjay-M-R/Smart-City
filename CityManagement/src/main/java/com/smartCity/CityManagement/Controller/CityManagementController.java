package com.smartCity.CityManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartCity.CityManagement.Model.Service;
import com.smartCity.CityManagement.Service.CityManagementService;

@RestController

@RequestMapping("SmartCity")
public class CityManagementController {
	
	@Autowired
	CityManagementService cityService;
	
	@PostMapping("newServiceRequest")
	public ResponseEntity<String> Create(@RequestBody Service service){
		return cityService.create(service);
		
	}
	@GetMapping("service")
	public ResponseEntity<List<Service>> findAll(){
		return cityService.findAll();
		
	}
	@GetMapping("service/{id}")
	public ResponseEntity<Service> findById(@PathVariable Integer id){
		return cityService.findById(id);
	}
	
	

}
