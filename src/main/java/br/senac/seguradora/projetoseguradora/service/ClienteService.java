package br.senac.seguradora.projetoseguradora.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.seguradora.projetoseguradora.model.entidade.Cliente;
import br.senac.seguradora.projetoseguradora.model.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	private ClienteRepository clienteRepository;
	
	@Transactional
	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}

	public Cliente listarPorId(Long id) {
		return clienteRepository.findById(id.longValue()).get();
	}
	
	public Cliente salvar(Cliente novoCliente) {
		return clienteRepository.save(novoCliente);
	}
	
	public Object atualizar(Cliente clienteParaAtualizar) {
		return clienteRepository.save(clienteParaAtualizar);
	}

	public boolean excluirPorId(Integer id) {
		clienteRepository.deleteById(id.longValue());
		return true;
	}
	
}