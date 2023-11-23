package br.senac.seguradora.projetoseguradora.model.seletor;


public class VeiculoSeletor extends BaseSeletor{

	private String marca;
	private String modelo;
	private String placaVeiculo;
	private Integer menorAnoModelo;
	private Integer maiorAnoModelo;
	private String combustivel;
	private Double menorValor;
	private Double maiorValor;
	
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
	public Integer getMenorAnoModelo() {
		return menorAnoModelo;
	}
	public void setMenorAnoModelo(Integer menorAnoModelo) {
		this.menorAnoModelo = menorAnoModelo;
	}
	public Integer getMaiorAnoModelo() {
		return maiorAnoModelo;
	}
	public void setMaiorAnoModelo(Integer maiorAnoModelo) {
		this.maiorAnoModelo = maiorAnoModelo;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public Double getMenorValor() {
		return menorValor;
	}
	public void setMenorValor(Double menorValor) {
		this.menorValor = menorValor;
	}
	public Double getMaiorValor() {
		return maiorValor;
	}
	public void setMaiorValor(Double maiorValor) {
		this.maiorValor = maiorValor;
	}
	
}
