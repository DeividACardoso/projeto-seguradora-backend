package br.senac.seguradora.projetoseguradora.model.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.seguradora.projetoseguradora.model.entidade.Seguro;

public interface SeguroRepository extends JpaRepository<Seguro, Long>{

	List<Seguro> findAll(Specification<Seguro> specification);
	
}
