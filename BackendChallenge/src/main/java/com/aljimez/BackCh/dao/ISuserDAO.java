package com.aljimez.BackCh.dao;
/*Imports*/

import org.springframework.data.jpa.repository.JpaRepository;

import com.aljimez.BackCh.dto.Suser;
//Funciones que aplican a User
public interface ISuserDAO extends JpaRepository<Suser, Long> {
	Suser findByUsername(Object username);
}
