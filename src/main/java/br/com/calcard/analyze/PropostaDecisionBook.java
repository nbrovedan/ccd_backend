package br.com.calcard.analyze;

import com.deliveredtechnologies.rulebook.DecisionBook;
import com.deliveredtechnologies.rulebook.StandardDecision;

import br.com.calcard.entities.Clientes;
import br.com.calcard.entities.Propostas;
import br.com.calcard.enums.EstadoCivil;
import br.com.calcard.enums.Faixas;
import br.com.calcard.enums.ResultadoAvaliacao;

public class PropostaDecisionBook extends DecisionBook<Clientes, Propostas> {
	
	@Override
	protected void defineRules() {
		//Menor que 1000,00
		addRule(StandardDecision.create(Clientes.class, Propostas.class)
				.when(f -> f.getOne().getRenda() < 1000)
				.then((f, r) -> r.setValue(new Propostas(null, f.getOne(), ResultadoAvaliacao.NEGADO, Faixas.RENDABAIXA)))
				.stop());
		//Renda menor ou igual a 2000,00 solteiro
		addRule(StandardDecision.create(Clientes.class, Propostas.class)
				.when(f -> f.getOne().getRenda() <= 2000 && 
					  	   f.getOne().getEstadoCivil() == EstadoCivil.SOLTEIRO)
				.then((f, r) -> r.setValue(new Propostas(null, f.getOne(), ResultadoAvaliacao.APROVADO, Faixas.FAIXA1)))
				.stop());
		//Renda menor ou igual a 2000,00 demais
		addRule(StandardDecision.create(Clientes.class, Propostas.class)
				.when(f -> f.getOne().getRenda() <= 2000)
				.then((f, r) -> r.setValue(new Propostas(null, f.getOne(), ResultadoAvaliacao.NEGADO, Faixas.REPROVADO)))
				.stop());
		//Renda menor a 5000,00 sem dependentes
		addRule(StandardDecision.create(Clientes.class, Propostas.class)
				.when(f -> f.getOne().getRenda() < 5000 &&
						   f.getOne().getDependentes() == 0)
				.then((f, r) -> r.setValue(new Propostas(null, f.getOne(), ResultadoAvaliacao.APROVADO, Faixas.FAIXA2)))
				.stop());
		//Renda menor a 5000,00 demais
		addRule(StandardDecision.create(Clientes.class, Propostas.class)
				.when(f -> f.getOne().getRenda() < 5000)
				.then((f, r) -> r.setValue(new Propostas(null, f.getOne(), ResultadoAvaliacao.APROVADO, Faixas.FAIXA1)))
				.stop());
		//Renda menor a 8000,00 
		addRule(StandardDecision.create(Clientes.class, Propostas.class)
				.when(f -> f.getOne().getRenda() < 8000)
				.then((f, r) -> r.setValue(new Propostas(null, f.getOne(), ResultadoAvaliacao.APROVADO, Faixas.FAIXA3)))
				.stop());
		//Renda menor a 10000,00, menos que 31 anos e menos de 3 dependentes
		addRule(StandardDecision.create(Clientes.class, Propostas.class)
				.when(f -> f.getOne().getRenda() < 10000 &&
						   f.getOne().getIdade() <= 30 &&
						   f.getOne().getDependentes() <= 2)
				.then((f, r) -> r.setValue(new Propostas(null, f.getOne(), ResultadoAvaliacao.APROVADO, Faixas.FAIXA5)))
				.stop());
		//Renda menor a 10000,00, menos que 31 anos
		addRule(StandardDecision.create(Clientes.class, Propostas.class)
				.when(f -> f.getOne().getRenda() < 10000 &&
						   f.getOne().getIdade() <= 30)
				.then((f, r) -> r.setValue(new Propostas(null, f.getOne(), ResultadoAvaliacao.APROVADO, Faixas.FAIXA3)))
				.stop());
		//Renda menor a 10000,00
		addRule(StandardDecision.create(Clientes.class, Propostas.class)
				.when(f -> f.getOne().getRenda() < 10000)
				.then((f, r) -> r.setValue(new Propostas(null, f.getOne(), ResultadoAvaliacao.APROVADO, Faixas.FAIXA4)))
				.stop());
		//Renda maior a 10000,00
		addRule(StandardDecision.create(Clientes.class, Propostas.class)
				.when(f -> f.getOne().getRenda() >= 10000)
				.then((f, r) -> r.setValue(new Propostas(null, f.getOne(), ResultadoAvaliacao.APROVADO, Faixas.FAIXA5)))
				.stop());
		
		
				
	}

}
