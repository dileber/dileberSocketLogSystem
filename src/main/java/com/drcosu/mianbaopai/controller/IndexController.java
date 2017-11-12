package com.drcosu.mianbaopai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shidawei on 2017/6/2.
 */
@Controller
public class IndexController {


    @RequestMapping("/")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "小禾科技爱校android一体化平台");
        return "index";
    }

    @RequestMapping("socketLog")
    public String socketLog(ModelMap model) {
        model.addAttribute("message", "小禾科技爱校android日志平台");
        return "screen";
    }


}
