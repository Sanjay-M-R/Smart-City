package com.smartCity.CityManagement.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartCity.CityManagement.Model.Department;

@Repository

public interface DepartmentDao extends JpaRepository<Department, Integer> {

}
