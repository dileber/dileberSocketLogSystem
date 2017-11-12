package com.drcosu.mianbaopai.interceptor;



/**
 * 安全拦截器
 * Created by shidawei on 16/7/21.
 */
public class SafeInterceptor{

}
//public class SafeInterceptor extends HandlerInterceptorAdapter implements InitializingBean {
//    public void afterPropertiesSet() throws Exception {
//
//    }
//    @Autowired
//    UserService userService;
//
//    /**
//     * 对拦截的数据进行安全检查
//     * @param request
//     * @param response
//     * @param handler
//     * @return
//     * @throws Exception
//     */
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Map<String,String[]> map = new TreeMap(request.getParameterMap());
//        String safeString = USafe.safeString(request.getRequestURI(), map);
//        String head = request.getHeader("safe");
//        String token = request.getHeader("token");
//        if(map.size()==0){
//            return super.preHandle(request, response, handler);
//        }
//        if(head!=null&&head.equals(safeString)){
//            if(userService.checkToken(token,request)==1){
//                return super.preHandle(request, response, handler);
//            }
//        }
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter out = response.getWriter();
//        response.setStatus(403);
//        DataWrapper dataWrapper = new DataWrapper();
//        dataWrapper.setState(-1);
//        dataWrapper.setMsg("参数校验错误");
//        out.println(UJson.toJson(dataWrapper));
//        out.flush();
//        out.close();
//        return false;
//    }
//}
