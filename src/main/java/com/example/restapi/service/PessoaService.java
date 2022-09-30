package com.example.restapi.service;

import com.example.restapi.dto.DadosAtuaisPessoaDTO;
import com.example.restapi.dto.PessoaDTO;
import com.example.restapi.models.Endereco;
import com.example.restapi.models.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

@Service
public class PessoaService {

    private List<Pessoa> pessoas = new ArrayList<>();

    @Autowired
    private EnderecoService enderecoService;

    public Pessoa montarPessoa(String nome, String data, String email) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setAniversario(LocalDate.parse(data));
        pessoa.setEmail(email);
        return pessoa;
    }

    //criar pessoa (post)
    public Pessoa criarPessoa(Pessoa pessoa) {
        pessoa.setCodigo(UUID.randomUUID().toString());
        this.pessoas.add(pessoa);
        return pessoa;
    }

    public List<Pessoa> listarPessoas() {
        return this.pessoas;
    }

    //buscar pessoa
    public Pessoa buscarPessoa(String codigo) {
        for (int indice = 0; indice < this.pessoas.size(); indice = indice + 1) {
            Pessoa pessoa = pessoas.get(indice);
            if (pessoa.getCodigo().equals(codigo)) {
                return pessoa;
            }
        }
        return null;
    }

    //remover pessoa
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
    public Pessoa apagarPessoaPorIndice(String codigo) {
        for (int indice = 0; indice < pessoas.size(); indice = indice + 1) {
            Pessoa pessoa = pessoas.get(indice);
            if (pessoa.getCodigo().equals(codigo)) {
                pessoas.remove(pessoa);
                return pessoa;
            }
        }
        return null;
    }

    //atualizar uma informação (put)
    public Pessoa atualizarPessoa(String codigo, DadosAtuaisPessoaDTO dadosAtuais) {
        for (int indice = 0; indice < pessoas.size(); indice = indice + 1){
            if (pessoas.get(indice).getCodigo().equals(codigo)) {
                pessoas.get(indice).setNome(dadosAtuais.getNome());
                pessoas.get(indice).setEmail(dadosAtuais.getEmail());
                pessoas.get(indice).setAniversario(dadosAtuais.getAniversario());
                return pessoas.get(indice);
            }
        }

        return null;
    }

    public PessoaDTO converterParaPessoaDTO(Pessoa pessoa){
        if (pessoa == null){
            return null;
        }
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setCodigo(pessoaDTO.getCodigo());
        pessoaDTO.setNome(pessoaDTO.getNome());
        pessoaDTO.setAniversario(pessoaDTO.getAniversario());
        pessoaDTO.setEmail(pessoaDTO.getEmail());
        pessoaDTO.setEndereco(enderecoService.concatenarEndereco(pessoa.getEndereco()));
        return pessoaDTO;
    }


    //listar tudo
    public List<PessoaDTO> listarTudo(){
       List<PessoaDTO> lista = new ArrayList<>();
       for (Pessoa pessoa : pessoas){
           lista.add(converterParaPessoaDTO(pessoa));
       }
        return lista;
    }

}
