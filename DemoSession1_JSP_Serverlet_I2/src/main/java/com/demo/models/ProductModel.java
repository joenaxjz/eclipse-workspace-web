package com.demo.models;

import com.demo.entities.Product;

import java.util.ArrayList;
import java.util.List;

import com.demo.entities.Category;

public class ProductModel {
	public  Product find() {
		return new Product(1, "Name 1", 5.6, 2, false, "pic2.jpg",
				new Category(1, "cate 1")
				);
	}
	
	public static List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, "Name 1", 5.6, 2, false, "pic1.jpg", new Category(1, "cate 1")));
		products.add(new Product(2, "Name 2", 5.6, 2, false, "pic2.jpg", new Category(1, "cate 2")));
		products.add(new Product(3, "Name 3", 5.6, 2, false, "pic3.jpg", new Category(1, "cate 3")));
		return products;
	}
	
	public static Product	findId(int id) {
		List<Product> products = findAll();
		for(Product product : products) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	} 
	
}
