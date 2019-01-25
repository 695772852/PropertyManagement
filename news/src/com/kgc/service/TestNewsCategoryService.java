package com.kgc.service;

import com.kgc.pojo.NewsCategory;
import com.kgc.service.impl.NewsCategoryServiceImpl;


public class TestNewsCategoryService {
	
	//测试删除某个新闻类别
	public static void main(String[] args) {
		NewsCategory category = new NewsCategory();
		category.setId(7);
		NewsCategoryService service = new NewsCategoryServiceImpl();
		service.deletCategory(category);
	}

}
