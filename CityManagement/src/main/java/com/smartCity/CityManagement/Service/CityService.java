package com.smartCity.CityManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.smartCity.CityManagement.Dao.CityDao;
import com.smartCity.CityManagement.Model.City;

@Service
public class CityService {
	@Autowired
	CityDao cityDao;

	public ResponseEntity<String> addCity(City city) {

		cityDao.save(city);
		return new ResponseEntity<>("City added Successfully",HttpStatus.CREATED);
	}

}
