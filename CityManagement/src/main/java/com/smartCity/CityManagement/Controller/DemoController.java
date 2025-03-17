package com.smartCity.CityManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartCity.CityManagement.Model.Demo;
import com.smartCity.CityManagement.Service.DemoService;

@RestController
@RequestMapping("/Demo")
public class DemoController {

	@Autowired
	DemoService demoService;
	
	@PostMapping("/newDemo")
	public ResponseEntity<String> createDemo(@RequestBody Demo demo){
		return demoService.addDemo(demo);
		
	}
}
