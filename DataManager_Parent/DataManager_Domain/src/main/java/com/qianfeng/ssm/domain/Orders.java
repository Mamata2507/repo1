package com.qianfeng.ssm.domain;

import java.util.Date;
import java.util.List;

import com.qianfeng.ssm.utils.DateToStringConvert;

public class Orders {
	
	private String id; 
	private String orderNum; 
	private Date orderTime;
	private String orderTimeStr;
	private int orderStatus;
	private String orderStatusStr;
	private int peopleCount;
	private Product product;
	private List<Traveller> travellers; 
	private Member member;
	private Integer payType; 
	private String payTypeStr;
	private String orderDesc;
	
	
	
	public Orders() {
		super();
	}



	


	public Orders(String id, String orderNum, Date orderTime, String orderTimeStr, int orderStatus,
			String orderStatusStr, int peopleCount, Product product, List<Traveller> travellers, Member member,
			Integer payType, String payTypeStr, String orderDesc) {
		super();
		this.id = id;
		this.orderNum = orderNum;
		this.orderTime = orderTime;
		this.orderTimeStr = orderTimeStr;
		this.orderStatus = orderStatus;
		this.orderStatusStr = orderStatusStr;
		this.peopleCount = peopleCount;
		this.product = product;
		this.travellers = travellers;
		this.member = member;
		this.payType = payType;
		this.payTypeStr = payTypeStr;
		this.orderDesc = orderDesc;
	}






	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getOrderNum() {
		return orderNum;
	}



	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}



	public Date getOrderTime() {
		return orderTime;
	}



	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}



	public String getOrderTimeStr() {
		if(orderTime != null) {
			orderTimeStr = DateToStringConvert.dateToString(orderTime, "yyyy-MM-dd HH:mm");
		}
		return orderTimeStr;
	}



	public void setOrderTimeStr(String orderTimeStr) {
		this.orderTimeStr = orderTimeStr;
	}



	public int getOrderStatus() {
		return orderStatus;
	}



	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}



	public int getPeopleCount() {
		return peopleCount;
	}



	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public List<Traveller> getTravellers() {
		return travellers;
	}



	public void setTravellers(List<Traveller> travellers) {
		this.travellers = travellers;
	}



	public Member getMember() {
		return member;
	}



	public void setMember(Member member) {
		this.member = member;
	}



	public Integer getPayType() {
		return payType;
	}



	public void setPayType(Integer payType) {
		this.payType = payType;
	}



	public String getPayTypeStr() {
		if(payType == 0) {
			payTypeStr = "支付宝";
		}
		if(payType == 1) {
			payTypeStr = "微信";
		}
		if(payType == 2) {
			payTypeStr = "其他";
		}
		return payTypeStr;
	}



	public void setPayTypeStr(String payTypeStr) {
		this.payTypeStr = payTypeStr;
	}



	public String getOrderDesc() {
		return orderDesc;
	}



	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}






	public String getOrderStatusStr() {
		if(orderStatus == 0) {
			orderStatusStr = "未支付";
		}
		
		if(orderStatus == 1) {
			orderStatusStr = "已支付";
		}
		return orderStatusStr;
	}






	public void setOrderStatusStr(String orderStatusStr) {
		this.orderStatusStr = orderStatusStr;
	}






	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderNum=" + orderNum + ", orderTime=" + orderTime + ", orderTimeStr="
				+ orderTimeStr + ", orderStatus=" + orderStatus + ", orderStatusStr=" + orderStatusStr
				+ ", peopleCount=" + peopleCount + ", product=" + product + ", travellers=" + travellers + ", member="
				+ member + ", payType=" + payType + ", payTypeStr=" + payTypeStr + ", orderDesc=" + orderDesc + "]";
	}



	
	
	
	
	
	



}
