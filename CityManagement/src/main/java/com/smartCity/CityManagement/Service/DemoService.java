package com.smartCity.CityManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.smartCity.CityManagement.Dao.DemoDao;
import com.smartCity.CityManagement.Model.Demo;

@Service
public class DemoService {
	@Autowired
	DemoDao demoDao;

	public ResponseEntity<String> addDemo(Demo demo) {
		demoDao.save(demo);
		return new ResponseEntity<>("Demo created",HttpStatus.CREATED);
	}

}
