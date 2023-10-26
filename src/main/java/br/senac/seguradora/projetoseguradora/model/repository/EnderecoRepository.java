package br.senac.seguradora.projetoseguradora.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senac.seguradora.projetoseguradora.model.entidade.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	
}
