package com.service.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.MyProduct;
import com.services.spring.dao.MyProductDAO;


@Service
public class MyProductCatalog {
	@Autowired
	private MyProductDAO myProductDAO;

	public void addProduct(MyProduct myProduct) throws Exception{
		myProductDAO.addProduct(myProduct);
	}
	public List<MyProduct> findProductByName(String  name) throws Exception{
		return myProductDAO.findProductByName(name);
	}
	public List<MyProduct> findProductByMaker(String  maker) throws Exception{
		return myProductDAO.findProductByMaker(maker);
	}
	public List<MyProduct> findProducts() throws Exception{
		return myProductDAO.findProducts();
	}
}
