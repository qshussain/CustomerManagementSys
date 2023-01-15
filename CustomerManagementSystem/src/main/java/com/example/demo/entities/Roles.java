package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Roles_Table")
public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
    private int roles_id;
	private String CA_role="ca";
	private String admin_role="admin";
	private String user_role="user";
	private String manager_role="manager";
	
	public int getRoles_id() {
		return roles_id;
	}
	public void setRoles_id(int roles_id) {
		this.roles_id = roles_id;
	}
	public String getCA_role() {
		return CA_role;
	}
	public void setCA_role(String cA_role) {
		CA_role = cA_role;
	}
	public String getAdmin_role() {
		return admin_role;
	}
	public void setAdmin_role(String admin_role) {
		this.admin_role = admin_role;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	public String getManager_role() {
		return manager_role;
	}
	public void setManager_role(String manager_role) {
		this.manager_role = manager_role;
	}
	
	
	
	
	}
	


