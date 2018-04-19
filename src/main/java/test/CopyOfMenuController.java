package test;
//package com.common;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.entity.Menu;
//import com.service.MenuService;
//
//@Controller
//@RequestMapping("/menu")
//public class CopyOfMenuController {
//	
//	@Resource
//	MenuService menuSrvice;
//	
//	@RequestMapping(value = "load.do")
//	public String loadMenu(HttpServletRequest request,HttpServletResponse response ){
//		List<Menu> list=menuSrvice.find();
//		Iterator<Menu> iterator=list.iterator();
//		Map<String,Menu> level1Map=new HashMap<String,Menu>();
//		Map<String,List<Menu>> level2Map=new HashMap<String, List<Menu>>();
//		Map<String,List<Menu>> level3Map=new HashMap<String, List<Menu>>();
//		
//		Map<String,HtmlMenu> menu1Map=new HashMap<String,HtmlMenu>();
//		Map<String,HtmlMenu> menu2Map=new HashMap<String,HtmlMenu>();
//		Map<String,HtmlMenu> menu3Map=new HashMap<String,HtmlMenu>();
//		while(iterator.hasNext()){
//			Menu menu=iterator.next();
//     		String id=menu.getMenuid();
//			String parentId=menu.getParentid();
//			int level=menu.getLevels();
//			if(level==1){//一级菜单
//					level1Map.put(id, menu);
//			}
//			
//			if(level==2){//所有的二级菜单
//				List<Menu> listLeve2=(List<Menu>) level2Map.get(parentId);
//				if(listLeve2==null){
//					listLeve2=new ArrayList<Menu>();
//					listLeve2.add(menu);
//					level2Map.put(parentId, listLeve2);
//				}else{
//					listLeve2.add(menu);
//				}
//			}
//			
//			if(level==3){//所有的三级菜单
//				List<Menu> listLeve3=(List<Menu>) level3Map.get(parentId);
//				if(listLeve3==null){
//					listLeve3=new ArrayList<Menu>();
//					listLeve3.add(menu);
//					level3Map.put(parentId, listLeve3);
//				}else{
//					listLeve3.add(menu);
//				}
//			}
//		}
//		
//		//处理所有的三级菜单生成html
//		Set<String> level3Set=level3Map.keySet();
//		Iterator<String> iterLevel3=level3Set.iterator();
//		while(iterLevel3.hasNext()){
//			String parentId=iterLevel3.next();
//			List<Menu> listLevel3=level3Map.get(parentId);//相同父节点的三级菜单
//			HtmlMenu htmlMenu=null;
//			for(int i=0;i<listLevel3.size();i++){
//				Menu menu=listLevel3.get(i);
//				htmlMenu=menu3Map.get(listLevel3.get(i).getParentid());
//				if(htmlMenu==null){
//					htmlMenu=new HtmlMenu();
//					htmlMenu.setBufLevelThird(menu);//创建第三层菜单
//					menu3Map.put(menu.getParentid(), htmlMenu);
//				}else{
//					htmlMenu.setBufLevelThird(menu);
//				}
//			}//注意生成的三级菜单没有  </ul></div>闭合
//		}
//		
//		Set<String> menu3MapSet=level3Map.keySet();
//		Iterator<String> menu3MapLevel3=menu3MapSet.iterator();
//		while(menu3MapLevel3.hasNext()){
//			HtmlMenu menu=menu3Map.get(menu3MapLevel3.next());
//			System.out.println(menu.getBufLevelThird());
//		}
//		
//		//处理所有的二级级菜单生成html
//		Set<String> level2Set=level2Map.keySet();
//		Iterator<String> iterLevel2=level2Set.iterator();
//		while(iterLevel2.hasNext()){
//			String parentId=iterLevel2.next();
//			List<Menu> listLevel2=level2Map.get(parentId);//相同父节点的二级菜单
//			HtmlMenu htmlMenu=null;
//			for(int i=0;i<listLevel2.size();i++){
//				Menu menu=listLevel2.get(i);
//				htmlMenu=menu2Map.get(listLevel2.get(i).getParentid());
//				if(htmlMenu==null){
//					htmlMenu=new HtmlMenu();
//					htmlMenu.setBufLevelTwo(menu,menu3Map);//创建第二层菜单
//					menu2Map.put(menu.getParentid(), htmlMenu);
//				}else{
//					htmlMenu.setBufLevelTwo(menu,menu3Map);//创建第二层菜单
//				}
//			}//注意生成的二级菜单没有  </ul></div>闭合
//		}
// 	
//	 	Set<String> menu2MapSet=level2Map.keySet();
//	 	Iterator<String> menu2MapLevel2=menu2MapSet.iterator();
//	 	while(menu2MapLevel2.hasNext()){
//	 		HtmlMenu menu=menu2Map.get(menu2MapLevel2.next());
//	 		System.out.println(menu.getBufLevelTwo());
//	 	}
//	 	
//	 	
//	 	//处理所有的一级级菜单生成html
//		Set<String> level1Set=level1Map.keySet();
//		Iterator<String> iterLevel1=level1Set.iterator(); 
//		while(iterLevel1.hasNext()){
//			String id=iterLevel1.next();
//			Menu sysMoudle=level1Map.get(id);//相同父节点的二级菜单
//			HtmlMenu htmlMenu=menu1Map.get(id);
//				if(htmlMenu==null){
//					htmlMenu=new HtmlMenu();
//					htmlMenu.setBufLevelOne(sysMoudle,menu2Map);//创建第一层菜单
//					menu1Map.put(id, htmlMenu);
//				}else{
//					htmlMenu.setBufLevelOne(sysMoudle,menu2Map);//创建第一层菜单
//				}
//		}//注意生成的一级菜单没有  </ul></div>闭合
// 	
//	 	Set<String> menu1MapSet=level1Map.keySet();
//	 	Iterator<String> menu1MapLevel1=menu1MapSet.iterator();
//	 	while(menu1MapLevel1.hasNext()){
//	 		HtmlMenu menu=menu1Map.get(menu1MapLevel1.next());
//	 		System.out.println(menu.getBufLevel1());
//	 	}
//
//	 	StringBuilder bufMenu=new StringBuilder();//最终菜单
//	 	bufMenu.append("<div id='menu'>");
//	 	bufMenu.append("<ul class='menu'>");
//	 	Iterator<String> menuSet=menu1Map.keySet().iterator();
//	 	while(menuSet.hasNext()){
//	 		bufMenu.append(menu1Map.get(menuSet.next()).getBufLevel1());
//	 	}
//	 	bufMenu.append("</ul></div>");
//	 	
//	 	
//	 	request .setAttribute("bufMenu", bufMenu);
//		return "/home/menu";
//	 	
//	}
//
//}
