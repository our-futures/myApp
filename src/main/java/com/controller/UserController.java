package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import static com.utils.HttpContextUtil.getRequset;
import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import com.service.MenuService;
import com.service.UserService;
import com.utils.CookieUtil;
import com.utils.SessionUtil;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	private static final Logger LOG = Logger.getLogger(UserController.class);
	
	@Resource
	UserService userSrvice;
	@Resource
	MenuService menurSrvice;
	
	
	@RequestMapping(value = "loginPage.do")
	public String goLogin(){
		return "/home/login";
	}
	
	@RequestMapping(value = "login.do")
	@ResponseBody
	public String login(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String reFlag = request.getParameter("remberFlag");
		LOG.info("=====================用户名="+name+"密码="+pwd+"标志位="+reFlag+"==================");
		User userInfo = userSrvice.findUser(name);
		if(userInfo == null){
			String msg = "该用户不存在，请先注册";
			return jsonFail(msg);
		}else{
			User user = userSrvice.login(name, pwd);
			if(user == null){
				String msg = "密码错误，请重新输入";
				return jsonFail(msg);
			}else{
				if("1".equals(reFlag)){
					CookieUtil.creatCookie(CookieUtil.USER_NAME, name);
					CookieUtil.creatCookie(CookieUtil.USER_PWD, pwd);
				}else{
					CookieUtil.removeCookie(CookieUtil.USER_NAME);
					CookieUtil.removeCookie(CookieUtil.USER_PWD);
				}
				JSONObject json =  (JSONObject) JSONObject.toJSON(user);
				SessionUtil.loginUser(getRequset().getSession(), user);
				return jsonSuccess(json);
			}
		}
	}
	
	@RequestMapping(value = "loginOut.do")
	public String loginOut(){
		SessionUtil.loginoutUser(getRequset().getSession());
		return "/home/login";
	}
	
	@RequestMapping(value = "register.do")
	@ResponseBody
	public String register(HttpServletRequest request,HttpServletResponse response){
		JSONObject json = new JSONObject();
		String name = request.getParameter("name").trim();
		String parm = request.getParameter("parm").trim();
		String pwd = request.getParameter("pwd").trim();
		String type = request.getParameter("type");
		if(name == null || "".equals(name)){
			return jsonFail("用户名不能为空");
		}
		if(parm == null || "".equals(parm)){
			return jsonFail("邮箱或手机号码不能为空");
		}
		if(pwd == null || "".equals(pwd)){
			return jsonFail("密码不能为空");
		}
		User userObj = userSrvice.findUser(parm);
		if(userObj != null){
			if("1".equals(type)){
				return jsonFail("该邮箱已注册");
			}else{
				return jsonFail("该手机号码已注册");
			}
			
		}
		userSrvice.add(name,parm,pwd);
		return jsonSuccess(json);
	}
	
	@RequestMapping(value = "index.do")
	public String userIndex(HttpServletRequest request,HttpServletResponse response){
		String menu = menurSrvice.getMenu();
		//判断是否已经登录
		HttpSession session = getRequset().getSession();
		int isLogin = SessionUtil.isLogin(session);
//		User user = (User) session.getAttribute(SessionUtil.USER_KEY);
//		request.setAttribute("user", user);
		request.setAttribute("isLogin", isLogin);
		request.setAttribute("menu", menu);
		return "/home/home";
	}
	@RequestMapping(value = "regPage.do")
	public String regpage(){
		return "/home/register";
	}
	
}
