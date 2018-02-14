package com.cignex.rahul.springsecurityrolebase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cignex.rahul.springsecurityrolebase.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByRole(String role);
	
}
