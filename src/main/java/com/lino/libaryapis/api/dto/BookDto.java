package com.lino.libaryapis.api.dto;


import lombok.*;

@Data
@Builder//vai gerar um builder para classe alvvo
//Essa será a classe de DTO dos nossos livros vai apenas representar nosso JSON
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private String isbn;


}
