package com.lino.libaryapis.api.resource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)//o Spring vai criar um context para rodar o teste
@ActiveProfiles("teste")//estou especificando que ira rodar no perfil de teste essas configurações
@WebMvcTest//Vai fazer os teste unitarios na nossa api
@AutoConfigureMockMvc//vai configurar o objeto para fazer as requisições
public class BookControllerTest {

   @Autowired
   MockMvc mvc;

   @Test
   @DisplayName("Deve criar um livro com sucesso")//vai dar o nome do teste que estamos realizando
   public void createBookTest(){

   }

   @Test
   @DisplayName("Deve lançar erro com sucesso quando não houver dados suficiente para criação do livro!")//vai dar o nome do teste que estamos realizando
   public void createInvalidBookTest(){

   }

}
