/**
 * Project Name:Express
 * File Name:BillInfo.java
 * Package Name:com.cstor.express.model
 * Date:2016年11月23日上午9:25:03
 * Copyright (c) 2016, douyoubin@cstor.com All Rights Reserved.
 *
*/

package com.cstor.express.model;

import java.util.Date;

/**
 * ClassName:BillInfo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月23日 上午9:25:03 <br/>
 * @author   douyoubin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class BillInfo {
	
	private int id;
	private String bill;
	private String senderPhone;
	private String recievePhone;
	private String recieveName;
	private String senderName;
	private String sex;
	private String nation;
	private String birthday;
	private String addr;
	private String idcard;
	private String revieveAddr;
	private String idImg;
	private String goodImg;
	private String billImg;
	private Date createDate;
	private Date updateDate;
	
	
	
	
	public BillInfo(String bill, String senderPhone, String recievePhone,
			String recieveName, String senderName, String sex, String nation,
			String birthday, String addr, String idcard,String revieveAddr, String idImg,
			String goodImg, String billImg, Date createDate, Date updateDate) {
		super();
		this.bill = bill;
		this.senderPhone = senderPhone;
		this.recievePhone = recievePhone;
		this.recieveName = recieveName;
		this.senderName = senderName;
		this.sex = sex;
		this.nation = nation;
		this.birthday = birthday;
		this.addr = addr;
		this.idcard = idcard;
		this.revieveAddr = revieveAddr;
		this.idImg = idImg;
		this.goodImg = goodImg;
		this.billImg = billImg;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	public BillInfo(int id, String bill, String senderPhone,
			String recievePhone, String recieveName, String senderName,
			String sex, String nation, String birthday, String addr,
			String idcard, String revieveAddr, String idImg, String goodImg, String billImg,
			Date createDate, Date updateDate) {
		super();
		this.id = id;
		this.bill = bill;
		this.senderPhone = senderPhone;
		this.recievePhone = recievePhone;
		this.recieveName = recieveName;
		this.senderName = senderName;
		this.sex = sex;
		this.nation = nation;
		this.birthday = birthday;
		this.addr = addr;
		this.idcard = idcard;
		this.revieveAddr = revieveAddr;
		this.idImg = idImg;
		this.goodImg = goodImg;
		this.billImg = billImg;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	public BillInfo() {
		
		super();
		// TODO Auto-generated constructor stub
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBill() {
		return bill;
	}
	public void setBill(String bill) {
		this.bill = bill;
	}
	public String getSenderPhone() {
		return senderPhone;
	}
	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}
	public String getRecievePhone() {
		return recievePhone;
	}
	public void setRecievePhone(String recievePhone) {
		this.recievePhone = recievePhone;
	}
	public String getRecieveName() {
		return recieveName;
	}
	public void setRecieveName(String recieveName) {
		this.recieveName = recieveName;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getRevieveAddr() {
		return revieveAddr;
	}
	public void setRevieveAddr(String revieveAddr) {
		this.revieveAddr = revieveAddr;
	}
	public String getIdImg() {
		return idImg;
	}
	public void setIdImg(String idImg) {
		this.idImg = idImg;
	}
	public String getGoodImg() {
		return goodImg;
	}
	public void setGoodImg(String goodImg) {
		this.goodImg = goodImg;
	}
	public String getBillImg() {
		return billImg;
	}
	public void setBillImg(String billImg) {
		this.billImg = billImg;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
		
	
	
	
}

