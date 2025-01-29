package com.smartCity.CityManagement.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartCity.CityManagement.Model.ServiceRequest;

@Repository
public interface RequestDao extends JpaRepository<ServiceRequest, Integer> {

}
