package com.lino.libaryapis.api.resource;

import com.lino.libaryapis.api.dto.BookDto;
import com.lino.libaryapis.model.entity.Book;
import com.lino.libaryapis.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")//esse é o EndPoint da requisição REST
public class BookControler {

    private BookService service;

    public BookControler(BookService service) {//esta fazendo a injção de dependencia via construtor
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//vou passar como resposta do sastus o created
    public BookDto create(@RequestBody BookDto dto){

        Book entity = Book.builder()
                .author(dto.getAuthor())
                .title(dto.getTitle())
                .isbn(dto.getIsbn())
                .build();//recebeu o DTO

        entity = service.save(entity);//transformou em entidade e salvou

        return BookDto.builder()
                .id(entity.getId())
                .author(entity.getAuthor())
                .title(entity.getTitle())
                .isbn(entity.getIsbn())
                .build();//retornou um DTO com as entidades salvas
    }


}
