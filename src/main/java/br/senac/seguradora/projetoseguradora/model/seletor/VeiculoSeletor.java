package br.senac.seguradora.projetoseguradora.model.seletor;

import java.time.LocalDate;

public class VeiculoSeletor {

	private String marca;
	private String modelo;
	private String placaVeiculo;
	private LocalDate anoModelo;
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	public LocalDate getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(LocalDate anoModelo) {
		this.anoModelo = anoModelo;
	}
	
}
