package com.smartCity.CityManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartCity.CityManagement.Dao.UsersDao;

@Service

public class UsersService {
	
	@Autowired
	UsersDao usersDao;

}
