package com.smartCity.CityManagement.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartCity.CityManagement.Model.Service;

@Repository

public interface cityDao extends JpaRepository<Service, Integer> {

	

	
	
	

}
