package com.mikey.eas.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/11/27 16:51
 * @Version 1.0
 */
@Controller
public class AllMpping {
    @RequestMapping("/addbooktype")
    public String addBookType(){
        return "addbooktype";
    }
    @RequestMapping("/deletebooktype")
    public String deleteBookType(){
        return "booktypelist";
    }
}
