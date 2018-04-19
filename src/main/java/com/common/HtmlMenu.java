package com.common;

import java.util.Map;

import com.entity.Brand;
import com.entity.Menu;

/**
 * 菜单生成html
 */
public class HtmlMenu {
	private StringBuffer levelone = new StringBuffer();//一级菜单
	private StringBuffer leveltwo = new StringBuffer();//二级菜单
	private StringBuffer brand = new StringBuffer();//品牌

	
	
	
	public StringBuffer getLevelone() {
		return levelone;
	}
	public void setLevelone(Menu menu, Map<String ,HtmlMenu> map, Map<String ,HtmlMenu> brandMap) {
		if("0".equals(menu.getHaschild())){//判断是否有子节点，0没有，1有
			levelone.append("<li><div class='category-info'><h3 class='category-name b-category-name'><i>");
			levelone.append("<img src='").append(menu.getImage()).append("'></i><a class='ml-22' title='").append(menu.getName()).append("'>");
			levelone.append(menu.getName()).append("</a></h3><em>&gt;</em></div>").append("</li>");
		}else{
			levelone.append("<li><div class='category-info'><h3 class='category-name b-category-name'><i>");
			levelone.append("<img src='").append(menu.getImage()).append("'></i><a class='ml-22' title='").append(menu.getName()).append("'>");
			levelone.append(menu.getName()).append("</a></h3><em>&gt;</em></div>").append(map.get(menu.getMenuid()).getLeveltwo(menu,brandMap)).append("</li>");
		}
	}
	
	
	
	public StringBuffer getLeveltwo(Menu menu, Map<String ,HtmlMenu> brandMap) {
		leveltwo.append("</dl></div></div></div></div></div>");
		
//		leveltwo.append("</dl></div>").append(brandMap.get(menu.getMenuid())。getBrand()).append("</div></div></div></div>");
		return leveltwo;
	}
	
	
	public void setLeveltwo(Menu level1,Menu level2) {
		String name = level1.getName();
		if(leveltwo.length()>0){
			leveltwo.append("<dd><a title='").append(level2.getName()).append("' href='").append(level2.getUrl()).append("'><span>").append(level2.getName()).append("</span></a></dd>");				
		}else{
			leveltwo.append("<div class='menu-item menu-in top'><div class='area-in'><div class='area-bg'><div class='menu-srot'><div class='sort-side'><dl class='dl-sort'>");
			leveltwo.append("<dt><span title='").append(name).append("'>").append(name).append("</span></dt>");//<dt><span title='"+蛋糕+"'>蛋糕</span></dt>
			leveltwo.append("<dd><a title='").append(level2.getName()).append("' href='").append(level2.getUrl()).append("'><span>").append(level2.getName()).append("</span></a></dd>");//<dd><a title="蒸蛋糕" href="#"><span>蒸蛋糕</span></a></dd>
		}

	}
	public StringBuffer getBrand() {
		brand.append("</dl></div>");
		return brand;
	}
	public void setBrand(Brand b) {
		if(brand.length()>0){
//			<div class="brand-side">
//			<dl class="dl-sort"><dt><span>实力商家</span></dt>
//				<dd><a rel="nofollow" title="呵官方旗舰店" target="_blank" href="#" rel="nofollow"><span  class="red" >呵官方旗舰店</span></a></dd>
//				<dd><a rel="nofollow" title="格瑞旗舰店" target="_blank" href="#" rel="nofollow"><span >格瑞旗舰店</span></a></dd>
//				<dd><a rel="nofollow" title="飞彦大厂直供" target="_blank" href="#" rel="nofollow"><span  class="red" >飞彦大厂直供</span></a></dd>
//				<dd><a rel="nofollow" title="红e·艾菲妮" target="_blank" href="#" rel="nofollow"><span >红e·艾菲妮</span></a></dd>
//				<dd><a rel="nofollow" title="本真旗舰店" target="_blank" href="#" rel="nofollow"><span  class="red" >本真旗舰店</span></a></dd>
//				<dd><a rel="nofollow" title="杭派女装批发网" target="_blank" href="#" rel="nofollow"><span  class="red" >杭派女装批发网</span></a></dd>
//			</dl>
//		    </div>
			brand.append("<dd><a rel='nofollow' title='").append(b.getBrandChinaName()).append("' target='_blank' href='").append(b.getBrandAddress()).append("' rel='nofollow'><span class='red'>")
			.append(b.getBrandChinaName()).append("</span></a></dd>");
		}else{
			brand.append("<div class='brand-side'><dl class='dl-sort'><dt><span>推荐品牌</span></dt>");
			brand.append("<dd><a rel='nofollow' title='").append(b.getBrandChinaName()).append("' target='_blank' href='").append(b.getBrandAddress()).append("' rel='nofollow'><span class='red'>")
			.append(b.getBrandChinaName()).append("</span></a></dd>");
		}
	}
	
	
	
}
