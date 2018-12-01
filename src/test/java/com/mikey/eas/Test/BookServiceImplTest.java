package com.mikey.eas.Test;

import com.github.pagehelper.PageInfo;
import com.mikey.eas.Pojo.Book;
import com.mikey.eas.Service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/11/30 22:02
 * @Version 1.0
 */

public class BookServiceImplTest {

    @Autowired
    private BookService bookService;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getAllBook() {
//        PageInfo<Book> allBook = bookService.getAllBook(0, 10);
//        System.out.println("Message="+allBook);
    }
}