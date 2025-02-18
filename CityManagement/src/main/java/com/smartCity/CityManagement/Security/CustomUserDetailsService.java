package com.smartCity.CityManagement.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smartCity.CityManagement.Dao.UsersDao;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UsersDao usersDao;
	
	
	public CustomUserDetailsService(UsersDao usersDao) {
		this.usersDao = usersDao;
	}


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return usersDao.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
	}

}
