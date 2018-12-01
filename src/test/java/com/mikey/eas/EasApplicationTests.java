package com.mikey.eas;

import com.github.pagehelper.PageInfo;
import com.mikey.eas.Pojo.Book;
import com.mikey.eas.Pojo.BookType;
import com.mikey.eas.Service.BookService;
import com.mikey.eas.Service.BookTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasApplicationTests {

    @Autowired
    private BookTypeService bookTypeService;
    @Autowired
    private BookService bookService;

    @Test
    public void contextLoads() {
//        List<BookType> allBookType = bookTypeService.getAllBookType();
//        System.out.println("Message"+allBookType);
        PageInfo<Book> allBook = bookService.getAllBook(1, 10);
        System.out.println("Message="+allBook);

        List<Book> list=allBook.getList();
        System.out.println("me======="+list);
        for (Book b:list){
            System.out.println("Book="+b.getBookName());
        }
    }

}
