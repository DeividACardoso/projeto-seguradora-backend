package br.senac.seguradora.projetoseguradora.controller;

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

import br.senac.seguradora.projetoseguradora.exception.CampoInvalidoException;
import br.senac.seguradora.projetoseguradora.model.entidade.Endereco;
import br.senac.seguradora.projetoseguradora.service.EnderecoService;

@RestController
@RequestMapping(path = "/api/enderecos")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService; 
	
	@GetMapping(path = "/todos")
	public List<Endereco> listarTodosEnderecos(){
		return enderecoService.listarTodos();
	}
	
	@PostMapping(path = "/{id}")
	public Endereco listarPorId(@PathVariable Integer id){
		return enderecoService.listarPorId(id);
	}
	
	@PostMapping(path = "/salvar")
	public Endereco salvar(@RequestBody Endereco novoEndereco) throws CampoInvalidoException {
		return enderecoService.salvar(novoEndereco);
	}
	
	@PutMapping(path = "/atualizar")
	public boolean atualizar(@RequestBody Endereco enderecoParaAtualizar) throws CampoInvalidoException {
		return enderecoService.atualizar(enderecoParaAtualizar) != null;
	}
	
	@DeleteMapping(path = "/delete-id/{id}")
	public boolean excluirPorId(@PathVariable Integer id) {
		return enderecoService.excluirPorId(id);
	}
}
