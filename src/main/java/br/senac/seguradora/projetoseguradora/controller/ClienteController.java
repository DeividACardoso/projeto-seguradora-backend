package br.senac.seguradora.projetoseguradora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.seguradora.projetoseguradora.model.entidade.Cliente;
import br.senac.seguradora.projetoseguradora.service.ClienteService;

@RestController
@RequestMapping(path = "/api/clientes")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(path = "/todos")
	public List<Cliente> listarTodosClientes(){
		return clienteService.listarTodos();
	}
	
	@PostMapping(path = "/{id}")
	public Cliente listarPorId(@PathVariable Integer id) {
		return clienteService.listarPorId(id.longValue());
	}
	
	@PostMapping
	public Cliente salvar(@RequestBody Cliente novoCliente) {
		return clienteService.salvar(novoCliente);
	}
	
	@PutMapping
	public boolean atualizar(@RequestBody Cliente clienteParaAtualizar) {
		return clienteService.atualizar(clienteParaAtualizar) != null;
	}
	
	//TODO Exclusão Lógica de Clientes.
}
