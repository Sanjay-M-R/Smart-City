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
	private String Description;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users requestedBy;
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	public void setDepartment(Department department) {
		this.department = department;
	}

	private String Type;
	private String Status;

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

	public Users getRequestedBy() {
		return requestedBy;
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
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@ManyToOne
	@JoinColumn(name = "City_Id")
	private City city;

}
