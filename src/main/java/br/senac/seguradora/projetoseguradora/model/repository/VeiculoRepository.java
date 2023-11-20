package br.senac.seguradora.projetoseguradora.model.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.seguradora.projetoseguradora.model.entidade.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

	List<Veiculo> findAll(Specification<Veiculo> specification);
	
}
