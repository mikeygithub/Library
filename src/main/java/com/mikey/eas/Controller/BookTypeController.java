package com.mikey.eas.Controller;

import com.github.pagehelper.PageInfo;
import com.mikey.eas.Pojo.BookType;
import com.mikey.eas.Service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/11/27 22:48
 * @Version 1.0
 */
@Controller
public class BookTypeController {

    @Autowired
    private BookTypeService bookTypeService;

    @RequestMapping("/booktypeUI/{currentPage}")
    public String BookTypeUI(@PathVariable(value = "currentPage",required = false) int currentPage, Map<String,Object> map){
        PageInfo<BookType> allBookType = bookTypeService.getAllBookType(currentPage,11);
        map.put("allBookType",allBookType);
        return "booktypelist";
    }

    @RequestMapping("/deletebooktype/{bookTypeId}")
    public String deleteBookTypeUI(@PathVariable("bookTypeId") int bookTypeId){
        bookTypeService.deleteBookType(bookTypeId);
        return "booktypelist";
    }

    @RequestMapping("/addbooktypeUI")
    public String addBookType(){
        return "addbooktype";
    }
    @RequestMapping("/addbooktype")
    public String addBookType(BookType bookType){
        bookTypeService.addBookType(bookType);
        return "addbooktype";
    }
}
