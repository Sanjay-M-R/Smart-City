package com.smartCity.CityManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartCity.CityManagement.Dao.UsersDao;
import com.smartCity.CityManagement.Model.UserRole;
import com.smartCity.CityManagement.Model.Users;
import com.smartCity.CityManagement.Security.AuthenticationRequest;
import com.smartCity.CityManagement.Security.AuthenticationResponse;
import com.smartCity.CityManagement.Security.JwtService;

@Service

public class AuthenticationService {
	@Autowired
	UsersDao usersDao;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtService jwtService;
	@Autowired
	AuthenticationManager authenticationManager;

	public AuthenticationResponse register(Users user) {
		if (usersDao.findByEmail(user.getEmail()).isPresent()) {
			throw new RuntimeException("Email already exists");
		}
		user.setUserRole(UserRole.CITIZEN);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		usersDao.save(user);

		String jwtToken = jwtService.generateToken(user);
		return new AuthenticationResponse(jwtToken);

	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		Users user = usersDao.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));

		String jwtToken = jwtService.generateToken(user);
		return new AuthenticationResponse(jwtToken);
	}

}
