package com.example.restapi.service;

import com.example.restapi.models.Endereco;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    public Endereco montarEndereco(){
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua Brasil");
        endereco.setNumero("123");
        endereco.setCep("12345-678");
        endereco.setBairro("Alphaville");
        endereco.setCidade("Barueri");
        endereco.setEstado("Sao Paulo");
        return endereco;
    }
}
