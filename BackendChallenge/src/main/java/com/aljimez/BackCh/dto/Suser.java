package com.aljimez.BackCh.dto;
/*Imports*/

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "susers")
public class Suser {
//Obtener datos de tabla Users de BBDD
	// ----------------- Atributes -----------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	

	

	@Column(name = "role")
	private String role;

	

	// ----------------- Constructors -----------------
	/**
	 * Default Constructor
	 */
	public Suser() {

	}

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param email
	 * @param nomApels
	 * @param role
	 */
	public Suser(Long id, String username, String password,  String role
			) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;

		this.role = role;
	}

	// ----------------- Getters + Setters -----------------
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	


	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	// ----------------- Methods -----------------

	

}
