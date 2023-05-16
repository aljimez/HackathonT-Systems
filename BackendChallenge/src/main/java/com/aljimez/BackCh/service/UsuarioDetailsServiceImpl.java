package com.aljimez.BackCh.service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aljimez.BackCh.dao.ISuserDAO;
import com.aljimez.BackCh.dto.Suser;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

	private ISuserDAO iSUserDAO;

	public UsuarioDetailsServiceImpl(ISuserDAO iUsuarioDAO) {
		this.iSUserDAO = iUsuarioDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Suser suser = iSUserDAO.findByUsername(username);
		if (suser == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(suser.getUsername(), suser.getPassword(), mapRolesToAuthorities(suser.getRole()));
	}

	private Collection<GrantedAuthority> mapRolesToAuthorities(String rol) {
		ArrayList<String> roles = new ArrayList<String>();
		roles.add(rol);
		return roles.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
	}

}
