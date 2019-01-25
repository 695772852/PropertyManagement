package com.kgc.dao;

import com.kgc.pojo.NewsCategory;

public interface NewsCategoryDao {
	//删除特定新闻类别
	public void deletCategory(NewsCategory category);
}
