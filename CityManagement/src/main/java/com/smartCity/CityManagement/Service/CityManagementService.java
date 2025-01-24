package com.smartCity.CityManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.smartCity.CityManagement.Dao.cityDao;

@Service

public class CityManagementService {
	@Autowired
	cityDao citydao;
	public ResponseEntity<String> create(com.smartCity.CityManagement.Model.Service service) {
		citydao.save(service);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}
	public ResponseEntity<List<com.smartCity.CityManagement.Model.Service>> findAll() {
		return new ResponseEntity<>(citydao.findAll(),HttpStatus.FOUND);
	}
	public ResponseEntity<com.smartCity.CityManagement.Model.Service> findById(Integer id) {
		return new ResponseEntity<>(citydao.getById(id),HttpStatus.FOUND);
	}
	
	
	

}
