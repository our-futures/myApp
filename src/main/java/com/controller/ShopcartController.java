package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shopcart")
public class ShopcartController {
	
	
	@RequestMapping(value = "cartPage.do")
	public String regpage(){
		return "/home/shopcart";
	}
}
