package com.mikey.eas.Controller;

import com.mikey.eas.Service.UserService;
import com.mikey.eas.Pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import com.mikey.eas.Utils.DateFormat;


/**
 * @author Mikey
 * @Title:
 * @Description:
 * @date 2018/10/21 16:19
 * @Version 1.0
 */
@SessionAttributes(types = User.class)
@Controller
public class UserControlImpl {

    private static final Logger log = LoggerFactory.getLogger(UserControlImpl.class);
    public static final String LOGIN="login";
    public static final String MAIN="redirect:/main";

    @Autowired
    UserService userService;
    /**
     * login UI page
     * @return
     */
    @RequestMapping("/loginUI")
    public String loginUI(){
        return "login";
    }

    /**
     * main UI
     * @return
     */
    @RequestMapping("/main")
    public String test(){
        return "main";
    }
    /**
     * user login
     * @return
     */
    @PostMapping(value = "/login")
    public String userLogin(User user, Map<String,Object> map,Boolean rememberMe) throws Exception {

        Subject currentUser= SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()){
            UsernamePasswordToken token=new UsernamePasswordToken(user.getUserid(),user.getPassword());
//            token.setRememberMe(true);//判断是否记住密码
            try {
                currentUser.login(token);
            }catch (UnknownAccountException uae){
                log.info("用户:"+user.getUserid()+"在"+DateFormat.getNowTimeSimple()+"进行登入查询不到用户名");
                map.put("msg","该用户未注册！");
                return LOGIN;
            }catch (IncorrectCredentialsException lae){
                log.info("用户:"+user.getUserid()+"在"+DateFormat.getNowTimeSimple()+"进行登入密码输入错误");
                map.put("msg","登入密码错误！");
                return LOGIN;
            }catch (LockedAccountException lae ) {
                log.info("用户"+user.getUserid()+"在"+DateFormat.getNowTimeSimple()+"尝试登入");
                map.put("msg","账户冻结,登入失败！");
                return LOGIN;
            }catch (AuthenticationException ae ){
                log.info("用户"+user.getUserid()+"在"+DateFormat.getNowTimeSimple()+"进行登入发生异常"+ae.getMessage());
                map.put("msg","登入失败、请联系管理员！");
                return LOGIN;
            }
        }
        log.info("用户:"+user.getUserid()+"在"+DateFormat.getNowTimeDetail()+"进行登入");
        return MAIN;
    }
    @RequestMapping("/addUser")
    public String addUser(@RequestParam("userid") String userid,Map<String,Object> map) throws Exception {
        User user=new User();

        boolean userExist = userService.userExist(user);

        if (userExist){
            map.put("msg","该用户已存在");
        }else {
            map.put("msg","该用户未存在");
        }
        return "index";
    }
}
