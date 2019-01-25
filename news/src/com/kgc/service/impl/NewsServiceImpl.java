package com.kgc.service.impl;

import java.util.List;

import com.kgc.dao.NewsDao;
import com.kgc.dao.impl.NewsDaoImpl;
import com.kgc.pojo.News;
import com.kgc.service.NewsService;

public class NewsServiceImpl implements NewsService {
	private NewsDao newsDao = null;
	
	public NewsServiceImpl(){
		newsDao = new NewsDaoImpl();
	}

	public List<News> getNewsList() {
		return newsDao.getNewsList();
	}
	
	// 增加新闻信息
	public boolean add(News news) {
		return newsDao.add(news);
	}
	
	public News getNewsById(int id) {
		// TODO Auto-generated method stub
		return newsDao.getNewsById(id);
	}
}
