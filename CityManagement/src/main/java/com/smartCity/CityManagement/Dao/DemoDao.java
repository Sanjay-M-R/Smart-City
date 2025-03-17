package com.smartCity.CityManagement.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.smartCity.CityManagement.Model.Demo;

public interface DemoDao extends MongoRepository<Demo, Integer> {

}
