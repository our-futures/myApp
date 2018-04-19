<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String ctx = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head lang="en">
<title>登录</title>
<script  type="text/javascript" src="../js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="../js/MD5/md5.js"></script>
<script type="text/javascript" src="../js/loadmask/jquery.loadmask.min.js"></script>
<link type="text/css" rel="stylesheet" href="../css/AmazeUI-2.4.2/assets/css/amazeui.css" />
<link type="text/css" rel="stylesheet"  href="../css/dlstyle.css" >
<link rel="stylesheet" type="text/css" href="../js/loadmask/jquery.loadmask.css" />




</head>

<body>

	<div class="login-boxtitle">
		<a href="home.html"><img alt="logo"
			src="../images/logobig.png" />
		</a>
	</div>

	<div class="login-banner">
		<div class="login-main">
			<div class="login-banner-bg">
				<span></span><img src="../images/big.jpg" />
			</div>
			<div class="login-box">
				<h3 class="title">登录商城</h3>
				<div class="clear"></div>
				<div class="login-form">
					<form>
						<!--提示信息-->
		    			<div class="tip">
		    				<img src="../images/error.png"/>
		    				<span>你输入的密码和账户名不匹配，请重新输入</span>
		    			</div>
						<div class="user-name">
							<label for="user"><i class="am-icon-user" style="margin-top: 10px;"></i>
							</label> <input type="text" name="name" id="user" class="userChange" value="15705938769"  placeholder="邮箱/手机">
						</div>
						
		    			
						<div class="user-pass">
							<label for="password"><i class="am-icon-lock" style="margin-top: 10px;"></i>
							</label> <input type="password" name="pwd" id="password" class="userChange" value="123abc" placeholder="请输入密码">
						</div>
					</form>
				</div>

				<div class="login-links">
					<label for="remember-me">
						<input id="remember-me" type="checkbox">记住密码
						<input type="hidden" id="remberUser" value="">
					</label> 
					<a href="#" class="am-fr">忘记密码</a> 
					<a href="javascript:void(0);" onclick="regPage()" class="zcnext am-fr am-btn-default">注册</a> <br />
				</div>
				<div class="am-cf">
					<input type="submit" name="" id="submitBtn" value="登 录"
						class="am-btn am-btn-primary am-btn-sm">
				</div>
				<div class="partner">
					<h3>合作账号</h3>
					<div class="am-btn-group">
						<li><a href="#"><i class="am-icon-qq am-icon-sm"></i><span>QQ登录</span></a></li>
						<li><a href="#"><i class="am-icon-weibo am-icon-sm"></i><span>微博登录</span></a></li>
						<li><a href="#"><i class="am-icon-weixin am-icon-sm"></i><span>微信登录</span></a></li>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="footer ">
		<div class="footer-hd ">
			<p>
				<b>|</b> <a href="# ">商城首页</a> <b>|</b> <a href="# ">支付宝</a> <b>|</b>
				<a href="# ">物流</a>
			</p>
		</div>
		<div class="footer-bd ">
			<p>
				<a href="# ">合作伙伴</a> <a href="# ">联系我们</a> <a href="# ">网站地图</a> 
				<em>© 2015-2025 版权所有. </em>
			</p>
		</div>
	</div>
</body>
</html>
<script>
let pwdFalg=false;
$(document).ready(function(){
	//记住密码功能
	/* var userName=getCookie("userName");
	var userPwd=getCookie("userPwd");
	if(userName && userPwd){
		$("input[type='checkBox']").attr("checked",true);
		pwdFalg = true;
	}
	//自动填充用户名和密码
	$("#user").val(userName);
	$("#password").val(userPwd);
	
	$(".userChange").change(function(){
			pwdFalg = false;
			$("input[type='checkBox']").attr("checked",false);
	}); */
	//提交数据表单
	$("#submitBtn").on("click", function(){
			rember();
			let name = $.trim($("#user").val());
			let pwd = pwdFalg?$.trim($("#password").val()):hex_md5($("#password").val())
			let res = checkForm(name,pwd);
			if(!res.success){
				$("form .tip").css("display","block");
				$("form .tip span").text(res.msg);
				return;
			}
			$("form .tip").css("display","none");
			$("body").mask();
			$.ajax({
				type:"post",
				url:"../user/login.do",
				data:{
					name:name,
					pwd:pwd,
					remberFlag:$("#remberUser").val(),
				
				},
				dataType: 'json',
				beforesend:function(){},
				success:function(result){
					if(result.success){
				   		location.href="../user/index.do";
					}else{
						$("form .tip").css("display","block");
						$("form .tip span").text(result.note);
					}
				},
				complete : function(){
                   $("body").unmask();
                }
			})
	})
	
})

function checkForm(name,pwd){
	let result = {success:true,msg:""};
	if(!name){
		result.success = false;
		result.msg = "账户名不能为空";
		return result
	}
	if(!pwd){
		result.success = false;
		result.msg = "密码不能为空";
		return result
	}
	return result;
}
function regPage(){
	location.href="../user/regPage.do"
}
//获取cookie中的值
function getCookie(cname){
	var name = cname+"=";
	var ca = document.cookie.split(";");
	for(var i=0;i<ca.length;i++){
		var c = ca[i];
		while(c.charAt(0)==' '){
			c=c.substring(1);
		}
		if(c.indexOf(name) != -1){
			console.log(c.substring(name.length,c.length));
			return c.substring(name.length,c.length);
		}
	}
	return "";
}
//记住密码功能
function rember(){
	if(pwdFalg){
		var reFlag = $("input[type='checkBox']").is(":checked");
		if(reFlag == true){
			$("#remberUser").val("1");
		}else{
			$("#remberUser").val("");
		}
		
	}else{
		var reFlag = $("input[type='checkBox']").is(":checked");
		if(reFlag == true){
			var conFlag = confirm("您确定要使用记住密码功能吗?");
			if(conFlag){
				$("#remberUser").val("1");
			}else{
				$("input[type='checkBox']").attr("checked",false);
				$("#remberUser").val("");
			}
		}else{
			$("#remberUser").val("");
		}
	}
	
}

</script>