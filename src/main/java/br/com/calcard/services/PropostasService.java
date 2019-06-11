package br.com.calcard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcard.analyze.PropostaDecisionBook;
import br.com.calcard.entities.Clientes;
import br.com.calcard.entities.Propostas;
import br.com.calcard.repositories.PropostasRepository;

@Service
public class PropostasService extends DefaultService {
	
	@Autowired
	private PropostasRepository propostaRepository;
	@Autowired 
	private ClientesService clienteService;
	
	public Propostas proposta(Integer cliente) {
		if(clienteService.existsCliente(cliente)) {
			PropostaDecisionBook propostaDecision = new PropostaDecisionBook();
			propostaDecision.given("cliente", clienteService.getCliente(cliente)).run();
			return propostaRepository.saveAndFlush(propostaDecision.getResult());
		}else {
			throw new NotFoundException(cliente);
		}
	}
	
	public List<Propostas> getPropostaByCliente(Clientes cliente) {
		return propostaRepository.findAllByCliente(cliente);
	}
	
	public Propostas getProposta(Integer cliente, Integer codigo) {
		return propostaRepository.findAllByClienteAndCodigo(clienteService.getCliente(cliente), codigo)
				.orElseThrow(() -> new NotFoundException(codigo));
	}
	
}
