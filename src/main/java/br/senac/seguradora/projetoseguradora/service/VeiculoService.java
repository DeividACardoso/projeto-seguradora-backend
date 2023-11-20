package br.senac.seguradora.projetoseguradora.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.senac.seguradora.projetoseguradora.exception.CampoInvalidoException;
import br.senac.seguradora.projetoseguradora.model.entidade.Veiculo;
import br.senac.seguradora.projetoseguradora.model.repository.VeiculoRepository;
import br.senac.seguradora.projetoseguradora.model.seletor.VeiculoSeletor;
import br.senac.seguradora.projetoseguradora.model.specification.VeiculoSpecification;
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

	public Veiculo inserir(Veiculo novoVeiculo) throws CampoInvalidoException{
		validarCamposObrigatorios(novoVeiculo);
		return veiculoRepository.save(novoVeiculo);
	}

	private void validarCamposObrigatorios(Veiculo novoVeiculo) throws CampoInvalidoException {
		// TODO Auto-generated method stub
		
	}

	public Object atualizar(Veiculo veiculoParaAtualizar) throws CampoInvalidoException {
		validarCamposObrigatorios(veiculoParaAtualizar);
		return veiculoRepository.save(veiculoParaAtualizar);
	}

	public boolean excluir(Long id) {
		veiculoRepository.deleteById(id.longValue());
		return true;
	}

	public List<Veiculo> listarComSeletor(VeiculoSeletor seletor) {
		Specification<Veiculo> specification = VeiculoSpecification.comFiltros(seletor);
		return veiculoRepository.findAll(specification);
	}

}
