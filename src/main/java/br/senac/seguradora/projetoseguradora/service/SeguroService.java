package br.senac.seguradora.projetoseguradora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.sc.senac.dw.model.entidade.Produto;
import br.sc.senac.dw.model.specification.ProdutoSpecifications;
import br.senac.seguradora.projetoseguradora.model.entidade.Seguro;
import br.senac.seguradora.projetoseguradora.model.repository.SeguroRepository;
import br.senac.seguradora.projetoseguradora.model.seletor.SeguroSeletor;
import br.senac.seguradora.projetoseguradora.model.specification.SeguroSpecification;
import jakarta.transaction.Transactional;

@Service
public class SeguroService {
	
	private SeguroRepository seguroRepository;

	@Transactional
	public List<Seguro> listarTodos() {
		return seguroRepository.findAll();
	}

	public Seguro listarPorId(Integer id) {
		return seguroRepository.findById(id.longValue()).get();
	}

	public Seguro salvar(Seguro novoSeguro) {
		return seguroRepository.save(novoSeguro);
	}

	public Object atualizar(Seguro seguroPAtualizar) {
		return seguroRepository.save(seguroPAtualizar);
	}

	public boolean excluir(Integer id) {
		seguroRepository.deleteById(id.longValue());
		return true;
	}

	public Seguro consultarPorId(Integer id) {
		return seguroRepository.findById(id.longValue()).get();
	}

	public List<Seguro> listarComSeletor(SeguroSeletor seletor) {
		Specification<Seguro> specification = SeguroSpecification.comFiltros(seletor);
		return seguroRepository.findAll(specification);
	}
}
