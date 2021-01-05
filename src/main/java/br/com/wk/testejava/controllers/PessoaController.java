package br.com.wk.testejava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wk.testejava.models.Pessoa;
import br.com.wk.testejava.repository.PessoaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API pessoas")
@CrossOrigin(origins = "*")
public class PessoaController {

	@Autowired
	PessoaRepository service;
	
	@GetMapping(value = "/pessoas")
	@ApiOperation(value = "Retorna uma lista com todas as pessoas presentes no banco.")
	public List<Pessoa> listarPessoas(){
		return service.findAll();
	}
	
	@GetMapping(value = "/pessoa/{id}")
	@ApiOperation(value = "Retorna uma única pessoa.")
	public Pessoa pegarPessoa(@PathVariable(value = "id") long id){
		return service.findById(id);
	}
	
	@PostMapping(value = "/pessoa")
	@ApiOperation(value = "Salva uma nova pessoa no banco.")
	public Pessoa salvarPessoa(@RequestBody Pessoa pessoa) {
		return service.save(pessoa);
	}
	
	@DeleteMapping(value = "/pessoa")
	@ApiOperation(value = "Exclui uma pessoa do banco.")
	public void apagarPessoa(@RequestBody Pessoa pessoa) {
		service.delete(pessoa);
	}
	
	@PutMapping(value = "/pessoa")
	@ApiOperation(value = "Atualiza as informações de uma pessoa.")
	public Pessoa alterarPessoa(@RequestBody Pessoa pessoa) {
		return service.save(pessoa);
	}
	
	
}
