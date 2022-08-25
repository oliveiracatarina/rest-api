package com.example.restapi.controller;

import com.example.restapi.models.Endereco;
import com.example.restapi.models.Pessoa;
import com.example.restapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public Pessoa getPessoa(){
        Pessoa pessoa  = new Pessoa();
        pessoa.setNome("Catarina");
        pessoa.setAniversario(LocalDate.parse("2004-06-03"));
        pessoa.setEmail("catarina@gmail.com");

        Endereco endereco = enderecoService.montarEndereco();

        pessoa.setEndereco(endereco);

        return pessoa;
    }


}
