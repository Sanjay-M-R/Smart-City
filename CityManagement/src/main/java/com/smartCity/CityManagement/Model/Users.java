package com.smartCity.CityManagement.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Users implements UserDetails {
	
	private String Name;
	private String Gender;
	private int Age;
	
	@Id
	@Column(unique = true)
	private String email;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
	

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userRole.name()));
        return authorities;
    }
	
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		
		return email;
	}
}