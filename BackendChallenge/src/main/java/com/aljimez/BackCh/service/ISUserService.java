package com.aljimez.BackCh.service;

import java.util.List;

import com.aljimez.BackCh.dto.Suser;


public interface ISUserService {

	public List<Suser> listUsers(); /**Get: List all users */
	
	public Suser saveUser(Suser user); /**Create: Save an user */

	public Suser getUserById(Long id); /**Get: Read info about an user */

	public Suser updateUser(Suser user);/**Update: an user */

	public void deleteUser(Long id);/** Delete: an user*/
}
