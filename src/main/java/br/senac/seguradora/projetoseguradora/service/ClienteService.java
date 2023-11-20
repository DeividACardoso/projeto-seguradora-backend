package br.senac.seguradora.projetoseguradora.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.senac.seguradora.projetoseguradora.exception.CampoInvalidoException;
import br.senac.seguradora.projetoseguradora.model.entidade.Cliente;
import br.senac.seguradora.projetoseguradora.model.repository.ClienteRepository;
import br.senac.seguradora.projetoseguradora.model.seletor.ClienteSeletor;
import br.senac.seguradora.projetoseguradora.model.specification.ClienteSpecification;
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
	
	public Cliente salvar(Cliente novoCliente) throws CampoInvalidoException {
		validarCamposObrigatorios(novoCliente);
		return clienteRepository.save(novoCliente);
	}
	
	public Object atualizar(Cliente clienteParaAtualizar) throws CampoInvalidoException {
		validarCamposObrigatorios(clienteParaAtualizar);
		return clienteRepository.save(clienteParaAtualizar);
	}

	private void validarCamposObrigatorios(Cliente cliente) throws CampoInvalidoException {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoString(cliente.getNome(), "nome");
		mensagemValidacao += validarCampoString(cliente.getCpf(), "cpf");
		mensagemValidacao += validarCampoString(cliente.getTelefone(), "telefone");
		
		if(!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}
	private String validarCampoString(String valorCampo, String nomeCampo) {
		if(valorCampo == null || valorCampo.trim().isEmpty()) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}

	public boolean excluirPorId(Integer id) {
		clienteRepository.deleteById(id.longValue());
		return true;
	}

	public List<Cliente> listarComSeletor(ClienteSeletor seletor) {
		Specification<Cliente> specification = ClienteSpecification.comFiltros(seletor);
		return clienteRepository.findAll(specification);
	}
	
}
