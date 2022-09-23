package com.example.restapi.controller;

import com.example.restapi.dto.DadosAtuaisPessoaDTO;
import com.example.restapi.dto.PessoaDTO;
import com.example.restapi.models.Endereco;
import com.example.restapi.models.Pessoa;
import com.example.restapi.service.EnderecoService;
import com.example.restapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            PessoaDTO pessoaDTO = new PessoaDTO();
            pessoaDTO.setCodigo(pessoaDTO.getCodigo());
            pessoaDTO.setNome(pessoaDTO.getNome());
            pessoaDTO.setAniversario(pessoaDTO.getAniversario());
            pessoaDTO.setEmail(pessoaDTO.getEmail());
            pessoaDTO.setEndereco(pessoa.getEndereco().getLogradouro() +", " + pessoa.getEndereco().getNumero() + ", " +
                    pessoa.getEndereco().getBairro() + ", " + pessoa.getEndereco().getCep() + "," +
                    pessoa.getEndereco().getCidade() + ", " + pessoa.getEndereco().getEstado());
            return ResponseEntity.status(HttpStatus.OK).body(pessoaDTO);
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
    public PessoaDTO apagarPessoa(@RequestParam (value = "codigo") String codigo ) {
        Pessoa pessoa = pessoaService.apagarPessoa(codigo);
        if (pessoa != null){
            return pessoaService.converterParaPessoaDTO(pessoa);
        }
        return null;
    }

    @DeleteMapping
    public ResponseEntity apagarPessoaPorIndice(@RequestParam (value = "codigo") String codigo){
       Pessoa pessoa = pessoaService.apagarPessoaPorIndice(codigo);
       if (pessoa != null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
       } else {
           return ResponseEntity.ok().body(pessoaService.converterParaPessoaDTO(pessoa));
       }

    }

    @PutMapping("/{codigo}")
    public ResponseEntity atualizarPessoa(@PathVariable String codigo,
                                                  @RequestBody DadosAtuaisPessoaDTO dadosAtuais) {
        Pessoa pessoa = pessoaService.atualizarPessoa(codigo, dadosAtuais);
        if (pessoa == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        } else {
            return ResponseEntity.ok().body(pessoa);
        }
    }

}
