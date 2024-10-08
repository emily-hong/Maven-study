package com.service.spring;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.service.PhoneService;

public class DIUnitTest {
	
	// myBatis와 DI연동 부분의 단위테스트.. 빈 설정문서를 읽어야 한다.
	ApplicationContext factory = 
			new ClassPathXmlApplicationContext("/beans/businessBean.xml"); // 설정문서 여러개 -> new String[]
	
	PhoneService service= (PhoneService) factory.getBean("phoneService");
	
	// insert, select, delete update
//	@Test
//	public void insert() throws Exception {
//		UserInfo user = new UserInfo("admin", "admin");
//		
//		Phone pvo = new Phone();
//		// "A50SW", "아이폰7", 1300000, "30"
//		pvo.setNum("A50SA");
//		pvo.setModel("아이폰7");
//		pvo.setPrice(1700000);
//		pvo.setVcode("30");
//		
//		int result=service.insert(pvo);
//		System.out.println("result : "+result);
//	}
	
//	@Test
//	public void select() throws Exception{
//		List<Phone> list = service.select();
//		for(Phone p : list) System.out.println(p);
//	}
	
	// 선택항목 삭제 비동기 처리 되어있음
	@Test
	public void delete() throws Exception{
		String[] list = {"A50SZ", "A50SW"};
		
		int result = service.delete(list);
		System.out.println("delete : " + result);
	}
	
//	@Test
//	public void update() throws Exception{
//		Phone pvo = new Phone("A50SW", "아이폰수정", 1300000, "30");
//		
//		int result = service.update(pvo);
//		System.out.println("update : " + result);
//	}

	
	

}