package com.zaizai.service.impl;


import com.zaizai.dao.BookDao;
import com.zaizai.domain.Book;
import com.zaizai.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    public Boolean save(Book book) {

        return bookDao.save(book)>0;
    }

    public Boolean update(Book book) {

        return  bookDao.update(book)>0;
    }

    public Boolean delete(Integer id) {

        return  bookDao.delete(id)>0;
    }

    public List<Book> selectAll() {
        List<Book> books = bookDao.selectAll();
        return books;
    }

    public Book selectById(Integer id) {
        Book book = bookDao.selectById(id);
        return book;
    }
}
