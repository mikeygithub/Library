package com.mikey.eas.Interceptor;//package cn.mikey.eas.Interceptor;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @author Mikey
// * @Title:
// * @Description:
// * @date 2018/10/23 11:15
// * @Version 1.0
// */
//@Component
//public class LoginInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
////        Object user=request.getSession().getAttribute("loginuser");
////        System.out.println("Message="+request.getRequestURI());
////        if (request.getRequestURI().equals("/userLogin"))return true;
////        //获取登入用户信息判断是否已经登入
////        if (user==null){
////            request.setAttribute("msg","没有权限请先登入");
////            request.getRequestDispatcher("/login").forward(request,response);
////            return false;
////        }else {
//            return true;
////        }
////        // 校验用户访问是否是公开资源地址(无需认证即可访问)
////        List<String> open_urls = ResourcesUtil.gekeyList("anonymousURL");
////        // 用户访问的url
////        String url = request.getRequestURI();
////        for (String open_url : open_urls) {
////            if (url.indexOf(open_url) >= 0) {
////                // 如果访问的是公开 地址则放行
////                return true;
////            }
////        }
////        // 校验用户身份是否认证通过
////        HttpSession session = request.getSession();
////        ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
////        if (activeUser != null) {
////            // 用户已经登陆认证，放行
////            return true;
////        }
////        // 跳转到登陆页面
////        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
////        return false;
////    }
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//}
