package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "property_value")
public class PropertyValue {
	
	 @Id
	 @Column(name = "propertyvalueid")
	 private int propertyValueId;
	 
	 @Column(name = "menuid")
	 private int menuId;
	 
	 @Column(name = "propertynameid")
	 private int propertyNameId;
	 
	 @Column(name = "propertyvalue")
	 private String propertyValue;
	 
	 @Column(name = "state")
	 private String state;
	 
	 @Column(name = "order")
	 private String order;
	 
	 @Column(name = "buildtime")
	 private Date buildTime;

	public int getPropertyValueId() {
		return propertyValueId;
	}

	public void setPropertyValueId(int propertyValueId) {
		this.propertyValueId = propertyValueId;
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

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
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
