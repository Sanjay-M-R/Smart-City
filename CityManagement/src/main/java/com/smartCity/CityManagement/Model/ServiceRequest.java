package com.smartCity.CityManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "Requests")
public class ServiceRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Name;
	private String Description;
	@ManyToOne
	@JoinColumn(name = "user_email",referencedColumnName = "email")
	private Users requestedBy;
	@ManyToOne
	@JoinColumn(name = "department_id",referencedColumnName = "id")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name ="city_id",referencedColumnName = "id")
	private City city;
	private String Type;
	private String status;
	
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	

	public void setDepartment(Department department) {
		this.department = department;
	}


	public Department getDepartment() {
		return department;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}


	public void setRequestedBy(Users requestedBy) {
		this.requestedBy = requestedBy;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String Status) {
		status = Status;
	}

	

}
