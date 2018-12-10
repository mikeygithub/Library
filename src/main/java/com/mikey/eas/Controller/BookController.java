package com.mikey.eas.Controller;

import com.github.pagehelper.PageInfo;
import com.mikey.eas.Pojo.Book;
import com.mikey.eas.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class BookController {

    public static final String LIST="list";
    public static final String DEL="delete";
    public static final String ADD="add";
    public static final String UP="update";

    @Autowired
    private BookService bookService;


    @RequestMapping("/list/{currentPage}")
    public String listUI(@PathVariable(value = "currentPage",required = false) int currentPage, Map<String,Object> map){

        PageInfo<Book> allBook = bookService.getAllBook(currentPage, 11);

        map.put("allbook",allBook);

        return LIST;
    }
    @RequestMapping("/addbookUI")
    public String addBookUI(){
        return ADD;
    }

    @RequestMapping("/addbook")
    public String addBook(Book book){
        System.out.println("bookMessage="+book);
        bookService.addBook(book);
    return ADD;
    }

    /**
     *
     * @param currentPage
     * @param map
     * @return
     */
    @RequestMapping("/updatebookUI/{currentPage}")
    public String updatebookUI(@PathVariable(value = "currentPage",required = false) int currentPage, Map<String,Object> map){

        PageInfo<Book> allBook = bookService.getAllBook(currentPage, 11);

        map.put("allbook",allBook);

        return UP;
    }

    /**
     * updatebook
     * @param book
     * @return
     */
    @RequestMapping("/updatebook")
    public String updatebook(Book book){
        bookService.updateBook(book);
        return ADD;
    }

    /**
     * 删除界面
     * @param currentPage
     * @param map
     * @return
     */
    @RequestMapping("/deletebookUI/{currentPage}")
    public String deletebookUI(@PathVariable(value = "currentPage",required = false) int currentPage, Map<String,Object> map){

        PageInfo<Book> allBook = bookService.getAllBook(currentPage, 11);

        map.put("allbook",allBook);

        return DEL;
    }
    /**
     * 删除图书
     * @param bookId
     * @return
     */
    @RequestMapping("/deletebook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int bookId){
        bookService.deleteBook(bookId);

        return "redirect:/deletebookUI/1";
    }
    /**
     * 获取书籍详情
     * @param bookId
     * @param map
     */
    @RequestMapping("/detail/{bookId}")
    public String getBookDetail(@PathVariable("bookId") int bookId,Map<String,Object> map){

        Book book = bookService.getBook(bookId);

        map.put("book",book);

        return "detail";
    }

    /**
     *修改图书
     * @param bookId
     * @param map
     * @return
     */
    @RequestMapping("/updatedetail/{bookId}")
    public String getUpdateBookDetail(@PathVariable("bookId") int bookId,Map<String,Object> map){

        Book book = bookService.getBook(bookId);

        map.put("book",book);

        return "updatabook";
    }
    /**
     * 修改图书
     * @param book
     * @return
     */
    @RequestMapping("/updated")
    public String updateBook(Book book){

        bookService.updateBook(book);

        return "updatabook";
    }
}
