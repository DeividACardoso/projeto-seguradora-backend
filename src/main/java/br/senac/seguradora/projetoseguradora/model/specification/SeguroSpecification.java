package br.senac.seguradora.projetoseguradora.model.specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.senac.seguradora.projetoseguradora.model.entidade.Seguro;
import br.senac.seguradora.projetoseguradora.model.seletor.SeguroSeletor;
import jakarta.persistence.criteria.Predicate;

public class SeguroSpecification {

	public static Specification<Seguro> comFiltros(SeguroSeletor seletor) {
		return (root, query, cb) ->{
			List<Predicate> predicates = new ArrayList<>();
			
			if(seletor.getNomeCliente() != null && !seletor.getNomeCliente().trim().isEmpty()) {
				predicates.add(cb.like(root.join("cliente").get("nome"),
						"%" + seletor.getNomeCliente().toLowerCase() + "%"));
			}
			if(seletor.getPlacaVeiculo() != null && !seletor.getPlacaVeiculo().trim().isEmpty()) {
				predicates.add(cb.like(root.join("veiculo").get("placaVeiculo"),
						"%" + seletor.getPlacaVeiculo() + "%"));
			}
			if(seletor.getNumeroProposta() != null && !seletor.getNumeroProposta().trim().isEmpty()) {
				predicates.add(cb.like(root.get("numeroProposta"),
						"%" + seletor.getNumeroProposta() + "%"));
			}
			//Filtros para dt_inicio_vigencia
			if(seletor.getMenorDataInicio() != null && !seletor.getMenorDataInicio().toString().trim().isEmpty() 
					&& seletor.getMaiorDataInicio() != null && !seletor.getMaiorDataInicio().toString().trim().isEmpty()) { //Filtro para periodo de data de Inicio vigência
				predicates.add(cb.between(root.get("dtInicioVigencia"), seletor.getMenorDataInicio(), seletor.getMaiorDataInicio()));
			} else if(seletor.getMenorDataInicio() != null && !seletor.getMenorDataInicio().toString().trim().isEmpty()){ //Filtro para data inicio de vigência maior que data inserida(se maior, ainda não vigente)
				predicates.add(cb.greaterThanOrEqualTo(root.get("dtInicioVigencia"), seletor.getMenorDataInicio()));
			} else if(seletor.getMaiorDataInicio() != null && !seletor.getMaiorDataInicio().toString().trim().isEmpty()) { //Filtro para data inicio de vigência menor que a data inserida(se menor, vigente) 
				predicates.add(cb.lessThanOrEqualTo(root.get("dtInicioVigencia"), seletor.getMaiorDataInicio()));
			}
			//Filtros para dt_fim_vigencia			
			if(seletor.getMenorDataFim() != null && !seletor.getMenorDataFim().toString().trim().isEmpty() 
					&& seletor.getMaiorDataFim() != null && !seletor.getMaiorDataFim().toString().trim().isEmpty()) { //Filtro para periodo de data de Fim vigência
				predicates.add(cb.between(root.get("dtFimVigencia"), seletor.getMenorDataFim(), seletor.getMaiorDataFim()));
			} else if(seletor.getMenorDataFim() != null && !seletor.getMenorDataFim().toString().trim().isEmpty()){ //Filtro para data fim de vigência maior que data inserida(se maior, ainda vigente)
				predicates.add(cb.greaterThanOrEqualTo(root.get("dtFimVigencia"), seletor.getMenorDataFim()));
			} else if(seletor.getMaiorDataFim() != null && !seletor.getMaiorDataFim().toString().trim().isEmpty()) { //Filtro para data fim de vigência menor que a data inserida (se menor, não mais vigente) 
				predicates.add(cb.lessThanOrEqualTo(root.get("dtFimVigencia"), seletor.getMaiorDataFim()));
			}
			
			if(seletor.getFranquia() != null && !seletor.getFranquia().trim().isEmpty()) {
				predicates.add(cb.like(root.get("franquia"), "%" + seletor.getFranquia().toLowerCase() + "%"));
			}
			if(seletor.getAssistencia() != null && !seletor.getAssistencia().trim().isEmpty()){
				predicates.add(cb.like(root.get("assistencia"), "%" + seletor.getAssistencia().toLowerCase() + "%"));
			}
			if(seletor.getCarroReserva() != null && !seletor.getCarroReserva().trim().isEmpty()) {
				predicates.add(cb.like(root.get("carroReserva"), "%" + seletor.getCarroReserva().toLowerCase() + "%"));
			}
			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
	
	

}
