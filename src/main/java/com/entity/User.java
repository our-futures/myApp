package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "id")
	private int id;
	//登录名
	@Column(name = "name")
	private String name;
	//密码
	@Column(name = "pwd")
	private String pwd;
	//邮箱
	@Column(name = "email")
	private String email;
	//电话
	@Column(name = "phone")
	private String phone;
	//注册地址
	@Column(name = "registerip")
	private String registerip;
	//注册时间
	@Column(name = "registertime")
	private Date registertime;
	//最后一次登录时间
	@Column(name = "lastlogintime")
	private Date lastlogintime;
	//用户状态
	@Column(name = "state")
	private String state;
	//密码登录错误次数
	@Column(name = "errorpwdnum")
	private String errorpwdnum;
	//登录地址
	@Column(name = "loginip")
	private String loginip;
	//最后一次改变信息时间
	@Column(name = "lastchangetime")
	private Date lastchangetime;
	//支付密码
	@Column(name = "paypwd")
	private String paypwd;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRegisterip() {
		return registerip;
	}
	public void setRegisterip(String registerip) {
		this.registerip = registerip;
	}
	public Date getRegistertime() {
		return registertime;
	}
	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}
	public Date getLastlogintime() {
		return lastlogintime;
	}
	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getErrorpwdnum() {
		return errorpwdnum;
	}
	public void setErrorpwdnum(String errorpwdnum) {
		this.errorpwdnum = errorpwdnum;
	}
	public String getLoginip() {
		return loginip;
	}
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}
	public Date getLastchangetime() {
		return lastchangetime;
	}
	public void setLastchangetime(Date lastchangetime) {
		this.lastchangetime = lastchangetime;
	}
	public String getPaypwd() {
		return paypwd;
	}
	public void setPaypwd(String paypwd) {
		this.paypwd = paypwd;
	}
	
	

}
