package com.mikey.eas.Filter;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/11/26 8:45
 * @Version 1.0
 */

public class MyFormAuthenticationFilter extends FormAuthenticationFilter {
    // 制定session跳转url
    private final String successUrl = "redirect:/main";

    @Override
    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("-----------------------------------清理");
        WebUtils.getAndClearSavedRequest(request);
        WebUtils.issueRedirect(request, response, successUrl, null, true);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        WebUtils.getAndClearSavedRequest(request);
        System.out.println("-----------------------------------清理");
        WebUtils.issueRedirect(request, response, successUrl);
        return false;
    }
}
