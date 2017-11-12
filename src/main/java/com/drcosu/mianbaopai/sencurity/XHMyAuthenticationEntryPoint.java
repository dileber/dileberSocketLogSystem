package com.drcosu.mianbaopai.sencurity;

import com.mianbaopailib.servlet.springsecurity.MyAuthenticationEntryPoint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 拦截处理类
 * Created by shidawei on 16/7/18.
 */
public class XHMyAuthenticationEntryPoint extends MyAuthenticationEntryPoint {

    static Pattern apiPattern= Pattern.compile("^/api/");

    public XHMyAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    public boolean condition(String url) {
        Matcher m=apiPattern.matcher(url);
        return m.find();
    }
}
