package com.aljimez.BackCh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aljimez.BackCh.dto.Suser;

public interface ISuserDAO extends JpaRepository<Suser, Long> {
	Suser findByUsername(Object username);
}
