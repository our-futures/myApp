package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "goods_sku")
public class GoodsSku {
	
	 @Id
	 @Column(name = "skuid")
	 private int skuId;
	 
	 @Column(name = "goodsid")
	 private int goodsId;
	 
	 @Column(name = "menuid")
	 private int menuId;
	 
	 @Column(name = "number")
	 private int number;
	 
	 @Column(name = "price")
	 private String price;
	 
	 @Column(name = "code")
	 private String code;
	 
	 @Column(name = "skuname")
	 private String skuName;
	 
	 @Column(name = "property")
	 private String perperty;
	 
	 @Column(name = "barcode")
	 private String barCode;
	 
	 @Column(name = "productcode")
	 private String productCode;
	 
	 @Column(name = "buildtime")
	 private Date buildTime;

	public int getSkuId() {
		return skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}

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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getPerperty() {
		return perperty;
	}

	public void setPerperty(String perperty) {
		this.perperty = perperty;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Date getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
	 
	 
	 
	 
	 

}
