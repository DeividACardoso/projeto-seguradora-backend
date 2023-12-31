package br.senac.seguradora.projetoseguradora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.senac.seguradora.projetoseguradora.exception.CampoInvalidoException;
import br.senac.seguradora.projetoseguradora.model.entidade.Cliente;
import br.senac.seguradora.projetoseguradora.model.repository.ClienteRepository;
import br.senac.seguradora.projetoseguradora.model.repository.EnderecoRepository;
import br.senac.seguradora.projetoseguradora.model.seletor.ClienteSeletor;
import br.senac.seguradora.projetoseguradora.model.specification.ClienteSpecification;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Transactional
	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}

	public Cliente listarPorId(Integer id) {
		return clienteRepository.findById(id).get();
	}
	
	public Cliente salvar(Cliente novoCliente) throws CampoInvalidoException {
		validarCamposObrigatorios(novoCliente);
		if(novoCliente.getCpf() != null) {
			removerMascara(novoCliente);
		}
		
		if(novoCliente.getEndereco().getId() == null) {
			novoCliente.setEndereco(enderecoRepository.save(novoCliente.getEndereco()));
		}
		return clienteRepository.save(novoCliente);
	}
	
	private void removerMascara(Cliente novoCliente) {
        // Define the regex pattern
        String regex = "[\\s.\\-\\(\\)]+";
        System.out.println("Sem tirar Mascara: " + novoCliente.getCpf() + " " + novoCliente.getTelefone());
		String cpfSemMascara = novoCliente.getCpf().replaceAll(regex, "");
		String telefoneSemMascara = novoCliente.getTelefone().replaceAll(regex, "");
		novoCliente.setCpf(cpfSemMascara);
		novoCliente.setTelefone(telefoneSemMascara);
		System.out.println("Sem Mascara: " + novoCliente.getCpf() + " " + novoCliente.getTelefone());
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
		
		if(cliente.getEndereco() == null) {
			mensagemValidacao += "Informe o endereço";
		}
		
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
		boolean seguroVigente = verificarSeguroVigente();
		if(!seguroVigente) {
			clienteRepository.deleteById(id);
		}
		return seguroVigente;
	}

	private boolean verificarSeguroVigente() {
		return true;
	}

	public List<Cliente> listarComSeletor(ClienteSeletor seletor) {
		if(seletor.getCpf() != null) {
			removerMascaraDoSeletor(seletor);
		}
		Specification<Cliente> specification = ClienteSpecification.comFiltros(seletor);
		return clienteRepository.findAll(specification);
	}

	private void removerMascaraDoSeletor(ClienteSeletor seletor) {
        String regex = "[\\s.\\-\\(\\)]+";
        System.out.println("Sem tirar Mascara: " + seletor.getCpf());
        String cpfSemMascara = seletor.getCpf().replaceAll(regex, "");
		seletor.setCpf(cpfSemMascara);
		System.out.println("Sem Mascara: " + seletor.getCpf());
	}
	
}
