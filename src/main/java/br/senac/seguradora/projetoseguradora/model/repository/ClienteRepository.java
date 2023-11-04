package br.senac.seguradora.projetoseguradora.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.seguradora.projetoseguradora.model.entidade.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
