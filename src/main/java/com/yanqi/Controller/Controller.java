package com.yanqi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yanqi.Service.service;

@RestController
public class Controller {

	@Autowired
	service service;
	
	@RequestMapping(value = "/getUserName", method = RequestMethod.GET)
	public String getUserName(String ID){
		return service.getUserName(ID);
	}
	
	@RequestMapping(value = "/getUserName1", method = RequestMethod.GET)
	public String getUserName1(String ID){
		return service.getUserName1(ID);
	}
}
