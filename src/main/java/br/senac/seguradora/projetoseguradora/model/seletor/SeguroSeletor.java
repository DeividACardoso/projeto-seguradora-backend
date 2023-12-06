package br.senac.seguradora.projetoseguradora.model.seletor;

import java.time.LocalDate;

import br.senac.seguradora.projetoseguradora.model.entidade.Cliente;
import br.senac.seguradora.projetoseguradora.model.entidade.Veiculo;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class SeguroSeletor extends BaseSeletor{
	
	private String cpfCliente;
	private String placaVeiculo;
	private String numeroProposta;
	private LocalDate dtInicioComecoVigencia;
	private LocalDate dtFimComecoVigencia;
	private LocalDate dtInicioFimVigencia;
	private LocalDate dtFimFimVigencia;
	private String franquia;
	private String assistencia;
	private String carroReserva;
	
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
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
	public LocalDate getDtInicioComecoVigencia() {
		return dtInicioComecoVigencia;
	}
	public void setDtInicioComecoVigencia(LocalDate dtInicioComecoVigencia) {
		this.dtInicioComecoVigencia = dtInicioComecoVigencia;
	}
	public LocalDate getDtFimComecoVigencia() {
		return dtFimComecoVigencia;
	}
	public void setDtFimComecoVigencia(LocalDate dtFimComecoVigencia) {
		this.dtFimComecoVigencia = dtFimComecoVigencia;
	}
	public LocalDate getDtInicioFimVigencia() {
		return dtInicioFimVigencia;
	}
	public void setDtInicioFimVigencia(LocalDate dtInicioFimVigencia) {
		this.dtInicioFimVigencia = dtInicioFimVigencia;
	}
	public LocalDate getDtFimFimVigencia() {
		return dtFimFimVigencia;
	}
	public void setDtFimFimVigencia(LocalDate dtFimFimVigencia) {
		this.dtFimFimVigencia = dtFimFimVigencia;
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
