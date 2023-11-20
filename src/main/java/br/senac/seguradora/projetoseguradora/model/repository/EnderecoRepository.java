package br.senac.seguradora.projetoseguradora.model.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senac.seguradora.projetoseguradora.model.entidade.Cliente;
import br.senac.seguradora.projetoseguradora.model.entidade.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	List<Endereco> findAll(Specification<Endereco> specification);
	
}
