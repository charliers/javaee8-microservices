package br.com.nhti.services.ws.api.model;

import java.math.BigInteger;

public class User {

	private BigInteger id;
	private String name;
	private String role;
	
	public User() {
		super();
	}

	public User(BigInteger id, String name, String role){
		this.id = id;
		this.name = name;
		this.role = role;
	}

	public BigInteger getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
}
