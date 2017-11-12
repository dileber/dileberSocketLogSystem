package com.drcosu.mianbaopai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shidawei on 15/11/1.
 */
@Controller
@RequestMapping("error")
public class ErrorPageController {

    @RequestMapping("/{errCode}")
    public String showErrPage(@PathVariable("errCode") final String errCode) {
        return "error/" + errCode;
    }

}
