package com.controller;

import static com.utils.HttpContextUtil.getRequset;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.common.BankName;
import com.common.UploadImage;
import com.entity.Address;
import com.entity.Answer;
import com.entity.Card;
import com.entity.China;
import com.entity.Question;
import com.entity.User;
import com.entity.UserInfo;
import com.mysql.jdbc.StringUtils;
import com.service.AddressService;
import com.service.AnswerService;
import com.service.CardService;
import com.service.ChinaService;
import com.service.QuestionService;
import com.service.UserInfoService;
import com.service.UserService;
import com.utils.SendEmail;
import com.utils.SessionUtil;
import com.utils.VaildType;

@Controller
@RequestMapping("/person")
public class PensonInfoController extends BaseController {
	
	@Resource
	UserInfoService userInfoService;
	@Resource
	ChinaService chinaService;
	@Resource
	AddressService addressService;
	@Resource
	UserService userService;
	@Resource
	CardService cardService;
	@Resource
	QuestionService questionService;
	@Resource
	AnswerService answerService;
	
	//个人中心页面跳转
	@RequestMapping(value = "index.do")
	public String index(){
		return "/person/index";
	}
	//个人信息页面
	@RequestMapping(value = "info.do")
	public String getInfo(HttpServletRequest request,HttpServletResponse response){
		UserInfo info = new UserInfo();
		HttpSession session = getRequset().getSession();
		User user = (User) session.getAttribute(SessionUtil.USER_KEY);
		int userid = user.getId();
		info = userInfoService.getUserInfo(userid);
		request.setAttribute("info", info);
		request.setAttribute("user", user);
		return "/person/information";
	}
	//客户地址界面
	@RequestMapping(value = "address.do")
	public String address(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = getRequset().getSession();
		User user = (User) session.getAttribute(SessionUtil.USER_KEY);
		//查询省份
		List<China> provinceList = chinaService.findProvince();
		//查询用户的收货地址
		List<Address> addressList = addressService.getAddress(user.getId());
		request.setAttribute("addressList", addressList);
		request.setAttribute("provinceList", provinceList);
		return "/person/address";
	}
	//添加一条收货地址
	@RequestMapping(value = "addAddress.do")
	@ResponseBody
	public String addAddress(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = getRequset().getSession();
		User user = (User) session.getAttribute(SessionUtil.USER_KEY);
		JSONObject json = new JSONObject();
		String key = request.getParameter("addressid");
		Address address = null;
		if("".equals(key)||key == null){
			address = new Address();
		}else{
			address=addressService.getOne(Integer.valueOf(key));
		}
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String perince = request.getParameter("perince");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		String detail = request.getParameter("detail");
		address.setUserid(user.getId());
		address.setName(name);
		address.setPhone(phone);
		address.setProvince(perince);
		address.setCity(city);
		address.setArea(area);
		address.setDetail(detail);
		addressService.saveOrUpdate(address);
		return jsonSuccess(json);
	}
	//删除客户收货地址
	@RequestMapping(value = "delAddress.do")
	@ResponseBody
	public String delAddress(HttpServletRequest request,HttpServletResponse response){
		String addressid = request.getParameter("addressid");
		JSONObject json = new JSONObject();
		if("".equals(addressid) || addressid == null){
			return jsonFail("无法获取该地址id，稍后重试");
		}
		addressService.delete(Integer.valueOf(addressid));
		return jsonSuccess(json);
	}
	//根据省级id获取相对应的市级城市
	@RequestMapping(value = "getCity.do")
	@ResponseBody
	public String getCity(HttpServletRequest request,HttpServletResponse response){
		String provinceid = request.getParameter("provinceid");
		if("".equals(provinceid) || provinceid == null){
			return jsonFail("无法获取市级城市，稍后重试");
		}
		List<China> cityList = chinaService.findCity(Integer.valueOf(provinceid));
		JSONObject json = new JSONObject();
		json.put("cityList", cityList);
		return jsonSuccess(json);
	}
	//根据市级id获取区县地区
	@RequestMapping(value = "getArea.do")
	public String getArea(HttpServletRequest request,HttpServletResponse response){
		String cityid = request.getParameter("cityid");
		if("".equals(cityid) || cityid == null){
			return jsonFail("无法获取区县，稍后重试");
		}
		List<China> areaList = chinaService.findArea(Integer.valueOf(cityid));
		JSONObject json = new JSONObject();
		json.put("areaList", areaList);
		return jsonSuccess(json);
	}
	//保存客户信息
	@RequestMapping(value = "saveInfo.do")
	@ResponseBody
	public String saveInfo(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = getRequset().getSession();
		User sessionUser = (User) session.getAttribute(SessionUtil.USER_KEY);
		UserInfo userInfo = null;
		String userid = request.getParameter("userid");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String nickname = request.getParameter("nickname");
		String realname = request.getParameter("realname");
		String birthday = request.getParameter("birthday");
		String sex = request.getParameter("sex");
		JSONObject json = new JSONObject();
		JSONObject result = VaildType.checkParms(phone, email);
		if(!result.getBoolean("flag")){
			return jsonFail(result.getString("msg"));
		}
		if(StringUtils.isNullOrEmpty(userid)){
			userid = String.valueOf(sessionUser.getId());
		}
		userInfo = userInfoService.findById(Integer.valueOf(userid));
		if(userInfo == null){
			userInfo = new UserInfo();
			userInfo.setUserid(Integer.valueOf(userid));
		}
		userInfo.setBirthday(birthday);
		userInfo.setSex(Integer.valueOf(sex));
		userInfo.setNickname(nickname);
		userInfo.setRealname(realname);
		userInfo.setEmail(email);
		userInfo.setPhone(phone);
		userInfoService.saveOrUpdate(userInfo);
		return jsonSuccess(json);
	}
	
	//安全设置页面
	@RequestMapping(value = "safety.do")
	public String safety(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = getRequset().getSession();
		User user = (User) session.getAttribute(SessionUtil.USER_KEY);
		Answer an = answerService.getAnswer(user.getId());
		if(an !=null){
			request.setAttribute("questionState", "1");
		}else{
			request.setAttribute("questionState", "0");
		}
		request.setAttribute("user", user);
		return "/person/safety";
	}
	
	//修改email界面
	@RequestMapping(value = "changeEmail.do")
	public String changeEmail(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = getRequset().getSession();
		User user = (User) session.getAttribute(SessionUtil.USER_KEY);
		request.setAttribute("user", user);
		return "/person/email";
	}
	
	//发送邮箱的验证码
	@RequestMapping(value = "sendYzm.do")
	@ResponseBody
	public String sendYzm(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = getRequset().getSession();
		User user = (User) session.getAttribute(SessionUtil.USER_KEY);
		JSONObject json = new JSONObject();
		int number= (int) ((Math.random()*9+1)*100000);
		String email = user.getEmail();
		if("".equals(email) || email == null){
			return jsonFail("还未绑定邮箱，确定绑定该邮箱？");
		}
		SendEmail send = new SendEmail();
		String text = "亲爱的用户:"+user.getName()+"!您换绑邮箱的验证码为："+number;
		send.setAddress("513592330@qq.com", email, text);
		send.send();
		json.put("yzm", number);
		return jsonSuccess(json);
	}
	//保存邮箱
	@RequestMapping(value = "saveEmail.do")
	@ResponseBody
	public String saveEmail(HttpServletRequest request,HttpServletResponse response){
		String email = request.getParameter("email");
		HttpSession session = getRequset().getSession();
		User user = (User) session.getAttribute(SessionUtil.USER_KEY);
		JSONObject result = VaildType.checkEmail(email);
		JSONObject json = new JSONObject();
		if(!result.getBoolean("flag")){
			return jsonFail(result.getString("msg"));
		}
		user.setEmail(email);
		userService.update(user);
		return jsonSuccess(json);
	}
	
	//用户银行卡界面
	@RequestMapping(value = "queryCard.do")
	public String queryCard(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = getRequset().getSession();
		User user = (User) session.getAttribute(SessionUtil.USER_KEY);
		List<Card> cardlist = cardService.getCard(user.getId());
		for(int i=0;i<cardlist.size();i++){
			Card  c = cardlist.get(i);
			String num = c.getBanknumber();
			num = num.substring(num.length()-4);
			c.setBanknumber(num);
		}
		request.setAttribute("cardlist", cardlist);
		request.setAttribute("user", user);
		return "/person/cardlist";
	}
	//添加银行卡界面
	@RequestMapping(value = "addCardPage.do")
	public String addCardPage(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = getRequset().getSession();
		User user = (User) session.getAttribute(SessionUtil.USER_KEY);
		request.setAttribute("user", user);
		return "/person/cardmethod";
	}
	
	//添加银行卡
	@RequestMapping(value = "addCard.do")
	@ResponseBody
	public String addCard(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name");
		String idcard = request.getParameter("idcard");
		String idbank = request.getParameter("idbank");
		String phone = request.getParameter("phone");
		HttpSession session = getRequset().getSession();
		User user = (User) session.getAttribute(SessionUtil.USER_KEY);
		JSONObject result = BankName.getNameOfBank(idbank);
		JSONObject json = new JSONObject();
		//判断该银行卡是否已经添加
		Card c = cardService.queryBybankid(idbank);
		if(c!=null){
			return jsonFail("该银行卡已经添加");
		}
		Card card = new Card();
		if(result.getBoolean("flag")){
			card.setBankname(result.getString("msg"));
		}else{
			return jsonFail(result.getString("msg"));
		}
		card.setIsuse(1);
		card.setUserid(user.getId());
		card.setName(name);
		card.setBanknumber(idbank);
		card.setCardid(idcard);
		card.setPhone(phone);
		cardService.save(card);
		return jsonSuccess(json);
	}
	
	//修改密码界面
	@RequestMapping(value = "password.do")
	public String password(HttpServletRequest request,HttpServletResponse response){
//		HttpSession session = getRequset().getSession();
//		User user = (User) session.getAttribute(SessionUtil.USER_KEY);
//		request.setAttribute("user", user);
		return "/person/password";
	}
	//修改密码界面
	@RequestMapping(value = "changePwd.do")
	@ResponseBody
	public String changePwd(HttpServletRequest request,HttpServletResponse response){
		String oldpwd = request.getParameter("oldpwd").trim();
		String newpwd = request.getParameter("newpwd").trim();
		HttpSession session = getRequset().getSession();
		User user = (User) session.getAttribute(SessionUtil.USER_KEY);
		JSONObject json = new JSONObject();
		if("".equals(oldpwd) || oldpwd == null){
			return jsonFail("原密码不能为空");
		}
		if("".equals(newpwd) || newpwd == null){
			return jsonFail("新密码不能为空");
		}
		if(!oldpwd.equals(user.getPwd())){
			return jsonFail("原密码错误，请重新输入");
		}
		user.setPwd(newpwd);
		userService.update(user);
		return jsonSuccess(json);
	}
	//绑定手机界面
	@RequestMapping(value = "phonePage.do")
	public String phonePage(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = getRequset().getSession();
		User user = (User) session.getAttribute(SessionUtil.USER_KEY);
		request.setAttribute("user", user);
		return "/person/bindphone";
	}
	//绑定手机
	@RequestMapping(value = "bindPhone.do")
	@ResponseBody
	public String bindPhone(HttpServletRequest request,HttpServletResponse response){
		String phone = request.getParameter("newphone").trim();
		HttpSession session = getRequset().getSession();
		User user = (User) session.getAttribute(SessionUtil.USER_KEY);
		JSONObject json = new JSONObject();
		if("".equals(phone) || phone == null){
			return jsonFail("请填写新手机号码");
		}
		user.setPhone(phone);
		userService.update(user);
		return jsonSuccess(json);
	}
	
	//添加支付密码界面
	@RequestMapping(value = "payPage.do")
	public String payPage(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = getRequset().getSession();
		User user = (User) session.getAttribute(SessionUtil.USER_KEY);
		request.setAttribute("user", user);
		return "/person/setpay";
	}
	//绑定手机
	@RequestMapping(value = "payPwd.do")
	@ResponseBody
	public String payPwd(HttpServletRequest request,HttpServletResponse response){
		String paypwd = request.getParameter("paypwd").trim();
		HttpSession session = getRequset().getSession();
		User user = (User) session.getAttribute(SessionUtil.USER_KEY);
		JSONObject json = new JSONObject();
		if("".equals(paypwd) || paypwd == null){
			return jsonFail("请输入支付密码");
		}
		user.setPaypwd(paypwd);
		userService.update(user);
		return jsonSuccess(json);
	}
	//实名认证界面
	@RequestMapping(value = "idcardPage.do")
	public String idcardPage(HttpServletRequest request,HttpServletResponse response){
//		HttpSession session = getRequset().getSession();
//		User user = (User) session.getAttribute(SessionUtil.USER_KEY);
//		request.setAttribute("user", user);
		return "/person/idcard";
	}
	//实名认证提交
	@RequestMapping(value = "checkCard.do")
	public void checkCard(HttpServletRequest request,HttpServletResponse response){
		UploadImage.upImage(request, response);
		
	}
	
	//安全问题界面
	@RequestMapping(value = "questionPage.do")
	public String questionPage(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = getRequset().getSession();
		User user = (User) session.getAttribute(SessionUtil.USER_KEY);
		List<Question> list = questionService.query();
		request.setAttribute("list", list);
		Answer answer = answerService.getAnswer(user.getId());
		request.setAttribute("answer", answer);
		return "/person/question";  
	}
	
	//保存安全问题
	@RequestMapping(value = "saveAnswer.do")
	@ResponseBody
	public String saveAnswer(HttpServletRequest request,HttpServletResponse response){
		String ques_one = request.getParameter("ques_one").trim();
		String ques_two = request.getParameter("ques_two").trim();
		String an_one = request.getParameter("an_one").trim();
		String an_two = request.getParameter("an_two").trim();
		if("0".equals(ques_one) && "0".equals(ques_two)){
			return jsonFail("请选择至少一个问题");
		}
		if(ques_one.equals(ques_two)){
			jsonFail("两个问题不能一样");
		}
		if(!"0".equals(ques_one)){
			if("".equals(an_one) || an_one == null){
				return jsonFail("请输入问题1答案");
			}
		}
		if(!"0".equals(ques_two)){
			if("".equals(an_two) || an_two == null){
				return jsonFail("请输入问题2答案");
			}
		}
		
		HttpSession session = getRequset().getSession();
		User user = (User) session.getAttribute(SessionUtil.USER_KEY);
		JSONObject json = new JSONObject();
		Answer answer = null;
	    answer = answerService.getAnswer(user.getId());
	    if(answer ==null){
	    	answer = new Answer();
	    	answer.setUserid(user.getId());	
	    }
	    answer.setAnswerOne(an_one);
    	answer.setAnswerTwo(an_two);
    	answer.setQuestionOne(ques_one);
    	answer.setQuestionTwo(ques_two);
    	answerService.save(answer);
		return jsonSuccess(json);
	}
}
