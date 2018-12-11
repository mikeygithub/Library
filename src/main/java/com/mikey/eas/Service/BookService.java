package com.mikey.eas.Service;

import com.github.pagehelper.PageInfo;
import com.mikey.eas.Pojo.Book;

import java.util.List;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/11/29 11:02
 * @Version 1.0
 */
public interface BookService {
    public void addBook(Book book);
    public void deleteBook(int bookId);
    public void updateBook(Book book);
    public Book getBook(int bookId);
    public PageInfo<Book> getAllBook(int currentPage, int pageSize);

    PageInfo<Book> getBookByIdOrBookName(String query,int i, int i1);
}
