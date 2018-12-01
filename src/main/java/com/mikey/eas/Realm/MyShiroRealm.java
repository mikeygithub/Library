package com.mikey.eas.Realm;

import com.mikey.eas.Service.UserService;
import com.mikey.eas.Pojo.Role;
import com.mikey.eas.Pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @date 2018/11/5 9:15
 * @Version 1.0
 */
public class MyShiroRealm extends AuthorizingRealm {

     //自动注入service查询用户信息
    @Autowired
    private UserService userService;
    /**
     * 用于授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //1. 从 PrincipalCollection 中来获取登录用户的信息
        User principal = (User) principals.getPrimaryPrincipal();

        //2. 利用登录的用户的信息来用户当前用户的角色或权限(可能需要查询数据库)
        Set<String> roles = new HashSet<>();

        List<Role> role=userService.getUserRoles(principal);//查询该用户的角色

        for (Role r:role) {
                roles.add(r.getRoleName());//添加到角色集合
        }
        //3. 创建 SimpleAuthorizationInfo, 并设置其 reles 属性.
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        System.out.println("=============================>>>>>授权");
        //4. 返回 SimpleAuthorizationInfo 对象.
        return info;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken authenticationToken1 = (UsernamePasswordToken) token;

        String id=authenticationToken1.getUsername();//获取登入用户id编号

        User user= userService.getUser(id);

        if(user==null||user.getUserid()==null){//判断用户是否存在
            throw  new UnknownAccountException("用户不存在");
        }
        //盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(id);

        return new SimpleAuthenticationInfo(id,user.getPassword(),credentialsSalt,getName());
    }
}
