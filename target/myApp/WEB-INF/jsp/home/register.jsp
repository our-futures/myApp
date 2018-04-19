<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String ctx = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head lang="en">
		<meta charset="UTF-8">
		<title>注册</title>
		<link type="text/css" rel="stylesheet" href="../css/AmazeUI-2.4.2/assets/css/amazeui.css" />
		<link href="../css/dlstyle.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="../js/loadmask/jquery.loadmask.css" />
		<link rel="stylesheet" type="text/css"  href="../css/alert.css">
		<script  type="text/javascript" src="../js/jquery-1.9.0.min.js"></script>
		<script src="../js/amazeUI/amazeui.min.js"></script>
		<script type="text/javascript" src="../js/MD5/md5.js"></script>
        <script type="text/javascript" src="../js/loadmask/jquery.loadmask.min.js"></script>
         <script type="text/javascript" src="../js/alert.js"></script>
		
	</head>
	<body>
		<div class="login-boxtitle">
			<a href="home/demo.html"><img alt="" src="../images/logobig.png" /></a>
		</div>
		<div class="res-banner">
			<div class="res-main">
				<div class="login-banner-bg"><span></span><img src="../images/big.jpg" /></div>
				<div class="login-box">
						<div class="am-tabs" id="doc-my-tabs">
							<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
								<li class="am-active"><a href="">邮箱注册</a></li>
								<li><a href="">手机号注册</a></li>
							</ul>
							
							<div class="am-tabs-bd">
								<div class="am-tab-panel am-active">
									<form id = "emailForm" method="post">
										<!--提示信息-->
						    			<div class="tip" id="tip">
						    				<img src="../images/error.png"/>
						    				<span>你输入的密码和账户名不匹配，请重新输入</span>
						    			</div>
					    			   <div class="user-email">
										  <label for="email"><i class="am-icon-user" style="margin-top: 10px;"></i></label>
										  <input type="text" name="name" id="name1" placeholder="请输入用户名">
		                 			   </div>	
		                 			  <!--  <span style="font-size:2px;color:#1E90FF;" >*注册后用户名不可修改</span> -->
									   <div class="user-email">
											<label for="email"><i class="am-icon-envelope-o" style="margin-top: 10px;"></i></label>
											<input type="email" name="email" id="email" placeholder="请输入邮箱账号">
		                 			   </div>										
						               <div class="user-pass">
										    <label for="password"><i class="am-icon-lock" style="margin-top: 10px;"></i></label>
										    <input type="password" name="pwd" id="password" placeholder="设置密码">
						               </div>										
						               <div class="user-pass">
										    <label for="passwordRepeat"><i class="am-icon-lock" style="margin-top: 10px;"></i></label>
										    <input type="password" name="pwd" id="passwordRepeat" placeholder="确认密码">
						               </div>
                 				  </form>
								  <div class="login-links">
										<label for="reader-me">
											<input id="reader-me" type="checkbox"> 点击表示您同意商城《服务协议》
										</label>
							  	 </div>
								 <div class="am-cf">
									<input type="submit" id="emailSubBtn" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
								 </div>
							</div>
							<div class="am-tab-panel">
								<form method="post">
									 <!--提示信息-->
						    		 <div class="tip" id="tip1">
						    			<img src="../images/error.png"/>
						    			<span>你输入的密码和账户名不匹配，请重新输入</span>
						    		 </div>
						    		   <div class="user-email">
										  <label for="email"><i class="am-icon-user" style="margin-top: 10px;"></i></label>
										  <input type="text" name="name" id="name2" placeholder="请输入用户名">
		                 			   </div>	
		                 			   <!-- <span style="font-size:2px;color:#1E90FF;" >*注册后用户名不可修改</span> -->
					                 <div class="user-phone">
									    <label for="phone"><i class="am-icon-mobile-phone am-icon-md" style="margin-top:5px;"></i></label>
									    <input type="tel" name="phone" id="phone" placeholder="请输入手机号">
					                 </div>																			
									<!--  <div class="verification">
										<label for="code"><i class="am-icon-code-fork" style="margin-top: 10px;"></i></label>
										<input type="tel" name="" id="code" placeholder="请输入验证码">
										<a class="btn" href="javascript:void(0);" onclick="sendMobileCode();" id="sendMobileCode">
											<span id="dyMobileButton">获取</span>
										</a>
									</div> -->
					                <div class="user-pass">
										    <label for="password"><i class="am-icon-lock" style="margin-top: 10px;"></i></label>
										    <input type="password" name="pwd" id="password1" placeholder="设置密码">
					                </div>										
					                <div class="user-pass">
										    <label for="passwordRepeat"><i class="am-icon-lock" style="margin-top: 10px;"></i></label>
										    <input type="password" name="pwd" id="passwordRepeat1" placeholder="确认密码">
					                </div>	
								</form>
								<div class="login-links">
										<label for="reader-me"><input id="reader-me1" type="checkbox"> 点击表示您同意商城《服务协议》</label>
							  	</div>
								<div class="am-cf">
									<input type="submit" id="phoneSubBtn" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
								</div>
								<hr>
						</div>
					</div>
				</div>
			</div>
		</div>
			
		<div class="footer ">
			<div class="footer-hd ">
				<p>
					<a href="# ">商城首页</a>
					<b>|</b>
					<a href="# ">支付宝</a>
					<b>|</b>
					<a href="# ">物流</a>
				</p>
			</div>
			<div class="footer-bd ">
				<p>
					<a href="# ">合作伙伴</a>
					<a href="# ">联系我们</a>
					<a href="# ">网站地图</a>
					<em>© 2015-2025 版权所有. </em>
				</p>
			</div>
		</div>
</body>
</html>
<script>
$(function() {
    $('#doc-my-tabs').tabs();
    
    //邮箱注册提交
    $("#emailSubBtn").on("click",function(){
    		var name = $.trim($("#name1").val());
            var parm = $.trim($("#email").val());
			var pwd = $.trim($("#password").val());
			var pwd2 = $.trim($("#passwordRepeat").val());
			var type ="1";
    		var res = checkForm(name,parm,pwd,pwd2,type);
			if(!res.success){
				$("form #tip").css("display","block");
				$("form #tip span").text(res.msg);
				return;
			}
			$("form #tip").css("display","none");
    	    $("body").mask();
			$.ajax({
				type:"post",
				url:"../user/register.do",
				data:{
					name:name,
					parm:parm,
					pwd:hex_md5(pwd),
					type:type,
				},
				dataType: 'json',
				beforesend:function(){
				},
				success:function(result){
					if(result.success){
						jqAlaert();
						time() ;
					}else{
						$("form #tip").css("display","block");
						$("form #tip span").text(result.note);
					}
				},
				error:function(e){
					console.log(e);
				},
				complete : function(){
                   $("body").unmask();
                }
			})
    })
    
    //手机注册提交
    $("#phoneSubBtn").on("click",function(){
    		var name = $.trim($("#name2").val());
            var parm = $.trim($("#phone").val());
			var pwd = $.trim($("#password1").val());
			var pwd2 = $.trim($("#passwordRepeat1").val());
			var type ="2";
    		var res = checkForm(name,parm,pwd,pwd2,type);
			if(!res.success){
				$("form #tip1").css("display","block");
				$("form #tip1 span").text(res.msg);
				return;
			}
			$("form #tip1").css("display","none");
    	    $("body").mask();
			$.ajax({
				type:"post",
				url:"../user/register.do",
				data:{
					name:name,
					parm:parm,
					pwd:hex_md5(pwd),
					type:type,
				},
				dataType: 'json',
				beforesend:function(){
				},
				success:function(result){
					if(result.success){
						jqAlaert();
						time() ;
					}else{
						$("form #tip1").css("display","block");
						$("form #tip1 span").text(result.note);
					}
				},
				error:function(e){
					console.log(e);
				},
				complete : function(){
                   $("body").unmask();
                }
			})
    })
    
})
 

function checkForm(name,parm,pwd,pwd2,type){
	var result = {success:true,msg:""};
	
	var nameReg = /^[\w\u4e00-\u9fa5]{2,8}$/; 
	var emailReg = /^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/;
	var phoneReg = /^(13\d|14[57]|15[012356789]|18\d|17[013678])\d{8}$/;
	var pwdReg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,8}$/;
	if(!name){
		result.success = false;
		result.msg = "用户名不能为空";
		return result;
	}else{
		if(!nameReg.test(name)){
			result.success = false;
			result.msg = "用户名由2-8位数字，字母，汉字，下划线组成";
			return result;
		}
	}
	if(type == "1"){
		if(!parm){
			result.success = false;
			result.msg = "邮箱不能为空";
			return result;
		}else{
			if(!emailReg.test(parm)){
				result.success = false;
				result.msg = "邮箱格式不正确";
				return result;
			}
		}
	}else{
		if(!parm){
			result.success = false;
			result.msg = "手机号码不能为空";
			return result;
		}else{
			if(!phoneReg.test(parm)){
				result.success = false;
				result.msg = "手机格式不正确";
				return result;
			}
		}
	}
	
	if(!pwd){
		result.success = false;
		result.msg = "密码不能为空";
		return result;
	}else{
		if(!pwdReg.test(pwd)){
			result.success = false;
			result.msg = "密码由6-8位数字和字母组成";
			return result;
		}
	}
	if(pwd != pwd2){
		result.success = false;
		result.msg = "两次密码不一致";
		return result;
	}
	var flag = $("#reader-me").is(":checked");
	if(!flag){
		result.success = false;
		result.msg = "请同意协议";
		return result;
	}
	return result;
} 


//弹窗
function jqAlaert(){
	var M = {}
	if(M.dialog9){
			return M.dialog9.show();
		}
	M.dialog9 = jqueryAlert({
		'style'   : 'pc',
		'title'   : '注册成功',
		'content' : '注册成功,页面稍后将转向登录页面',
		'modal'   : true,
		'contentTextAlign' : 'left',
		'animateType': 'scale',
		'bodyScroll' : 'true',
		'buttons' : {
			'去登录' : function(){
				location.href="../user/loginPage.do"
			}
		}
	})
}
var tt = 2;
function time() {
      if (tt < 1) {
    	 location.href="../user/loginPage.do"
      	 return;
      };
      tt--;
    window.setTimeout("time()",1000);
}
</script>