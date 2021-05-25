package com.lino.libaryapis.api.resource;

import com.lino.libaryapis.api.dto.BookDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")//esse é o EndPoint da requisição REST
public class BookControler {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//vou passar como resposta do sastus o created
    public BookDto create(@RequestBody BookDto dto){

        

        return dto;
    }


}
