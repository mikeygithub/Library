package com.mikey.eas.Service.impl;

import com.mikey.eas.Mapper.BookTypeMapper;
import com.mikey.eas.Pojo.BookType;
import com.mikey.eas.Pojo.BookTypeExample;
import com.mikey.eas.Service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/11/29 11:06
 * @Version 1.0
 */
@Service
public class BookTypeServiceImpl implements BookTypeService {
    @Autowired
    private BookTypeMapper bookTypeMapper;

    @Override
    public void addBookType(BookType bookType) {
        bookTypeMapper.insert(bookType);
    }

    @Override
    public void deleteBookType(int bookTypeId) {
        bookTypeMapper.deleteByPrimaryKey(bookTypeId);
    }

    @Override
    public void updateBookType(BookType bookType) {
        bookTypeMapper.updateByPrimaryKey(bookType);
    }

    @Override
    public BookType getBookType(int bookTypeId) {
        return bookTypeMapper.selectByPrimaryKey(bookTypeId);
    }

    @Override
    public List<BookType> getAllBookType() {
        BookTypeExample bookTypeExample=new BookTypeExample();

        return bookTypeMapper.selectByExample(null);
    }
}
