package com.smartCity.CityManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.smartCity.CityManagement.Dao.DepartmentDao;
import com.smartCity.CityManagement.Model.Department;

@Service

public class DepartmentService {
	@Autowired
	DepartmentDao departmentDao;


	public ResponseEntity<String> createDepartment(Department department) {
		departmentDao.save(department);
		return new ResponseEntity<>("Department Created",HttpStatus.CREATED);	}

}
