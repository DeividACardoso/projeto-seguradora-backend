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
			
			if(seletor.getCpfCliente() != null && !seletor.getCpfCliente().trim().isEmpty()) {
				predicates.add(cb.like(root.join("cliente").get("cpf"),
						"%" + seletor.getCpfCliente().toLowerCase() + "%"));
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
			if(seletor.getDtInicioComecoVigencia() != null && !seletor.getDtInicioComecoVigencia().toString().trim().isEmpty() 
					&& seletor.getDtFimComecoVigencia() != null && !seletor.getDtFimComecoVigencia().toString().trim().isEmpty()) { //Filtro para periodo de data de Inicio vigência
				predicates.add(cb.between(root.get("dtInicioVigencia"), seletor.getDtInicioComecoVigencia(), seletor.getDtFimComecoVigencia()));
			} else if(seletor.getDtInicioComecoVigencia() != null && !seletor.getDtInicioComecoVigencia().toString().trim().isEmpty()){ //Filtro para data inicio de vigência maior que data inserida(se maior, ainda não vigente)
				predicates.add(cb.greaterThanOrEqualTo(root.get("dtInicioVigencia"), seletor.getDtInicioComecoVigencia()));
			} else if(seletor.getDtFimComecoVigencia() != null && !seletor.getDtFimComecoVigencia().toString().trim().isEmpty()) { //Filtro para data inicio de vigência menor que a data inserida(se menor, vigente) 
				predicates.add(cb.lessThanOrEqualTo(root.get("dtInicioVigencia"), seletor.getDtFimComecoVigencia()));
			}
			//Filtros para dt_fim_vigencia			
			if(seletor.getDtInicioFimVigencia() != null && !seletor.getDtInicioFimVigencia().toString().trim().isEmpty() 
					&& seletor.getDtFimFimVigencia() != null && !seletor.getDtFimFimVigencia().toString().trim().isEmpty()) { //Filtro para periodo de data de Fim vigência
				predicates.add(cb.between(root.get("dtFimVigencia"), seletor.getDtInicioFimVigencia(), seletor.getDtFimFimVigencia()));
			} else if(seletor.getDtInicioFimVigencia() != null && !seletor.getDtInicioFimVigencia().toString().trim().isEmpty()){ //Filtro para data fim de vigência maior que data inserida(se maior, ainda vigente)
				predicates.add(cb.greaterThanOrEqualTo(root.get("dtFimVigencia"), seletor.getDtInicioFimVigencia()));
			} else if(seletor.getDtFimFimVigencia() != null && !seletor.getDtFimFimVigencia().toString().trim().isEmpty()) { //Filtro para data fim de vigência menor que a data inserida (se menor, não mais vigente) 
				predicates.add(cb.lessThanOrEqualTo(root.get("dtFimVigencia"), seletor.getDtFimFimVigencia()));
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
