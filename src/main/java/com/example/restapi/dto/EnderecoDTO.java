package com.example.restapi.dto;

public class EnderecoDTO {
    private String endereco = "logradouro" + "numero" + "cep" + "bairro" + "cidade" + "estado";


    public String getEndereco(){
        return this.endereco;
    }

    public void setEndereco (String endereco){
        this.endereco = endereco;
    }
}
