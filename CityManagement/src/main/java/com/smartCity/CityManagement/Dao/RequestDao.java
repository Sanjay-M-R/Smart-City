package com.smartCity.CityManagement.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartCity.CityManagement.Model.ServiceRequest;
import com.smartCity.CityManagement.Model.Users;

@Repository
public interface RequestDao extends JpaRepository<ServiceRequest, Integer> {


	List<ServiceRequest> findByRequestedBy(Users currentUser);

	List<ServiceRequest> findByStatus(String Status);


}
