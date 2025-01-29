package com.smartCity.CityManagement.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class ServiceRequest {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int Id;
	 private String Name;
	 @ManyToMany
	 @JoinTable(name = "Service_Department",joinColumns = @JoinColumn(referencedColumnName = "Id"),inverseJoinColumns = @JoinColumn(referencedColumnName = "Id"))
	 private List<Department> department;
	 private String Type;
	 private String Status;
	 @ManyToOne
	 @JoinColumn(name = "City_Id")
	 private City city;

}
