package com.cignex.rahul.springsecurityrolebase.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cignex.rahul.springsecurityrolebase.model.Role;
import com.cignex.rahul.springsecurityrolebase.model.User;
import com.cignex.rahul.springsecurityrolebase.service.UserService;
import com.cignex.rahul.springsecurityrolebase.utils.ConstantStrings;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String adminLogin(){
		return ConstantStrings.ADMIN_JSP;
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.GET)
	public String addUser(){
		
		Role roleObj = new Role();
		roleObj.setRole("ADMIN");
		
		ArrayList<Role> rList = new ArrayList<>();
		rList.add(roleObj);
		
		User userObj = new User();
		userObj.setEmail("rahul@gmail.com");
		userObj.setPassword("password");
		userObj.setRole(rList);
		
		userService.saveUser(userObj);
		
		return ConstantStrings.ADMIN_JSP;
	}
	
}
