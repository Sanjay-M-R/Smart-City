package com.smartCity.CityManagement.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartCity.CityManagement.Model.City;

@Repository
public interface CityDao extends JpaRepository<City, Integer>{

	
}
