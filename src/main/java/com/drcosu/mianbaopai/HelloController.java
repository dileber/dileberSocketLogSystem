package com.drcosu.mianbaopai;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "小禾科技，android自动生成包平台");
		return "hello";
	}

	@RequestMapping("socketLog")
	public String socketLog(ModelMap model) {
		return "screen";
	}



}