package com.drcosu.mianbaopai.sencurity;

import com.mianbaopailib.model.DataWrapper;
import com.mianbaopailib.servlet.springsecurity.AjaxAuthenticationSuccessHandler;
import com.mianbaopailib.utils.UJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录成功处理类
 * Created by shidawei on 16/7/18.
 */
public class XHAjaxAuthenticationSuccessHandler extends AjaxAuthenticationSuccessHandler {
    @Override
    public String onAuthenticationJsonToString(Authentication authentication, HttpServletRequest httpServletRequest) {
        return null;
    }

//    @Autowired
//    UserService service;

//    @Override
//    public String onAuthenticationJsonToString(Authentication authentication, HttpServletRequest httpServletRequest) {
//        UserModel user = (UserModel) authentication.getPrincipal();
//        UserModel result;
//        DataWrapper<UserModel> dataWrapper = new DataWrapper<UserModel>();
//        try {
//            result = service.spring_login(user.getUsername(), httpServletRequest);
//            dataWrapper.setData(result);
//            dataWrapper.setState(0);
//            dataWrapper.setMsg("登录成功");
//        } catch (UserException e) {
//            e.printStackTrace();
//            dataWrapper.setState(-1);
//            dataWrapper.setMsg(e.getMessage());
//        }
////        ObjectMapper mapper = new ObjectMapper();
////        try {
////            return mapper.writeValueAsString(dataWrapper);
////        } catch (JsonProcessingException e) {
////            e.printStackTrace();
////        }
////        return null;
//        return UJson.toJson(dataWrapper);
//    }
}
