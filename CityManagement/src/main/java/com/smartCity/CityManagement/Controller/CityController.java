package com.smartCity.CityManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartCity.CityManagement.Model.City;
import com.smartCity.CityManagement.Service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	CityService cityService;

	@PostMapping("/addCity")
	ResponseEntity<String> addCity(@RequestBody City city) {
		return cityService.addCity(city);

	}

}
