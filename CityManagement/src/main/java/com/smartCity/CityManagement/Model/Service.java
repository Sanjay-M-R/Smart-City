package com.smartCity.CityManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Service {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int Id;
	 private String Name;
	 private String Department;
	 private String Type;
	 private String Status;
	 private String city;

}
