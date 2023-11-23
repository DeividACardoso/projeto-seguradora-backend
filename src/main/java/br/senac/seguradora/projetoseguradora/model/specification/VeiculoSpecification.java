package br.senac.seguradora.projetoseguradora.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.senac.seguradora.projetoseguradora.model.entidade.Veiculo;
import br.senac.seguradora.projetoseguradora.model.seletor.VeiculoSeletor;
import jakarta.persistence.criteria.Predicate;

public class VeiculoSpecification {

	public static Specification<Veiculo> comFiltros(VeiculoSeletor seletor) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			
			if(seletor.getMarca() != null && !seletor.getMarca().trim().isEmpty()) {
				predicates.add(cb.like(root.get("marca"), "%" + seletor.getMarca().toLowerCase() + "%"));
			}
			if(seletor.getModelo() != null && !seletor.getModelo().trim().isEmpty()) {
				predicates.add(cb.like(root.get("modelo"), "%" + seletor.getModelo() + "%"));
			}
			if(seletor.getPlacaVeiculo() != null && !seletor.getPlacaVeiculo().trim().isEmpty()) {
				predicates.add(cb.like(root.get("placaVeiculo"), "%" + seletor.getPlacaVeiculo() + "%"));
			}
			
			if(seletor.getMenorValor() != null && seletor.getMaiorValor() != null) {
            	predicates.add(cb.between(root.get("valor"), seletor.getMenorValor(), seletor.getMaiorValor()));
            } else if(seletor.getMenorValor() != null) {
            	predicates.add(cb.greaterThanOrEqualTo(root.get("valor"), seletor.getMenorValor()));
            } else if(seletor.getMaiorValor() != null) {
            	predicates.add(cb.lessThanOrEqualTo(root.get("valor"), seletor.getMaiorValor()));
            }
			
			if(seletor.getMenorAnoModelo() != null && seletor.getMaiorAnoModelo() != null) {
            	predicates.add(cb.between(root.get("ano"), seletor.getMenorAnoModelo(), seletor.getMaiorAnoModelo()));
            } else if(seletor.getMenorAnoModelo() != null) {
            	predicates.add(cb.greaterThanOrEqualTo(root.get("ano"), seletor.getMenorAnoModelo()));
            } else if(seletor.getMaiorAnoModelo() != null) {
            	predicates.add(cb.lessThanOrEqualTo(root.get("ano"), seletor.getMaiorAnoModelo()));
            }
			
			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
	
	

}
