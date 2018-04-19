package test;

import java.util.Map;

import com.entity.Menu;

/**
 * 菜单生成html
 */
public class CopyOfHtmlMenu {
	private StringBuilder bufLevelOne=new StringBuilder();
	private StringBuilder bufLevelTwo=new StringBuilder();
	private StringBuilder bufLevelThird=new StringBuilder();
	

	/**
	 * @param sysMoudle
	 * @param map map中存放的是该节点的所有的子节点
	 */
	public void setBufLevelOne(Menu menu,Map<String,CopyOfHtmlMenu> map){
//		if(bufLevelOne.length()==0){
//			bufLevelOne.append("<div><ul>");
//		}
		if("0".equals(menu.getHaschild())){//如果没有子节点
			bufLevelOne.append("<li><a href='").append(menu.getUrl()).append("'><span>").append(menu.getName()).append("</span></a></li>");
		}else{//有子节点
			bufLevelOne.append("<li><a href='#' class='parent'><span>").append(menu.getName()).append("</span></a>").append(map.get(menu.getMenuid()).getBufLevel2()).append("</li>");
		}
	}
//	public StringBuilder getBufLevelOne(){
//		return bufLevelOne.append("</ul></div>");
//	}
	
	public StringBuilder getBufLevel1() {
		return bufLevelOne;
	}
	
	//  节点二按parentsid生成，生成后存储到map中 map<parentId,menuLevelTwo>
	//	<div>
	//    <ul>	
	//  <li><a href='#' class='parent'><span>Sub Item 2</span></a>
	//     <div>
	//       <ul>
	//         <li><a href='#'><span>Sub Item 2.1</span></a></li>
	//         <li><a href='#'><span>Sub Item 2.2</span></a></li>
	//       </ul>
	//     </div>
	//   </li>
	//   <li><a href='#'><span>Sub Item 3</span></a></li>
	//    </ul>
	//    </div>
	public StringBuilder getBufLevelTwo() {
		return bufLevelTwo.append("</ul></div>");
	}
	
	public StringBuilder getBufLevel2() {
		return bufLevelTwo;
	}
	/**
	 * @param sysMoudle
	 * @param map  map中存放的是该节点的所有的子节点
	 */
	public void setBufLevelTwo(Menu menu,Map<String,CopyOfHtmlMenu> map) {
		//").append(href).append("
		if(bufLevelTwo.length()==0){
			bufLevelTwo.append("<div><ul>");
		}
		if("0".equals(menu.getHaschild())){//如果没有子节点
			bufLevelTwo.append("<li><a href='").append(menu.getUrl()).append("'><span>").append(menu.getName()).append("</span></a></li>");
		}else{//有子节点
			bufLevelTwo.append("<li><a href='#' class='parent'><span>").append(menu.getName()).append("</span></a>").append(map.get(menu.getMenuid()).getBufLevel3()).append("</li>");
		}
	}
	
	

	//节点三按parentsid生成，生成后存储到map中 map<parentId,menuLevelThird>
	//   <div>
	//     <ul>
	//       <li><a href='#'><span>Sub Item 1.7.1</span></a></li>
	//       <li><a href='#'><span>Sub Item 1.7.2</span></a></li>
	//     </ul>
	//   </div>
		
	private StringBuilder getBufLevel3() {
		return bufLevelThird;
	}
	
	public void setBufLevelThird(Menu menu) {
		if(bufLevelThird.length()>0){
			bufLevelThird.append("<li><a href='").append(menu.getUrl()).append("'><span>").append(menu.getName()).append("</span></a></li>");
		}else{
			bufLevelThird.append("<div><ul>");
			bufLevelThird.append("<li><a href='").append(menu.getUrl()).append("'><span>").append(menu.getName()).append("</span></a></li>");
		}
	}
	
	public StringBuilder getBufLevelThird() {
		return bufLevelThird.append("</ul></div>");
	}
}
