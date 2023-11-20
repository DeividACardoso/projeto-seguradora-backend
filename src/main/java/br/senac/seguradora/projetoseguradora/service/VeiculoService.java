package br.senac.seguradora.projetoseguradora.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.seguradora.projetoseguradora.model.entidade.Veiculo;
import br.senac.seguradora.projetoseguradora.model.repository.ClienteRepository;
import br.senac.seguradora.projetoseguradora.model.repository.VeiculoRepository;
import br.senac.seguradora.projetoseguradora.model.seletor.VeiculoSeletor;
import jakarta.transaction.Transactional;

@Service
public class VeiculoService {

	private VeiculoRepository veiculoRepository;
	
	@Transactional
	public List<Veiculo> listarTodos() {
		return veiculoRepository.findAll();
	}

	public Veiculo consultarPorId(Long id) {
		return veiculoRepository.findById(id.longValue()).get();
	}

	public Veiculo inserir(Veiculo novoVeiculo) {
		return veiculoRepository.save(novoVeiculo);
	}

	public Object atualizar(Veiculo veiculoParaAtualizar) {
		return veiculoRepository.save(veiculoParaAtualizar);
	}

	public boolean excluir(Long id) {
		veiculoRepository.deleteById(id.longValue());
		return true;
	}

	public List<Veiculo> listarComSeletor(VeiculoSeletor seletor) {
		return null;
	}

}
