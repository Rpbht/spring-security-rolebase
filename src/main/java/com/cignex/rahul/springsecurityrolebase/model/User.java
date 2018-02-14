package com.cignex.rahul.springsecurityrolebase.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "user_tbl")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty(message = "please provide an email")
	private String email;

	@NotEmpty(message = "please provide password")
	private String password;

	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Collection<Role> role = new ArrayList<>();
	
	public User() {}

	public User(long id,
			@NotEmpty(message = "please provide an email") @Email(message = "please provide a valid email") String email,
			@NotEmpty(message = "please provide password") @Length(max = 5, message = "your password must be atleast 5 character") String password,
			Collection<Role> role) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Role> getRole() {
		return role;
	}

	public void setRole(Collection<Role> role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", role=" + role + "]";
	}
}
