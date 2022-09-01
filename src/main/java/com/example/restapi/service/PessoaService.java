package com.example.restapi.service;

import com.example.restapi.models.Endereco;
import com.example.restapi.models.Pessoa;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PessoaService {

    private List<Pessoa> pessoas = new ArrayList<>();

    public Pessoa montarPessoa(String nome, String data, String email){
        Pessoa pessoa  = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setAniversario(LocalDate.parse(data));
        pessoa.setEmail(email);
        return pessoa;
    }

    public Pessoa criarPessoa(Pessoa pessoa){
        pessoa.setCodigo(UUID.randomUUID().toString());
        this.pessoas.add(pessoa);
        return pessoa;
    }
    public List<Pessoa> listarPessoas(){
        return this.pessoas;
    }
}
