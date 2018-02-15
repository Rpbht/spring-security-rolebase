package com.cignex.rahul.springsecurityrolebase.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter
public class Filter2 implements FilterChain {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
		System.out.println("From Filter2:=>   " + request + "  ::  " + response);

	}

}
