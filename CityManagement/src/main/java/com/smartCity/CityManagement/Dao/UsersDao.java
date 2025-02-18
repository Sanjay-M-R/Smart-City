package com.smartCity.CityManagement.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartCity.CityManagement.Model.Users;
@Repository
public interface UsersDao extends JpaRepository<Users, Integer> {

	 Optional<Users> findByEmail(String email);
	    boolean existsByEmail(String email);

}
