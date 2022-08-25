package com.example.restapi.service;

import com.example.restapi.models.Endereco;
import com.example.restapi.models.Pessoa;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PessoaService {

    public Pessoa montarPessoa(){
        Pessoa pessoa  = new Pessoa();
        pessoa.setNome("Catarina");
        pessoa.setAniversario(LocalDate.parse("2004-06-03"));
        pessoa.setEmail("catarina@gmail.com");
        return pessoa;
    }

}
