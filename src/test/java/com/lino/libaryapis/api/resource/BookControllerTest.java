package com.lino.libaryapis.api.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lino.libaryapis.api.dto.BookDto;
import com.lino.libaryapis.model.entity.Book;
import com.lino.libaryapis.service.BookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.ResponseStatus;




@ExtendWith(SpringExtension.class)//o Spring vai criar um context para rodar o teste
@ActiveProfiles("teste")//estou especificando que ira rodar no perfil de teste essas configurações
@WebMvcTest//Vai fazer os teste unitarios na nossa api
@AutoConfigureMockMvc//vai configurar o objeto para fazer as requisições
public class BookControllerTest {

   static String BOOK_API = "/api/books";//essa vai ser a rota padrão da nossa api

   @Autowired
   MockMvc mvc;

   @MockBean//vai servir para mocar os itens na minha classe
   BookService service;

   @Test
   @DisplayName("Deve criar um livro com sucesso")//vai dar o nome do teste que estamos realizando
   public void createBookTest() throws Exception{

      BookDto dto = BookDto.builder().author("Artur").title("As aventuras").isbn("001").build();//mandou o DTO como JSON mas ainda não possuia ID
      Book savedBook = Book.builder().id(10l).author("Artur").title("As aventuras").isbn("001").build();//Esta populan um obj que vai ser salvo

      BDDMockito.given(service.save(Mockito.any(Book.class)))
              .willReturn(savedBook);//vai salvar utilizando o mockito

      String json = new ObjectMapper().writeValueAsString(dto);//ele recebe um objeto de qualquer tipo e transforma em json

      MockHttpServletRequestBuilder request = MockMvcRequestBuilders//vai montar a requisição para a api
              .post(BOOK_API)//vai fazer um post nessa URL
              .contentType(MediaType.APPLICATION_JSON)//vai mandar tipo de dado JSON
              .accept(MediaType.APPLICATION_JSON)//Vai receber no aceite o tipo JSON
              .content(json);//no final de todo esse fluxo será feito um POST para esse endPoint passando um json

      mvc
         .perform(request)
         .andExpect(MockMvcResultMatchers.status().isCreated())//é esperado que ele retorne um status created com as informações abaixo
         .andExpect( MockMvcResultMatchers.jsonPath("id").isNotEmpty())//esta verificando se esta vazio id
         .andExpect( MockMvcResultMatchers.jsonPath("title").value(dto.getTitle()))//esta verificando o valor do author
         .andExpect( MockMvcResultMatchers.jsonPath("author").value(dto.getAuthor()))//esta verificando o valor do author
         .andExpect( MockMvcResultMatchers.jsonPath("isbn").value(dto.getIsbn()));

   }

   @Test
   @DisplayName("Deve lançar erro com sucesso quando não houver dados suficiente para criação do livro!")//vai dar o nome do teste que estamos realizando
   public void createInvalidBookTest(){

   }

}
