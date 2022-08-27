package com.example.restapi.service;

import com.example.restapi.models.Endereco;
import com.example.restapi.models.Pessoa;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PessoaService {

    public Pessoa montarPessoa(String nome, String data, String email){
        Pessoa pessoa  = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setAniversario(LocalDate.parse(data));
        pessoa.setEmail(email);
        return pessoa;
    }

}
