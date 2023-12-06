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

import br.senac.seguradora.projetoseguradora.model.entidade.Seguro;
import br.senac.seguradora.projetoseguradora.model.seletor.SeguroSeletor;
import br.senac.seguradora.projetoseguradora.service.SeguroService;

@RestController
@RequestMapping(path = "/api/seguros")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
 class SeguroController {

	@Autowired
	private SeguroService seguroService;
		
	@GetMapping(path = "/todos")
	public List<Seguro> listarTodos(){
		return seguroService.listarTodos();
	}
	
	@PostMapping("/filtro")
	public List<Seguro> listarComSeletor(@RequestBody SeguroSeletor seletor){
		return seguroService.listarComSeletor(seletor);
	}
	
	@GetMapping(path = "/{id}")
	public Seguro listarPorId(@PathVariable Integer id) {
		return seguroService.listarPorId(id);
	}
	
	@PostMapping
	public Seguro salvar(@RequestBody Seguro novoSeguro){
		return seguroService.salvar(novoSeguro);
	}
	
	@PutMapping
	public boolean atualizar(@RequestBody Seguro seguroPAtualizar){
		return seguroService.atualizar(seguroPAtualizar) != null;
	}
	
	@DeleteMapping("/delete-id/{id}")
	public boolean excluir(@PathVariable Integer id) {
		return seguroService.excluir(id);
	}
	
}
