package com.drcosu.mianbaopai.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户验证
 * Created by shidawei on 16/7/18.
 */
public class CommonAuth implements AuthenticationProvider, Serializable {

    private static final long serialVersionUID = 8783452581122892129L;

//    @Autowired
//    UserService userService;

    /**
     * 验证登录权限
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String name = authentication.getName().trim().toLowerCase();
//        String password = authentication.getCredentials().toString().trim();
//
//        UserModel userModel = userService.checkUser(name);
//
//        if(userModel != null){
//            if(userModel.getUserpass().equals(userService.getPassWord(userModel.getUsersalt(),password))){
//                List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
//                if(userModel.getUsername().equals("史大伟")){
//                    grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//                }
//                grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
//                Authentication auths = new UsernamePasswordAuthenticationToken(userModel, password, grantedAuths);
//
//                return auths;
//            }
//            throw new AuthenticationException("密码错误") {};
//        }

        throw new AuthenticationException("用户名不存在") {};
    }

    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
