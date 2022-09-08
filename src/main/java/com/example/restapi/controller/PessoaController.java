package com.example.restapi.controller;

import com.example.restapi.models.Endereco;
import com.example.restapi.models.Pessoa;
import com.example.restapi.service.EnderecoService;
import com.example.restapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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

    @GetMapping("buscar")
    public ResponseEntity buscarPessoa(@RequestParam String codigo){
        Pessoa pessoa = pessoaService.buscarPessoa(codigo);
        if (pessoa == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(pessoa);
        }
    }

    @PostMapping
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.criarPessoa(pessoa);
    }

    @GetMapping("listar-todos")
    public List<Pessoa>  listarTodos(){
        return pessoaService.listarPessoas();
    }

    @DeleteMapping("apagar")
    public Pessoa apagarPessoa(@RequestParam (value = "codigo") String codigo ) {
        return pessoaService.apagarPessoa(codigo);
    }

}
