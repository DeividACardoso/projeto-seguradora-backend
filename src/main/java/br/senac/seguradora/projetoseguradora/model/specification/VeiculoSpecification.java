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
			if(seletor.getAnoModelo() != null && !seletor.getAnoModelo().toString().trim().isEmpty()){
            	predicates.add(cb.between(root.get("anoModelo"), seletor.getAnoModelo(), seletor.getAnoModelo()));
            } 
			if(seletor.getPlacaVeiculo() != null && !seletor.getPlacaVeiculo().trim().isEmpty()) {
				predicates.add(cb.like(root.get("placaVeiculo"), "%" + seletor.getPlacaVeiculo() + "%"));
			}
			if(seletor.getValor() != null && seletor.getValor() != null) {
            	Predicate predicadoNovo = cb.between(root.get("valor"), seletor.getValor(), seletor.getValor());
            	predicates.add(predicadoNovo);
            }
			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
	
	

}
