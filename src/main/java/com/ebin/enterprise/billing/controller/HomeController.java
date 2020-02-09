package com.ebin.enterprise.billing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello() {
		return "welcome to spring boot application";
	}
}
