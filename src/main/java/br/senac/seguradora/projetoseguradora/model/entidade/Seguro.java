package br.senac.seguradora.projetoseguradora.model.entidade;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
public class Seguro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	@OneToOne
	@JoinColumn(name = "id_veiculo")
	private Veiculo veiculo;
	private String numeroProposta;
	private LocalDate dataInicioVigencia;
	private LocalDate dataFimVigencia;
	private double rcfDanosMateriais;
	private double rcfDanosCorporais;
	private String franquia;
	private String assistencia;
	private String carroReserva;
	
	public Seguro(Integer id, Cliente cliente, Veiculo veiculo, String numeroProposta, LocalDate dataInicioVigencia,
			LocalDate dataFimVigencia, double rcfDanosMateriais, double rcfDanosCorporais, String franquia,
			String assistencia, String carroReserva) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.numeroProposta = numeroProposta;
		this.dataInicioVigencia = dataInicioVigencia;
		this.dataFimVigencia = dataFimVigencia;
		this.rcfDanosMateriais = rcfDanosMateriais;
		this.rcfDanosCorporais = rcfDanosCorporais;
		this.franquia = franquia;
		this.assistencia = assistencia;
		this.carroReserva = carroReserva;
	}
	public Seguro() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public String getNumeroProposta() {
		return numeroProposta;
	}
	public void setNumeroProposta(String numeroProposta) {
		this.numeroProposta = numeroProposta;
	}
	public LocalDate getDataInicioVigencia() {
		return dataInicioVigencia;
	}
	public void setDataInicioVigencia(LocalDate dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}
	public LocalDate getDataFimVigencia() {
		return dataFimVigencia;
	}
	public void setDataFimVigencia(LocalDate dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}
	public double getRcfDanosMateriais() {
		return rcfDanosMateriais;
	}
	public void setRcfDanosMateriais(double rcfDanosMateriais) {
		this.rcfDanosMateriais = rcfDanosMateriais;
	}
	public double getRcfDanosCorporais() {
		return rcfDanosCorporais;
	}
	public void setRcfDanosCorporais(double rcfDanosCorporais) {
		this.rcfDanosCorporais = rcfDanosCorporais;
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
