package com.zaizai.service;

import com.zaizai.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface BookService {
    public Boolean  save(Book book);
    public Boolean update(Book book);
    public Boolean delete(Integer id);
    public List<Book> selectAll();
    public Book selectById(Integer id);

}
