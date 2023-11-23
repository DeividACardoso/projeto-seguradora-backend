package br.senac.seguradora.projetoseguradora.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.senac.seguradora.projetoseguradora.model.entidade.Cliente;
import br.senac.seguradora.projetoseguradora.model.seletor.ClienteSeletor;
import jakarta.persistence.criteria.Predicate;

public class ClienteSpecification {
	
	public static Specification<Cliente> comFiltros(ClienteSeletor seletor){
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			
			if(seletor.getNome() != null && !seletor.getNome().trim().isEmpty()) {
				predicates.add(cb.like(root.get("nome"),
						"%" + seletor.getNome().toLowerCase() + "%"));
			}
			
			if(seletor.getCpf() != null && !seletor.getCpf().trim().isEmpty()) {
				predicates.add(cb.like(root.get("cpf"),
						"%" + seletor.getCpf() + "%"));
			}
			if(seletor.getDataNascimentoInicial() != null && !seletor.getDataNascimentoInicial().toString().trim().isEmpty()
            		&& seletor.getDataNascimentoFinal() != null && !seletor.getDataNascimentoFinal().toString().trim().isEmpty()) {
            	predicates.add(cb.between(root.get("dataNascimento"), seletor.getDataNascimentoInicial(), seletor.getDataNascimentoFinal()));
            } else if(seletor.getDataNascimentoInicial() != null && !seletor.getDataNascimentoInicial().toString().trim().isEmpty()) { // Data >= Dt_Inicial
            	predicates.add(cb.greaterThanOrEqualTo(root.get("dataNascimento"), seletor.getDataNascimentoInicial()));
            } else if(seletor.getDataNascimentoFinal() != null && !seletor.getDataNascimentoFinal().toString().trim().isEmpty()) { // Data <= Dt_Final
            	predicates.add(cb.lessThanOrEqualTo(root.get("dataNascimento"), seletor.getDataNascimentoFinal()));
            }
			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
}
