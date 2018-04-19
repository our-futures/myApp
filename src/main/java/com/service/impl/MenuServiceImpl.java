package com.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.common.HtmlMenu;
import com.dao.BrandDao;
import com.dao.MenuDao;
import com.entity.Brand;
import com.entity.Menu;
import com.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Resource
	MenuDao menuDao;
	
	@Resource
	BrandDao brandDao;

	public String getMenu() {
		List<Menu> menus = menuDao.find();//获取所有菜单
		Iterator<Menu> iterator = menus.iterator();
		Map<String,Menu> level1map = new HashMap<String,Menu>(); //存放所有一集菜单
		Map<String,List<Menu>> level2map = new HashMap<String,List<Menu>>();//存放所有二级菜单
		
		Map<String,HtmlMenu> menu1map = new HashMap<String,HtmlMenu>();//存放一级菜单html
		Map<String,HtmlMenu> menu2map = new HashMap<String,HtmlMenu>();//存放二级菜单html
		Map<String,HtmlMenu> brandMap = new HashMap<String, HtmlMenu>();//存放品牌
		
		while(iterator.hasNext()){
			Menu m = iterator.next();
			String menuid = m.getMenuid();
			String parentid = m.getParentid();
			int level = m.getLevels();
			if(level == 1){//一级菜单分离出来
				level1map.put(menuid, m);
			}
			if(level == 2){//分离二级菜单,根据父id 分别存放到对应的key去
				List<Menu> list = level2map.get(parentid);
				if(list == null){
					list = new ArrayList<Menu>();
					list.add(m);
					level2map.put(parentid,list);
				}else{
					list.add(m);
				}
				
			}
		}
		
		//处理二级菜单生成html
		Set<String> level2set = level2map.keySet();
		Iterator<String> it1 = level2set.iterator();
		while(it1.hasNext()){
			String parentid = it1.next(); //获取二级菜单的parentid
			Menu level1 = level1map.get(parentid);//根据parentid获取上级菜单对象
			List<Menu> menlist = level2map.get(parentid);//根据parentid获取它的所有菜单
			HtmlMenu htmlmenu = null;
			for(int i=0;i<menlist.size();i++){
				Menu m = menlist.get(i);
				htmlmenu = menu2map.get(m.getParentid());
				if(htmlmenu == null){
					htmlmenu = new HtmlMenu();
					htmlmenu.setLeveltwo(level1,m);
					menu2map.put(parentid, htmlmenu);
				}else{
					htmlmenu.setLeveltwo(level1,m);
				}
			}
		}
		/*
		 * 二级菜单测试
		 */
//		Set<String> levelhtml2 = menu2map.keySet();
//		Iterator<String> t = levelhtml2.iterator();
//		while(t.hasNext()){
//			String id = t.next();
//			HtmlMenu menu=menu2map.get(id);
//			System.out.println(menu.getLeveltwo());
//		}
		
		
		Set<String> level1set = level1map.keySet();
		Iterator<String> it2 = level1set.iterator();
		//品牌处理
		while(it2.hasNext()){
			String menuid = it2.next(); //获取所有的祖级菜单id
			HtmlMenu htmlMenu = null;
			List<Brand> brandList = brandDao.findBrand(menuid);
			for(int i=0;i<brandList.size();i++){
				htmlMenu = brandMap.get(menuid);
				Brand b = brandList.get(i);
				if(htmlMenu == null){
					htmlMenu = new HtmlMenu();
					htmlMenu.setBrand(b);//创建一级菜单
					brandMap.put(menuid, htmlMenu);
				}else{
					htmlMenu.setBrand(b);
				}				
			}			
			
		}
		//处理一级菜单
		Set<String> level1set1 = level1map.keySet();
		Iterator<String> it22 = level1set1.iterator();
		while(it22.hasNext()){
			String menuid = it22.next(); //获取所有的祖级菜单id
			Menu menu = level1map.get(menuid);//找到menuid的菜单对象
			HtmlMenu htmlMenu = menu1map.get(menuid);
			if(htmlMenu == null){
				htmlMenu = new HtmlMenu();
				htmlMenu.setLevelone(menu,menu2map,brandMap);//创建一级菜单
				menu1map.put(menuid, htmlMenu);
			}else{
				htmlMenu.setLevelone(menu,menu2map,brandMap);
			}
		}
		
		
		
//		Set<String> levelhtml1 = menu1map.keySet();
//		Iterator<String> tt = levelhtml1.iterator();
//		while(tt.hasNext()){
//			String id = tt.next();
//			HtmlMenu menu=menu1map.get(id);
//			System.out.println(menu.getLevelone());
//		}
		
	 	StringBuilder bufMenu=new StringBuilder();//最终菜单
	 	Iterator<String> menuSet=menu1map.keySet().iterator();
	 	while(menuSet.hasNext()){
	 		bufMenu.append(menu1map.get(menuSet.next()).getLevelone());
	 	}
	 	
	 	
		return bufMenu.toString();
	}
		
		
		
		
	

}
