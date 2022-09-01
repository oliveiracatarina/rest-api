package com.example.restapi.models;

import java.time.LocalDate;

public class Pessoa {

    private String codigo;
    private String nome;
    private LocalDate aniversario;
    private String email;
    private Endereco endereco;

    // construtor default
    public Pessoa(){
        this.endereco = new Endereco();
    }

    public Pessoa (String nome, LocalDate aniversario, String email, Endereco endereco){
        this.nome = nome;
        this.aniversario = aniversario;
        this.email = email;
        this.endereco = endereco;
    }


    //método get e set

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }


    public LocalDate getAniversario() {
        return this.aniversario;
    }

    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }



}

