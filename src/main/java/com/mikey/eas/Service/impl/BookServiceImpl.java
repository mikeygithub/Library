package com.mikey.eas.Service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mikey.eas.Mapper.BookMapper;
import com.mikey.eas.Pojo.Book;
import com.mikey.eas.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/11/29 11:15
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public void addBook(Book book) {
        bookMapper.insert(book);
    }

    @Override
    public void deleteBook(int bookId) {
        bookMapper.deleteByPrimaryKey(bookId);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateByPrimaryKey(book);
    }

    @Override
    public Book getBook(int bookId) {
        return bookMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public PageInfo<Book> getAllBook(int currentPage, int pageSize) {

        PageHelper.startPage(currentPage,pageSize);

        List<Book> allBook=bookMapper.selectByExample(null);

        PageInfo pageData = new PageInfo(allBook, pageSize);

        return pageData;
    }
}