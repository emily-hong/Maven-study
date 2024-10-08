package com.service.spring.dao;

import java.util.List;
import java.util.Arrays;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;

@Repository
public class PhoneDAO {
	@Autowired
	private SqlSession sqlSession;
	public static final String NS = "ns.sql.Phone.";
	
	// selectUser
	public UserInfo selectUser(UserInfo vo) {
		UserInfo uvo = sqlSession.selectOne(NS+"selectUser", vo);
		return uvo;
	}
	// insert
	public int insert(Phone vo) {
		return sqlSession.insert(NS+"insert", vo);
	}
	// select
	public List<Phone> select(){
		List<Phone> list = sqlSession.selectList(NS+"select");
		return list;
	}
	// delete
	public int delete(String[] list) {
		List<String> numList = Arrays.asList(list); // 배열을 리스트로 변환
		return sqlSession.delete(NS+"delete", numList);
	}
	// update
	public int update(Phone vo) {
		return sqlSession.update(NS+"update", vo);
	}
}
