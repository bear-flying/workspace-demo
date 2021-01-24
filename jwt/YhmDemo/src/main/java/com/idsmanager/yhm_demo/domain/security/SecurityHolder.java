package com.idsmanager.yhm_demo.domain.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface SecurityHolder {
	UserDetails userDetails();
	
	String username();
}
