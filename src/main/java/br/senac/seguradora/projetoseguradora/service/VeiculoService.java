package br.senac.seguradora.projetoseguradora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Transactional
	public List<Veiculo> listarTodos() {
		return veiculoRepository.findAll();
	}

	public Veiculo consultarPorId(Integer id) {
		return veiculoRepository.findById(id).get();
	}

	public Veiculo inserir(Veiculo novoVeiculo) throws CampoInvalidoException{
		validarCamposObrigatorios(novoVeiculo);
		return veiculoRepository.save(novoVeiculo);
	}

	private void validarCamposObrigatorios(Veiculo novoVeiculo) throws CampoInvalidoException {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoString(novoVeiculo.getMarca(), "marca");
		mensagemValidacao += validarCampoString(novoVeiculo.getModelo(), "modelo");
		mensagemValidacao += validarCampoInteger(novoVeiculo.getAnoModelo(), "anoModelo");
		//anoModelo: menorAnoModelo e maiorAnoModelo?
		mensagemValidacao += validarCampoDouble(novoVeiculo.getValor(), "valor");
		//valor: menorValor e maiorValor?
		mensagemValidacao += validarCampoString(novoVeiculo.getPlacaVeiculo(), "placaVeiculo");
		
		if(!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}

	private String validarCampoInteger(Integer valorCampo, String nomeCampo) {
		if(valorCampo == null) {
			return "Informe: " + nomeCampo + ", \n";
		}
		return "";
	}

	private String validarCampoString(String valorCampo, String nomeCampo) {
		if(valorCampo == null || valorCampo.trim().isEmpty()) {
			return "Informe: " + nomeCampo + ", \n";
		}
		return "";
	}
	
	private String validarCampoDouble(Double valorCampo, String nomeCampo) {
		if(valorCampo == null) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}

	public Object atualizar(Veiculo veiculoParaAtualizar) throws CampoInvalidoException {
		validarCamposObrigatorios(veiculoParaAtualizar);
		return veiculoRepository.save(veiculoParaAtualizar);
	}

	public boolean excluir(Integer id) {
		veiculoRepository.deleteById(id);
		return true;
	}

	public List<Veiculo> listarComSeletor(VeiculoSeletor seletor) {
		Specification<Veiculo> specification = VeiculoSpecification.comFiltros(seletor);
		return veiculoRepository.findAll(specification);
	}

}
