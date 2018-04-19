package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
public class Brand {
	
	 @Id
	 @Column(name = "brandid")
	 private int brandId;
	 
	 @Column(name = "menuid")
	 private String menuId;
	  
	 @Column(name = "brandchinaname")
	 private String brandChinaName;
	 
	 @Column(name = "brandenglishname")
	 private String brandEnglishName;
	 
	 @Column(name = "brandtext")
	 private String brandText;
	 
	 @Column(name = "brandlogo")
	 private String brandLogo;
	 
	 @Column(name = "state")
	 private String state;
	 
	 @Column(name = "brandaddress")
	 private String brandAddress;
	 
	 @Column(name = "brandstory")
	 private String brandStory;
	 
	 @Column(name = "brandbuildtime")
	 private Date brandBuildTime;

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getBrandChinaName() {
		return brandChinaName;
	}

	public void setBrandChinaName(String brandChinaName) {
		this.brandChinaName = brandChinaName;
	}

	public String getBrandEnglishName() {
		return brandEnglishName;
	}

	public void setBrandEnglishName(String brandEnglishName) {
		this.brandEnglishName = brandEnglishName;
	}

	public String getBrandText() {
		return brandText;
	}

	public void setBrandText(String brandText) {
		this.brandText = brandText;
	}

	public String getBrandLogo() {
		return brandLogo;
	}

	public void setBrandLogo(String brandLogo) {
		this.brandLogo = brandLogo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBrandAddress() {
		return brandAddress;
	}

	public void setBrandAddress(String brandAddress) {
		this.brandAddress = brandAddress;
	}

	public String getBrandStory() {
		return brandStory;
	}

	public void setBrandStory(String brandStory) {
		this.brandStory = brandStory;
	}

	public Date getBrandBuildTime() {
		return brandBuildTime;
	}

	public void setBrandBuildTime(Date brandBuildTime) {
		this.brandBuildTime = brandBuildTime;
	}
	 
	 

}
