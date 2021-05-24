package com.lino.libaryapis.api.dto;


import lombok.Data;
import lombok.Setter;

@Data
//Essa será a classe de DTO dos nossos livros vai apenas representar nosso JSON
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private String isbn;


}
