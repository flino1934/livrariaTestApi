package com.lino.libaryapis.api.resource;

import com.lino.libaryapis.api.dto.BookDto;
import com.lino.libaryapis.model.entity.Book;
import com.lino.libaryapis.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")//esse é o EndPoint da requisição REST
public class BookControler {

    private BookService service;
    private ModelMapper modelMapper;

    public BookControler(BookService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//vou passar como resposta do sastus o created
    public BookDto create(@RequestBody BookDto dto){

        Book entity = modelMapper.map(dto,Book.class);//vai pegar todos os parametros vindos no dto e transformar em insancia da classe book

        entity = service.save(entity);//transformou em entidade e salvou

        return modelMapper.map(entity,BookDto.class);//retornou um DTO com as entidades salvas
    }


}
