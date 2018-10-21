package com.mochijump.leveleditor;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserPrincipal implements UserDetails {
	
	private User user;
	
	private PasswordEncoder encoder =  new BCryptPasswordEncoder(11);
	
	public UserPrincipal (User user) {
		this.user = user;
	}

	@Override
	public String getPassword() {
		// this needs to be implemented in the entity class not here okay to use now for testing
		String encodedPass = encoder.encode(user.getPassword());
		return encodedPass;
	}

	@Override
	public String getUsername() {
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		if (user.getIsAccountNonLocked()) {
			return true;
		}else {
		return false;
		}
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

}
