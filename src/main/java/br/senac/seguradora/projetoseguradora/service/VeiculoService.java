package br.senac.seguradora.projetoseguradora.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.seguradora.projetoseguradora.model.entidade.Veiculo;
import br.senac.seguradora.projetoseguradora.model.seletor.VeiculoSeletor;
import jakarta.transaction.Transactional;

@Service
public class VeiculoService {

	@Transactional
	public List<Veiculo> listarTodos() {
		return null;
	}

	public Veiculo consultarPorId(long longValue) {
		return null;
	}

	public Veiculo inserir(Veiculo novoVeiculo) {
		return null;
	}

	public Object atualizar(Veiculo veiculoParaAtualizar) {
		return null;
	}

	public boolean excluir(Integer id) {
		return false;
	}

	public List<Veiculo> listarComSeletor(VeiculoSeletor seletor) {
		return null;
	}

}
