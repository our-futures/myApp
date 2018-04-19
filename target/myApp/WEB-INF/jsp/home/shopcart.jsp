<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%
	String ctx = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<%@ include file="/WEB-INF/jsp/person/head.jsp" %> 
	<head>
		<title>购物车页面</title>
		<!-- <link href="../css/demo.css" rel="stylesheet" type="text/css" />  -->
		<link href="../css/cartstyle.css" rel="stylesheet" type="text/css" />
		<link href="../css/optstyle.css" rel="stylesheet" type="text/css" />
		<link href="../css/myapp/myStyle.css" rel="stylesheet" type="text/css" />
		<!-- <script type="text/javascript" src="../js/jquery.js"></script> -->
	</head>
	<body>
			
		  	<div class="nav-table">
	 			<div class="long-title"><span class="all-goods">购物车</span></div>
			</div>
			<b class="line"></b>
			<!--购物车 -->
			<div class="concent">
				<div id="cartTable">
					<div class="cart-table-th">
						<div class="wp">
							<div class="th th-chk">
								<div id="J_SelectAll1" class="select-all J_SelectAll">

								</div>
							</div>
							<div class="th th-item">
								<div class="td-inner">商品信息</div>
							</div>
							<div class="th th-price">
								<div class="td-inner">单价</div>
							</div>
							<div class="th th-amount">
								<div class="td-inner">数量</div>
							</div>
							<div class="th th-sum">
								<div class="td-inner">金额</div>
							</div>
							<div class="th th-op">
								<div class="td-inner">操作</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>

					<tr class="item-list">
						<div class="bundle  bundle-last ">
							<div class="clear"></div>
							<div class="bundle-main">
								<ul class="item-content clearfix">
									<li class="td td-chk">
										<div class="cart-checkbox ">
											<input class="check checkshop" id="J_CheckBox_170037950254" name="items[]" value="170037950254" type="checkbox">
											<label for="J_CheckBox_170037950254"></label>
										</div>
									</li>
									<li class="td td-item">
										<div class="item-pic">
											<a href="#" target="_blank" data-title="美康粉黛醉美东方唇膏口红正品 持久保湿滋润防水不掉色护唇彩妆" class="J_MakePoint" data-point="tbcart.8.12">
												<img src="../images/kouhong.jpg_80x80.jpg" class="itempic J_ItemImg"></a>
										</div>
										<div class="item-info">
											<div class="item-basic-info">
												<a href="#" target="_blank" title="美康粉黛醉美唇膏 持久保湿滋润防水不掉色" class="item-title J_MakePoint" data-point="tbcart.8.11">美康粉黛醉美唇膏 持久保湿滋润防水不掉色</a>
											</div>
										</div>
									</li>
									<li class="td td-info">
										<div class="item-props item-props-can">
											<span class="sku-line">颜色：12#川南玛瑙</span>
											<span class="sku-line">包装：裸装</span>
											<!-- <span tabindex="0" class="btn-edit-sku theme-login">修改</span>
											<i class="theme-login am-icon-sort-desc"></i> -->
										</div>
									</li>
									<li class="td td-price">
										<div class="item-price price-promo-promo">
											<div class="price-content">
												<div class="price-line">
													<em class="price-original">78.00</em>
												</div>
												<div class="price-line">
													<em class="J_Price price-now" tabindex="0">39.19</em>
												</div>
											</div>
										</div>
									</li>
									<li class="td td-amount">
										<div class="amount-wrapper ">
											<div class="item-amount ">
												<div class="sl">
													<input class="min am-btn" name="" type="button" value="-" />
													<input class="text_box" name="" type="text" value="3" style="width:30px;" />
													<input class="add am-btn" name="" type="button" value="+" />
												</div>
											</div>
										</div>
									</li>
									<li class="td td-sum">
										<div class="td-inner">
											<em tabindex="0" class="J_ItemSum number">117.00</em>
										</div>
									</li>
									<li class="td td-op">
										<div class="td-inner">
											<a title="移入收藏夹" class="btn-fav" href="#">
                  移入收藏夹</a>
											<a href="javascript:;" data-point-url="#" class="delete">
                  删除</a>
										</div>
									</li>
								</ul>
								<ul class="item-content clearfix">
									<li class="td td-chk">
										<div class="cart-checkbox ">
											<input class="check checkshop" id="J_CheckBox_170037950254" name="items[]" value="170037950254" type="checkbox">
											<label for="J_CheckBox_170037950254"></label>
										</div>
									</li>
									<li class="td td-item">
										<div class="item-pic">
											<a href="#" target="_blank" data-title="美康粉黛醉美东方唇膏口红正品 持久保湿滋润防水不掉色护唇彩妆" class="J_MakePoint" data-point="tbcart.8.12">
												<img src="../images/kouhong.jpg_80x80.jpg" class="itempic J_ItemImg"></a>
										</div>
										<div class="item-info">
											<div class="item-basic-info">
												<a href="#" target="_blank" title="美康粉黛醉美唇膏 持久保湿滋润防水不掉色" class="item-title J_MakePoint" data-point="tbcart.8.11">美康粉黛醉美唇膏 持久保湿滋润防水不掉色</a>
											</div>
										</div>
									</li>
									<li class="td td-info">
										<div class="item-props item-props-can">
											<span class="sku-line">颜色：12#川南玛瑙</span>
											<span class="sku-line">包装：裸装</span>
											<!-- <span tabindex="0" class="btn-edit-sku theme-login">修改</span>
											<i class="theme-login am-icon-sort-desc"></i> -->
										</div>
									</li>
									<li class="td td-price">
										<div class="item-price price-promo-promo">
											<div class="price-content">
												<div class="price-line">
													<em class="price-original">78.00</em>
												</div>
												<div class="price-line">
													<em class="J_Price price-now" tabindex="0">50.00</em>
												</div>
											</div>
										</div>
									</li>
									<li class="td td-amount">
										<div class="amount-wrapper ">
											<div class="item-amount ">
												<div class="sl">
													<input class="min am-btn" name="" type="button" value="-" />
													<input class="text_box" name="" type="text" value="3" style="width:30px;" />
													<input class="add am-btn" name="" type="button" value="+" />
												</div>
											</div>
										</div>
									</li>
									<li class="td td-sum">
										<div class="td-inner">
											<em tabindex="0" class="J_ItemSum number">117.00</em>
										</div>
									</li>
									<li class="td td-op">
										<div class="td-inner">
											<a title="移入收藏夹" class="btn-fav" href="#">
                  移入收藏夹</a>
											<a href="javascript:;" data-point-url="#" class="delete">
                  删除</a>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</tr>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>

				<div class="float-bar-wrapper">
					<div id="J_SelectAll2" class="select-all J_SelectAll">
						<div class="cart-checkbox">
							<input class="check-all check" id="J_SelectAllCbx2" name="select-all" value="true" type="checkbox">
							<label for="J_SelectAllCbx2"></label>
						</div>
						<span>全选</span>
					</div>
					<div class="operations">
						<a href="#" hidefocus="true" class="deleteAll">删除</a>
						<a href="#" hidefocus="true" class="J_BatchFav">移入收藏夹</a>
					</div>
					<div class="float-bar-right">
						<div class="amount-sum">
							<span class="txt">已选商品</span>
							<em id="J_SelectedItemsCount">0</em><span class="txt">件</span>
							<div class="arrow-box">
								<span class="selected-items-arrow"></span>
								<span class="arrow"></span>
							</div>
						</div>
						<div class="price-sum">
							<span class="txt">合计:</span>
							<strong class="price">¥<em id="J_Total">0.00</em></strong>
						</div>
						<div class="btn-area">
							<a href="pay.html" id="J_Go" class="submit-btn submit-btn-disabled" aria-label="请注意如果没有选择宝贝，将无法结算">
								<span >结&nbsp;算</span></a>
						</div>
					</div>
				</div>
				<%@ include file="/WEB-INF/jsp/person/footer.jsp" %>
			</div>
	</body>
</html>
<script type="text/javascript">
$(document).ready(function() {
	//全选与取消全选的功能 
	//=================发现一个问题：如果用attr,全选按钮多点几次就出现无效果的状态，换成prop就不会=======
	var $allCheckbox = $(".check-all");
	$allCheckbox.click(function(){
		if($(this).is(':checked')){
			$(".check").each(function(){
				$(this).prop('checked',true);
			})
		}else{
			$(".check").each(function(){
				$(this).prop('checked',false);
			})
		}
		totalMoney();
	})
	//单个选中或取消选中的时候去计算总数量和总价格
	$(".checkshop").click(function(){
		totalMoney();
	})
	//计算单个商品根据选中的数量计算价格
	$(".min").click(function(){
		var $num = $(this).next();
		var prive = $(this).parents(".td-amount").prev().find(".price-now").text();
		var $allnum = $(this).parents(".td-amount").next().find(".number");
		if($num.val()>1){
			$num.val($num.val()-1)
			var allprice = (prive*$num.val()).toFixed(2);
			$allnum.text(allprice)
		}
		totalMoney();	
	})
	$(".add").click(function(){
		var $num = $(this).prev();
		var prive = $(this).parents(".td-amount").prev().find(".price-now").text();
		var $allnum = $(this).parents(".td-amount").next().find(".number");
		$num.val(($num.val()-0)+(1-0));
		var allprice = (prive*$num.val()).toFixed(2);
		$allnum.text(allprice);
		totalMoney();	
	})
	//改变输入框的数量的时候，进行计算
	$(".text_box").keyup(function(){
		var r = /^[0-9]*[1-9][0-9]*$/;
		var num = $(this).val();
		var flag = r.test(num);
		if(!flag){
			$(this).val(1);
			num = 1;
		}
		var prive = $(this).parents(".td-amount").prev().find(".price-now").text();
		var $allnum = $(this).parents(".td-amount").next().find(".number");
		var allprice = (prive*num).toFixed(2);
		$allnum.text(allprice)
		totalMoney();	
	})
	
	//======================================总计==========================================
	function totalMoney(){
		var totalmoney = 0;
		var totalcount  = 0;
		var $checkbox = $(".checkshop");
		$checkbox.each(function(){
			if($(this).is(':checked')){
				var allnum = $(this).parents(".item-content").find(".text_box").val()-0;
				var allprice = $(this).parents(".item-content").find(".number").text()-0;
				totalmoney += allprice;
				totalcount += allnum;
			}
		})
		
		$("#J_SelectedItemsCount").text(totalcount);
		$("#J_Total").text(totalmoney.toFixed(2));
	}
	
})
</script>