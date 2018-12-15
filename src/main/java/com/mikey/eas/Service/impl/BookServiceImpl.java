package com.mikey.eas.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mikey.eas.Mapper.BookMapper;
import com.mikey.eas.Mapper.BookTypeMapper;
import com.mikey.eas.Pojo.Book;
import com.mikey.eas.Pojo.BookExample;
import com.mikey.eas.Pojo.BookType;
import com.mikey.eas.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private BookTypeMapper bookTypeMapper;

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

    /**
     * 搜索图书分页
     * @param idOrName
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Book> getBookByIdOrBookName(String idOrName,int currentPage, int pageSize) {

        BookExample bookExample = new BookExample();

        BookExample.Criteria criteria = bookExample.createCriteria();//bookname

        criteria.andBookNameLike(idOrName);

        BookExample.Criteria criteria2 = bookExample.createCriteria();

        try {
            bookExample.or(criteria2.andBookIdEqualTo(Integer.parseInt(idOrName)));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            bookExample.or(criteria2.andBookIdEqualTo(-1));
        }

        PageHelper.startPage(currentPage,pageSize);

        List<Book> allBook=bookMapper.selectByExample(bookExample);

        PageInfo pageData = new PageInfo(allBook, pageSize);

        return pageData;
    }

    /**
     * 获取数据，将其可视化
     * @return
     */
    @Override
    public Map<String, Object> getDataStatistics() {
        Map<String,Object> map=new HashMap<>();
        List<String> titleList=new ArrayList<>();
        List<Long> numList=new ArrayList<>();
        //查询类型
        List<Map<String,Object>> dataStatistics = bookMapper.getDataStatistics();//获取数据

        for (Map<String,Object> result:dataStatistics){
            for(Map.Entry<String,Object> entry:result.entrySet()){
                if (entry.getKey().equals("type_name")){
                    titleList.add((String)entry.getValue());
                    continue;
                }else {
                    numList.add((Long)entry.getValue());
                }
            }
        }

        map.put("title",titleList);
        //查询类型对应的书籍数目
        map.put("num",numList);
        return map;
    }
}
