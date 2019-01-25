package com.pl.service;

import java.util.List;

import com.pl.dao.FinancingProductDao;
import com.pl.dao.FinancingProductDaoImp;
import com.pl.entity.FinancingProduct;

public class FinancingProductServiceImp implements FinancingProductService {

	@Override
	public List<FinancingProduct> getAll() {
		FinancingProductDao fpd = new FinancingProductDaoImp();
		return fpd.selectFinancing(null);
	}

}
