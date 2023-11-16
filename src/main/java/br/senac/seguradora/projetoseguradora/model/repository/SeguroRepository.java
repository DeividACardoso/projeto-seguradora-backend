package br.senac.seguradora.projetoseguradora.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.seguradora.projetoseguradora.model.entidade.Seguro;

public interface SeguroRepository extends JpaRepository<Seguro, Long>{

}
