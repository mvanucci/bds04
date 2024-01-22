package com.devsuperior.bds04.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	
	Set<RoleDTO> roles = new HashSet<>();
	
	public UserDTO() {}
	public UserDTO(Long id, String email) {
		this.id = id;
		this.email = email;
	}
	
	public Set<RoleDTO> getRoles() {
		return roles;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
