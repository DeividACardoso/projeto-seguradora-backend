package br.senac.seguradora.projetoseguradora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.senac.seguradora.projetoseguradora.exception.CampoInvalidoException;
import br.senac.seguradora.projetoseguradora.model.entidade.Seguro;
import br.senac.seguradora.projetoseguradora.model.repository.SeguroRepository;
import br.senac.seguradora.projetoseguradora.model.seletor.SeguroSeletor;
import br.senac.seguradora.projetoseguradora.model.specification.SeguroSpecification;
import jakarta.transaction.Transactional;

@Service
public class SeguroService {
	
	@Autowired
	private SeguroRepository seguroRepository;

	@Transactional
	public List<Seguro> listarTodos() {
		return seguroRepository.findAll();
	}

	public Seguro listarPorId(Integer id) {
		return seguroRepository.findById(id).get();
	}

	public Seguro salvar(Seguro novoSeguro) throws CampoInvalidoException {
		validarCamposObrigatorios(novoSeguro);
		return seguroRepository.save(novoSeguro);
	}

	private void validarCamposObrigatorios(Seguro novoSeguro) throws CampoInvalidoException {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoString(novoSeguro.getFranquia(), "franquia");
		mensagemValidacao += validarCampoString(novoSeguro.getAssistencia(), "assistencia");
		mensagemValidacao += validarCampoString(novoSeguro.getCarroReserva(), "carro_reserva");
//		mensagemValidacao += validarCampoString(novoSeguro.getDtInicioVigencia().toString(), "data_inicio_vigencia");
//		mensagemValidacao += validarCampoString(novoSeguro.getDtFimVigencia().toString(), "data_fim_vigencia");
		
		if(novoSeguro.getCliente() == null) {
			mensagemValidacao += "Informe o cliente, \n";
		}
		if(novoSeguro.getVeiculo() == null) {
			mensagemValidacao += "Informe o veículo. \n";
		}
		
		if(!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}

	private String validarCampoString(String valorCampo, String nomeCampo) {
		if(valorCampo == null || valorCampo.trim().isEmpty()) {
			return "Informe: " + nomeCampo + ", \n";
		}
		return "";
	}

	public Object atualizar(Seguro seguroPAtualizar) {
		return seguroRepository.save(seguroPAtualizar);
	}

	public boolean excluir(Integer id) {
		seguroRepository.deleteById(id);
		return true;
	}

	public Seguro consultarPorId(Integer id) {
		return seguroRepository.findById(id).get();
	}

	public List<Seguro> listarComSeletor(SeguroSeletor seletor) {
		Specification<Seguro> specification = SeguroSpecification.comFiltros(seletor);
		return seguroRepository.findAll(specification);
	}
}
