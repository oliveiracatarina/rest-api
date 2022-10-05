package com.example.restapi.service;

import com.example.restapi.models.Endereco;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    public Endereco montarEndereco(String logradouro, String numero, String cep, String bairro,
                                   String cidade, String estado){
        Endereco endereco = new Endereco();
        endereco.setLogradouro(logradouro);
        endereco.setNumero(numero);
        endereco.setCep(cep);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        return endereco;
    }



    public String concatenarEndereco (Endereco endereco){
        return "Logradouro: " + endereco.getLogradouro() +
                "Numero: " + endereco.getNumero() +
                "Cep: " + endereco.getCep() +
                "Bairro: " + endereco.getBairro() +
                "Cidade: " + endereco.getCidade() +
                "Estado: " + endereco.getEstado();

    }

}
