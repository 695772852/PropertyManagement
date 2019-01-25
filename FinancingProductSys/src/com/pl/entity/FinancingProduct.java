package com.pl.entity;
/**
 * 理财产品实体类
 * @author PLFEIGN
 *
 */
public class FinancingProduct {
	private String id; //产品编号
	private int  risk; //风险评级
	private String income;//预期收入
	private String saleStarting;//发售起始日期
	private String saleEnd;//发售结束日期
	private String end;//产品到期日期
	public FinancingProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FinancingProduct(String id, int risk, String income, String saleStarting, String saleEnd, String end) {
		super();
		this.id = id;
		this.risk = risk;
		this.income = income;
		this.saleStarting = saleStarting;
		this.saleEnd = saleEnd;
		this.end = end;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRisk() {
		return risk;
	}
	public void setRisk(int risk) {
		this.risk = risk;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getSaleStarting() {
		return saleStarting;
	}
	public void setSaleStarting(String saleStarting) {
		this.saleStarting = saleStarting;
	}
	public String getSaleEnd() {
		return saleEnd;
	}
	public void setSaleEnd(String saleEnd) {
		this.saleEnd = saleEnd;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "FinancingProduct [id=" + id + ", risk=" + risk + ", income=" + income + ", saleStarting=" + saleStarting
				+ ", saleEnd=" + saleEnd + ", end=" + end + "]";
	}
    
}
