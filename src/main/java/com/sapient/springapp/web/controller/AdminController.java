package com.sapient.springapp.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin")
@RestController
public class AdminController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String list() {
		String msg = "Access to admin page granted!"; 
		return msg;
	}
	
}
