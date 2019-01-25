package com.pl.dao;

import java.util.List;

import com.pl.entity.FinancingProduct;

/**
 * 
 * @author PLFEIGN
 *
 */
public interface FinancingProductDao {
    //查询理财信息
	public List<FinancingProduct> selectFinancing(FinancingProduct fp);
	//根据产品代码查询理财信息记录数，以判断产品代码是否重复
	
	//实现添加理财功能
	public String addFinancing(FinancingProduct fp);
}
