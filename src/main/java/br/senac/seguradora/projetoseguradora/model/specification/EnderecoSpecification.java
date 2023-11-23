package br.senac.seguradora.projetoseguradora.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.senac.seguradora.projetoseguradora.model.entidade.Endereco;
import br.senac.seguradora.projetoseguradora.model.seletor.EnderecoSeletor;
import jakarta.persistence.criteria.Predicate;

public class EnderecoSpecification {
	
	public static Specification<Endereco> comFiltros(EnderecoSeletor seletor) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			
//			if(seletor.getNumero() != null && !seletor.getNumero().trim().isEmpty()) {
//				predicates.add(cb.like(root.get("numero"), "%" + seletor.getNumero() + "%"));
//			}
			if(seletor.getNumero()!= null && !seletor.getNumero().isEmpty()) {
            	predicates.add(cb.equal(root.join("numero"), seletor.getNumero()));
            }
//			if(seletor.getCep() != null && !seletor.getCep().trim().isEmpty()) {
//				predicates.add(cb.like(root.get("cep"), "%" + seletor.getCep() + "%"));
//			}
			if(seletor.getCep()!= null && !seletor.getCep().isEmpty()) {
            	predicates.add(cb.equal(root.join("cep"), seletor.getCep()));
            }
			if(seletor.getRua() != null && !seletor.getRua().trim().isEmpty()) {
				predicates.add(cb.like(root.get("rua"), "%" + seletor.getRua() + "%"));
			} 
			if(seletor.getBairro() != null && !seletor.getBairro().trim().isEmpty()) {
				predicates.add(cb.like(root.get("bairro"), "%" + seletor.getBairro() + "%"));
			}
			if(seletor.getCidade() != null && !seletor.getCidade().trim().isEmpty()) {
				predicates.add(cb.like(root.get("cidade"), "%" + seletor.getCidade() + "%"));
			}
			if(seletor.getEstado() != null && !seletor.getEstado().trim().isEmpty()) {
				predicates.add(cb.like(root.get("estado"), "%" + seletor.getEstado() + "%"));
			}
			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

}
