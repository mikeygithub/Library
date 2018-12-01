package com.mikey.eas.Service;

import com.mikey.eas.Pojo.BookType;

import java.util.List;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/11/29 11:04
 * @Version 1.0
 */
public interface BookTypeService {
        public void addBookType(BookType bookType);
        public void deleteBookType(int bookTypeId);
        public void updateBookType(BookType bookType);
        public BookType getBookType(int bookTypeId);
        public List<BookType> getAllBookType();
}
