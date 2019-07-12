package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class IndexController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	@RequestMapping("/datagrid1")
	public String datagrid1() {
		return "datagrid1";
	}
	@RequestMapping("/title")
	public String title() {
		return "title";
	}
	@RequestMapping("/article")
	public String article() {
		return "article";
	}
}
