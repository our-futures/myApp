package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	
	 @Id
	 @Column(name = "id")
	 private int id;
	 
	 //用户id
	 @Column(name = "userid")
	 private int userid;
	 
	 //收件人
	 @Column(name = "name")
	 private String name;
	 
	 //收件人手机号码
	 @Column(name = "phone")
	 private String phone;
	 
	 //省份
	 @Column(name = "province")
	 private String province;
	 
	 //城市
	 @Column(name = "city")
	 private String city;
	 
	 //区县
	 @Column(name = "area")
	 private String area;
	 
	 //详细地址
	 @Column(name = "detail")
	 private String detail;
	 
	 //地址是否默认
	 @Column(name = "state")
	 private int state;
	 
	 //操作时间
	 @Column(name = "operatetime")
	 private Date operatetime;
	 
	 //操作ip
	 @Column(name = "operateip")
	 private String operateip;
	 

	 

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getOperatetime() {
		return operatetime;
	}

	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}

	public String getOperateip() {
		return operateip;
	}

	public void setOperateip(String operateip) {
		this.operateip = operateip;
	}
	 
}
