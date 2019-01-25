package com.kgc.service;

import com.kgc.pojo.NewsCategory;

public interface NewsCategoryService {
	//删除特定新闻类别
	public void deletCategory(NewsCategory category);
}