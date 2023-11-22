package br.senac.seguradora.projetoseguradora.model.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senac.seguradora.projetoseguradora.model.entidade.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	List<Cliente> findAll(Specification<Cliente> specification);
}
