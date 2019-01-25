package com.kgc.dao.impl;

import com.kgc.dao.BaseDao;
import com.kgc.dao.NewsCategoryDao;
import com.kgc.pojo.NewsCategory;


public class NewsCategoryDaoImpl extends BaseDao implements NewsCategoryDao {
	//删除特定新闻类别
	public void deletCategory(NewsCategory category) {
		String sql = "delete from news_category where id=?";
		Object[] params = {category.getId()};
		if(this.getConnection()){
			try{
				int count = this.executeUpdate(sql, params);
				if(count>0){
					System.out.println("delete category success!");
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				this.closeResource();
			}
		}
	}

}
