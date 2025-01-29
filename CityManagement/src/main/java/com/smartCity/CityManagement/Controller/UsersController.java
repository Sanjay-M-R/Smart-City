package com.smartCity.CityManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartCity.CityManagement.Service.UsersService;

@RestController
@RequestMapping("User")
public class UsersController {
	
	@Autowired
	UsersService usersService;
}
