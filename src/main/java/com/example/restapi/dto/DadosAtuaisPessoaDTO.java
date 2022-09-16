package com.example.restapi.dto;

import java.time.LocalDate;

public class DadosAtuaisPessoaDTO {
    private String nome;
    private String email;
    private LocalDate aniversario;


    //get e set

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public LocalDate getAniversario(){
        return this.aniversario;
    }
    public void setAniversario(LocalDate aniversario){
        this.aniversario = aniversario;
    }
}
