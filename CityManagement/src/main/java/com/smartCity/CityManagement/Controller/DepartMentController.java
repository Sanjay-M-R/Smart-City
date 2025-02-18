package com.smartCity.CityManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartCity.CityManagement.Model.Department;
import com.smartCity.CityManagement.Service.DepartmentService;

@RestController
@RequestMapping("/Deparment")
public class DepartMentController {

	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/newDepartment")
	public ResponseEntity<String> createDepartment(@RequestBody Department department){
		return departmentService.createDepartment(department);
		
	}
}
