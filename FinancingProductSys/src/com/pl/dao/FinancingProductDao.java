package com.pl.dao;

import java.util.List;

import com.pl.entity.FinancingProduct;

/**
 * 
 * @author PLFEIGN
 *
 */
public interface FinancingProductDao {
    //��ѯ�����Ϣ
	public List<FinancingProduct> selectFinancing(FinancingProduct fp);
	//���ݲ�Ʒ�����ѯ�����Ϣ��¼�������жϲ�Ʒ�����Ƿ��ظ�
	
	//ʵ�������ƹ���
	public String addFinancing(FinancingProduct fp);
}
