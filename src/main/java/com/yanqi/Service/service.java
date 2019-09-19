package com.yanqi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanqi.Dao.Dao;

@Service
public class service {

	@Autowired
	Dao dao;
	
	public String getUserName(String ID){
		return dao.getUserName(ID);
	}
	
	public String getUserName1(String ID){
		return dao.getUserName1(ID);
	}
}
