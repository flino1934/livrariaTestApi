package com.lino.libaryapis.service;

import com.lino.libaryapis.model.entity.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)//o Spring vai criar um contexto para rodar o teste
@ActiveProfiles("teste")//estou especificando que ira rodar no perfil de teste essas configurações
public class BookServiceTest {

    BookService service;

    @Test
    @DisplayName("Deve salvar um livro")
    public void saveBookTest(){

        //cenario
        Book book = Book.builder().isbn("123").author("Fulano").title("As aventuras").build();
        Book savedBook = service.save(book);//esta falando que oq for salvo vai ser do tipo book

        //verificação
        assertThat(savedBook.getId()).isNotNull();
        assertThat(savedBook.getIsbn()).isEqualTo("123");
        assertThat(savedBook.getTitle()).isEqualTo("As aventuras");
        assertThat(savedBook.getAuthor()).isEqualTo("Fulano");

    }

}
