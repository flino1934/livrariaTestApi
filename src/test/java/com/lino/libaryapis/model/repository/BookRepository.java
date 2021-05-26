package com.lino.libaryapis.model.repository;

import com.lino.libaryapis.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {



}
