package com.lino.libaryapis.api.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
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

   @Test
   @DisplayName("Deve criar um livro com sucesso")//vai dar o nome do teste que estamos realizando
   public void createBookTest() throws Exception{

      String json = new ObjectMapper().writeValueAsString(null);//ele recebe um objeto de qualquer tipo e transforma em json

      MockHttpServletRequestBuilder request = MockMvcRequestBuilders//vai montar a requisição para a api
              .post(BOOK_API)//vai fazer um post nessa URL
              .contentType(MediaType.APPLICATION_JSON)//vai mandar tipo de dado JSON
              .accept(MediaType.APPLICATION_JSON)//Vai receber no aceite o tipo JSON
              .content(json);//no final de todo esse fluxo será feito um POST para esse endPoint passando um json

      mvc
         .perform(request)
         .andExpect(MockMvcResultMatchers.status().isCreated())//é esperado que ele retorne um status created com as informações abaixo
         .andExpect( MockMvcResultMatchers.jsonPath("id").isNotEmpty())//esta verificando se esta vazio id
         .andExpect( MockMvcResultMatchers.jsonPath("title").value("Meu Livro"))//esta verificando o valor do author
         .andExpect( MockMvcResultMatchers.jsonPath("author").value("Autor"))//esta verificando o valor do author
         .andExpect( MockMvcResultMatchers.jsonPath("isbn").value("12321312"));

   }

   @Test
   @DisplayName("Deve lançar erro com sucesso quando não houver dados suficiente para criação do livro!")//vai dar o nome do teste que estamos realizando
   public void createInvalidBookTest(){

   }

}
