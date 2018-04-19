package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class Card {
	 @Id
	 @Column(name = "id")
	 private int id;
	 
	 //用户id
	 @Column(name = "userid")
	 private int userid;
	 
	 
	 //银行卡名称
	 @Column(name = "bankname")
	 private String bankname;
	 
	 //银行卡号
	 @Column(name = "banknumber")
	 private String banknumber;
	 
	 //添加时间
	 @Column(name = "addtime")
	 private Date addtime;
	 
	 //是否启用
	 @Column(name = "isuse")
	 private int isuse;
	 
	 //姓名
	 @Column(name = "name")
	 private String name;
	 
	 //用户身份证
	 @Column(name = "cardid")
	 private String cardid;
	 
	 //预留手机号码
	 @Column(name = "phone")
	 private String phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBanknumber() {
		return banknumber;
	}

	public void setBanknumber(String banknumber) {
		this.banknumber = banknumber;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public int getIsuse() {
		return isuse;
	}

	public void setIsuse(int isuse) {
		this.isuse = isuse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	 
	
}
