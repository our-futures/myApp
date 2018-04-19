package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "goods")
public class Goods {
	
	 @Id
	 @Column(name = "goodsid")
	 private int goodsId;
	 
	 @Column(name = "menuid")
	 private int menuId;
	 
	 @Column(name = "brandid")
	 private int brandId;
	 
	 @Column(name = "number")
	 private int number;
	 
	 @Column(name = "goodstext")
	 private String goodsText;
	 
	 @Column(name = "price")
	 private String price;
	 
	 @Column(name = "buildtime")
	 private Date buildTime;

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getGoodsText() {
		return goodsText;
	}

	public void setGoodsText(String goodsText) {
		this.goodsText = goodsText;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
	 
	 

}
