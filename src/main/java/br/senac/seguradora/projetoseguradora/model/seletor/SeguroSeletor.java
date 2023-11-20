package br.senac.seguradora.projetoseguradora.model.seletor;

import java.time.LocalDate;

import br.senac.seguradora.projetoseguradora.model.entidade.Cliente;
import br.senac.seguradora.projetoseguradora.model.entidade.Veiculo;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class SeguroSeletor extends BaseSeletor{
	
	private String nomeCliente;
	private String placaVeiculo;
	private String numeroProposta;
	private LocalDate dtInicioVigencia;
	private LocalDate dtFimVigencia;
	private String franquia;
	private String assistencia;
	private String carroReserva;
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	public String getNumeroProposta() {
		return numeroProposta;
	}
	public void setNumeroProposta(String numeroProposta) {
		this.numeroProposta = numeroProposta;
	}
	public LocalDate getDtInicioVigencia() {
		return dtInicioVigencia;
	}
	public void setDtInicioVigencia(LocalDate dtInicioVigencia) {
		this.dtInicioVigencia = dtInicioVigencia;
	}
	public LocalDate getDtFimVigencia() {
		return dtFimVigencia;
	}
	public void setDtFimVigencia(LocalDate dtFimVigencia) {
		this.dtFimVigencia = dtFimVigencia;
	}
	public String getFranquia() {
		return franquia;
	}
	public void setFranquia(String franquia) {
		this.franquia = franquia;
	}
	public String getAssistencia() {
		return assistencia;
	}
	public void setAssistencia(String assistencia) {
		this.assistencia = assistencia;
	}
	public String getCarroReserva() {
		return carroReserva;
	}
	public void setCarroReserva(String carroReserva) {
		this.carroReserva = carroReserva;
	}
	
	
}
