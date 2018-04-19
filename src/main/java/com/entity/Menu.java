package com.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "menu")
public class Menu {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "levels")
	private int  levels;
	
	@Column(name = "menuid")
	private String menuid;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "isshow")
	private String isshow;
	
	@Column(name = "name")
	private String name;

	@Column(name = "haschild")
	private String haschild;
	
	@Column(name = "parentid")
	private String parentid;
	
	
	@Column(name = "image")
	private String image;
	
//	@Column(name = "indexes")
//	private int indexes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLevels() {
		return levels;
	}

	public void setLevels(int levels) {
		this.levels = levels;
	}

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIsshow() {
		return isshow;
	}

	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHaschild() {
		return haschild;
	}

	public void setHaschild(String haschild) {
		this.haschild = haschild;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}



	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
//	public int getIndexes() {
//		return indexes;
//	}
//
//	public void setIndexes(int indexes) {
//		this.indexes = indexes;
//	}
	
	
	
    
}