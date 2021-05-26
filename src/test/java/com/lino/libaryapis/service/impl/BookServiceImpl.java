package com.lino.libaryapis.service.impl;

import com.lino.libaryapis.model.entity.Book;
import com.lino.libaryapis.model.repository.BookRepository;
import com.lino.libaryapis.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }

}
