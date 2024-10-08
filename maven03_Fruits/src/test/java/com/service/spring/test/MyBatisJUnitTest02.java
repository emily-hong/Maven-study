package com.service.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.Item;

// JUnit Test (main 안씀)
public class MyBatisJUnitTest02 {
	// Test import함
	@Test
	public void unit() throws Exception{
		//1. 설정문서읽음
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		//2
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		//3
		SqlSession session = factory.openSession();
		
		//4. 쿼리문 실행
		List<Item> list = session.selectList("ns.sql.FruitMapper.getItemList");
		for(Item i: list) System.out.println(i);
		
		System.out.println("==========================================");

	}
	@Test
	public void unit2() throws Exception{
		//1. 설정문서읽음
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		//2
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		//3
		SqlSession session = factory.openSession();
		// getItem
		Item item = session.selectOne("ns.sql.FruitMapper.getItem", 1111);
		System.out.println(item);
	}
}
