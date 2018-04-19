package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "goods_property")
public class GoodsProperty {
	
	 @Id
	 @Column(name = "goodspropertyid")
	 private int goodsPropertyId;
	 
	 @Column(name = "goodsid")
	 private int goodsId;
	 
	 @Column(name = "menuid")
	 private int menuId;
	 
	 @Column(name = "propertynameid")
	 private int propertyNameId;
	 
	 @Column(name = "propertyvalueid")
	 private int propertyValueId;
	 
	 @Column(name = "issku")
	 private String isSku;
	 
	 @Column(name = "buildtime")
	 private Date buildtime;

	public int getGoodsPropertyId() {
		return goodsPropertyId;
	}

	public void setGoodsPropertyId(int goodsPropertyId) {
		this.goodsPropertyId = goodsPropertyId;
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

	public int getPropertyNameId() {
		return propertyNameId;
	}

	public void setPropertyNameId(int propertyNameId) {
		this.propertyNameId = propertyNameId;
	}

	public int getPropertyValueId() {
		return propertyValueId;
	}

	public void setPropertyValueId(int propertyValueId) {
		this.propertyValueId = propertyValueId;
	}

	public String getIsSku() {
		return isSku;
	}

	public void setIsSku(String isSku) {
		this.isSku = isSku;
	}

	public Date getBuildtime() {
		return buildtime;
	}

	public void setBuildtime(Date buildtime) {
		this.buildtime = buildtime;
	}

	 
}
