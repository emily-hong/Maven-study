package com.services.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.MyProduct;

public class MyBatisJUnitTest {
	@Test
	public void unit() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
			
		SqlSession session = factory.openSession();
		
		MyProduct myproduct = new MyProduct("냉장고", "LG", 10000);
		//addProduct
//		session.insert("ns.sql.MyProductMapper.addProduct", myproduct);
//		session.commit();
		
		// findProductByName
		List<MyProduct> listByName = session.selectList("ns.sql.MyProductMapper.findProducts", "장고");
		for(MyProduct i : listByName) System.out.println(i);
		
		// findProductByMaker
//		List<MyProduct> listByMaker = session.selectList("ns.sql.MyProductMapper.findProducts", "G");
//		for(MyProduct i : listByMaker) System.out.println(i);
		
		// findProducts
//		List<MyProduct> list = session.selectList("ns.sql.MyProductMapper.findProducts");
//		for(MyProduct i : list) System.out.println(i);
		
	}
}
