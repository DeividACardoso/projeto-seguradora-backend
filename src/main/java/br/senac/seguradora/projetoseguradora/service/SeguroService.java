package br.senac.seguradora.projetoseguradora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.seguradora.projetoseguradora.model.entidade.Seguro;
import br.senac.seguradora.projetoseguradora.model.repository.SeguroRepository;
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
}
