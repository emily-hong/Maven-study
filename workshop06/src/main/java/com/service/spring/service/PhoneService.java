package com.service.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.PhoneDAO;
import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;

@Service
public class PhoneService {
	@Autowired
	PhoneDAO phoneDAO;
	
	// selectUser
	public UserInfo selectUser(UserInfo vo) {
		UserInfo uvo = phoneDAO.selectUser(vo);
		return uvo;
	}
	
	// insert
	public int insert(Phone vo) {
		return phoneDAO.insert(vo);
	}
	// select
	public List<Phone> select(){
		List<Phone> list = phoneDAO.select();
		return list;
	}
	// delete
	public int delete(String[] list) {
		return phoneDAO.delete(list);
	}
	// update
	public int update(Phone vo) {
		return phoneDAO.update(vo);
	}
	
}
