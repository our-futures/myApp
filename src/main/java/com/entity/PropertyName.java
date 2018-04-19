package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "property_name")
public class PropertyName {

	 @Id
	 @Column(name = "propertynameid")
	 private int propertyNameId;
	 
	 @Column(name = "menuid")
	 private int menuId;
	 
	 @Column(name = "propertyname")
	 private String propertyName;
	 
	 @Column(name = "isnickname")
	 private String isNickName;
	 
	 @Column(name = "iscolor")
	 private String isColor;
	 
	 //是否是枚举属性
	 @Column(name = "ismj")
	 private String isMj;
	 
	 @Column(name = "isinput")
	 private String isInput;
	 
	 @Column(name = "ismain")
	 private String isMain;
	 
	 //是否销售属性
	 @Column(name = "isshop")
	 private String isShop;
	 
	 //是否搜索属性
	 @Column(name = "issearch")
	 private String isSearch;
	 
	 //是否必须属性
	 @Column(name = "isrequest")
	 private String isRequest;
	 
	 //是否多选属性
	 @Column(name = "ischeckbox")
	 private String isCheckBox;
	 
	 @Column(name = "state")
	 private String state;
	 
	 //排序规则
	 @Column(name = "order")
	 private String order;
	 
	 @Column(name = "buildtime")
	 private Date buildTime;

	public int getPropertyNameId() {
		return propertyNameId;
	}

	public void setPropertyNameId(int propertyNameId) {
		this.propertyNameId = propertyNameId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getIsNickName() {
		return isNickName;
	}

	public void setIsNickName(String isNickName) {
		this.isNickName = isNickName;
	}

	public String getIsColor() {
		return isColor;
	}

	public void setIsColor(String isColor) {
		this.isColor = isColor;
	}

	public String getIsMj() {
		return isMj;
	}

	public void setIsMj(String isMj) {
		this.isMj = isMj;
	}

	public String getIsInput() {
		return isInput;
	}

	public void setIsInput(String isInput) {
		this.isInput = isInput;
	}

	public String getIsMain() {
		return isMain;
	}

	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}

	public String getIsShop() {
		return isShop;
	}

	public void setIsShop(String isShop) {
		this.isShop = isShop;
	}

	public String getIsSearch() {
		return isSearch;
	}

	public void setIsSearch(String isSearch) {
		this.isSearch = isSearch;
	}

	public String getIsRequest() {
		return isRequest;
	}

	public void setIsRequest(String isRequest) {
		this.isRequest = isRequest;
	}

	public String getIsCheckBox() {
		return isCheckBox;
	}

	public void setIsCheckBox(String isCheckBox) {
		this.isCheckBox = isCheckBox;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Date getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
	 
	 
}
