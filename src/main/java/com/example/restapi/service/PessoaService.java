package com.example.restapi.service;

import com.example.restapi.models.Endereco;
import com.example.restapi.models.Pessoa;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

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

    public Pessoa buscarPessoa(String codigo) {
        for (int indice = 0; indice < this.pessoas.size(); indice = indice + 1) {
            Pessoa pessoa = pessoas.get(indice);
            if (pessoa.getCodigo().equals(codigo)){
                return pessoa;
            }
        }
       return null;
    }
    public Pessoa apagarPessoa(String codigo) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCodigo().equals(codigo)) {
              pessoas.remove(pessoa);
              return pessoa;
            }

        }
        return null;
    }

    //remover por indice
    public Pessoa apagarPessoaPorIndice(String codigo){
        for (int indice = 0; indice < pessoas.size(); indice = indice + 1){
            Pessoa pessoa = pessoas.get(indice);
            if (pessoa.getCodigo().equals(codigo)){
                pessoas.remove(pessoa);
                return pessoa;
            }
        }
        return null;
    }

}
