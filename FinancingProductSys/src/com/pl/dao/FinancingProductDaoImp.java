package com.pl.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pl.entity.FinancingProduct;
/**
 * 
 * @author PLFEIGN
 *
 */
public class FinancingProductDaoImp extends BaseDao implements FinancingProductDao {

	@Override
	public List<FinancingProduct> selectFinancing(FinancingProduct fp) {
		ArrayList<FinancingProduct> arrE =  new ArrayList<FinancingProduct>();
		String sql = "select *from financingproduct f where 1=1";
		StringBuffer sb = new StringBuffer(sql);
		/*String fpId = fp.getId();
		int fpRisk = fp.getRisk();*/
		try {
//		   if(fpId!=null) {
//				
//				sb.append(" and f.id = ?");
//				rs = executeQuery(sb.toString(),fpId);
//			}else
//			if(fpRisk!=0) {
//				sb.append(" and f.risk=?");
//				rs = executeQuery(sb.toString(),fpRisk);
//			}else {
				rs = executeQuery(sb.toString());
			//}
			
			
			while(rs.next()) {
				FinancingProduct f = new  FinancingProduct();
				f.setId(rs.getString("id"));
				f.setRisk(rs.getInt("risk"));
		        f.setIncome(rs.getString("income"));
		        f.setSaleStarting(rs.getString("saleStarting"));
				f.setSaleEnd(rs.getString("saleEnd"));
				f.setEnd(rs.getString("end"));
				arrE.add(f);
			}
		   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return arrE;
		
	}

	@Override
	public String addFinancing(FinancingProduct fp) {
		// TODO Auto-generated method stub
		return null;
	}

}
