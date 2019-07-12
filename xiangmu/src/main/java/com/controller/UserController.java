package com.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.UserService;





@RestController
@RequestMapping("/util")
public class UserController {
	 @Autowired
	 UserService userservice;
	@RequestMapping("/checkName")
	//验证用户是否存在
	public String  checkName(HttpServletRequest request, HttpServletResponse response ) throws Exception{
		 if (userservice.checkName(request, response) == null) {
	            return "false";
	        } else {
	            return "true";
	        }
	}
	//验证用户是否正确
	@RequestMapping("/checkUser")
	public String  checkUser(HttpServletRequest request, HttpServletResponse response ) throws Exception{
		 if (userservice.checkUser(request, response) == null) {
	            return "false";
	        } else {
	            return "true";
	        }
	}
	//保存用户信息
		@RequestMapping("/saveUser")
	public String saveUser(HttpServletRequest request,HttpServletResponse response) throws Exception{
		if(userservice.saveUser(request, response)==1) {
		 return "true";
	              }
		else {return "false";}
      } 
}