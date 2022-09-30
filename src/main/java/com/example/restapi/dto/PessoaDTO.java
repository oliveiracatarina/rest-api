package com.example.restapi.dto;

import com.example.restapi.models.Endereco;

import java.time.LocalDate;

public class PessoaDTO {

    private String codigo;
    private String nome;
    private LocalDate aniversario;
    private String email;
    private String endereco;
    //endereco= logradour +", Nº:" + numero+", bairro: "+bairro+", cidade: "+cidade+", Estado: +
    //
    //"+estado+", CEP: "+cep


    //getters e setters
    public String getCodigo() {
        return this.codigo;
    }
    public void setCodigo (String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome (String nome) {
        this.nome = nome;
    }

    public LocalDate getAniversario() {
        return this.aniversario;
    }
    public void setAniversario (LocalDate aniversario){
        this.aniversario = aniversario;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getEndereco() {
        return this.endereco;
    }
    public void setEndereco (String endereco){
        this.endereco = endereco;
    }
}