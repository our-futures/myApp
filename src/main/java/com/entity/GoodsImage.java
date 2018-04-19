package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "goods_image")
public class GoodsImage {
	
	 @Id
	 @Column(name = "goodsimageid")
	 private int goodsImageId;
	 
	 @Column(name = "imageurl")
	 private String imageUrl;
	 
	 @Column(name = "goodsid")
	 private int goodsId;
	 
	 @Column(name = "menuid")
	 private int menuId;
	 
	 @Column(name = "ismain")
	 private String isMain;
	 
	 @Column(name = "buildtime")
	 private Date buildTime;

	public int getGoodsImageId() {
		return goodsImageId;
	}

	public void setGoodsImageId(int goodsImageId) {
		this.goodsImageId = goodsImageId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public String getIsMain() {
		return isMain;
	}

	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}

	public Date getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
	 
	 

}
