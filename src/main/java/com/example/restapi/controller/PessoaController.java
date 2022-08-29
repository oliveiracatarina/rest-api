package com.example.restapi.controller;

import com.example.restapi.models.Endereco;
import com.example.restapi.models.Pessoa;
import com.example.restapi.service.EnderecoService;
import com.example.restapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public Pessoa getPessoa(
            @RequestParam(value = "nome") String nome,
            @RequestParam(value = "data") String data,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "logradouro") String logradouro,
            @RequestParam(value = "numero") String numero,
            @RequestParam(value = "cep") String cep,
            @RequestParam(value = "bairro") String bairro,
            @RequestParam(value = "cidade") String cidade,
            @RequestParam(value = "estado") String estado
    ){
        Pessoa pessoa  = pessoaService.montarPessoa(nome, data, email);

        Endereco endereco = enderecoService.montarEndereco(logradouro, numero, cep, bairro, cidade, estado);

        pessoa.setEndereco(endereco);

        return pessoa;
    }


}
