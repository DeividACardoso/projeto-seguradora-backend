package br.senac.seguradora.projetoseguradora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.seguradora.projetoseguradora.model.entidade.Endereco;
import br.senac.seguradora.projetoseguradora.model.repository.EnderecoRepository;
import jakarta.transaction.Transactional;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Transactional
	public List<Endereco> listarTodos() {
		return enderecoRepository.findAll();
	}

	public Endereco listarPorId(Integer id) {
		return enderecoRepository.findById(id).get();
	}

	public Endereco salvar(Endereco novoEndereco) {
		return enderecoRepository.save(novoEndereco);
	}

	public Object atualizar(Endereco enderecoParaAtualizar) {
		return enderecoRepository.save(enderecoParaAtualizar);
	}

	public boolean excluirPorId(Integer id) {
		enderecoRepository.deleteById(id);
		return true;
	}

}
