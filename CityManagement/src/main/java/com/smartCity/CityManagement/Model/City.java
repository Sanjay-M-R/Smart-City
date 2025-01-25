package com.smartCity.CityManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table

public class City {
	private String Name;
	@Id
	private int Pincode;
	private String Department;
}
