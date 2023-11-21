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
import br.senac.seguradora.projetoseguradora.model.entidade.Veiculo;
import br.senac.seguradora.projetoseguradora.model.seletor.VeiculoSeletor;
import br.senac.seguradora.projetoseguradora.service.VeiculoService;


@RestController
@RequestMapping(path = "/api/veiculos") // shorthand for @Controller and @ResponseBody rolled together
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
public class VeiculoController {
	
		@Autowired 
		private VeiculoService veiculoService;
		
		@GetMapping
		public List<Veiculo> listarTodos() {
			List<Veiculo> veiculos = veiculoService.listarTodos();
			return veiculos;
		}
		
		@PostMapping("/filtro")
		public List<Veiculo> listarComSeletor(@RequestBody VeiculoSeletor seletor){
			return veiculoService.listarComSeletor(seletor);
		}

		@GetMapping("/{id}")
		public Veiculo pesquisarPorId(@PathVariable Integer id){
			return veiculoService.consultarPorId(id.longValue());
		}
		
		@PostMapping
		public Veiculo salvar(@RequestBody Veiculo novoVeiculo) throws CampoInvalidoException {
			return veiculoService.inserir(novoVeiculo);
		}

		@PutMapping()
		public boolean atualizar(@RequestBody Veiculo veiculoParaAtualizar) throws CampoInvalidoException {
			return veiculoService.atualizar(veiculoParaAtualizar) != null;
		}
		
		@DeleteMapping("/{id}")
		public boolean excluir(@PathVariable Long id) {
			return veiculoService.excluir(id);
		}
		
		@DeleteMapping("/{cpf}")
		public boolean excluirPorCpf(@PathVariable String cpf) {
			return false;
		}
	
}
