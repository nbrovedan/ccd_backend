package br.com.calcard.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.calcard.entities.Clientes;
import br.com.calcard.repositories.ClientesRepository;

@Service
public class ClientesService extends DefaultService{
	
	@Autowired
	private ClientesRepository clientesRepository;
	
	public List<Clientes> getClientes(){
		return clientesRepository.findAll();
	}
	
	public Clientes getCliente(Integer codigo) {
		return clientesRepository.findById(codigo).orElseThrow(() -> new NotFoundException(codigo));
	}
	
	public Clientes getClienteByCpf(String cpf) {
		return clientesRepository.findOneByCpf(cpf);
	}
	
	public ResponseEntity<String> deleteClientes(Integer codigo){
		clientesRepository.deleteById(codigo);
		return new ResponseEntity<String>("{\"message\":\"removed\"}", HttpStatus.OK);
	}
	
	public Clientes saveCliente(@Valid Clientes cliente) {
		return clientesRepository.saveAndFlush(cliente);
	}
	
	public Clientes updateCliente(Integer codigo, @Valid Clientes cliente) {
		Clientes _cliente = clientesRepository.findById(codigo).orElseThrow(() -> new NotFoundException(codigo));
		_cliente.setCpf(cliente.getCpf());
		_cliente.setDependentes(cliente.getDependentes());
		_cliente.setEstado(cliente.getEstado());
		_cliente.setEstadoCivil(cliente.getEstadoCivil());
		_cliente.setIdade(cliente.getIdade());
		_cliente.setNome(cliente.getNome());
		_cliente.setRenda(cliente.getRenda());
		_cliente.setSexo(cliente.getSexo());
		
		return clientesRepository.saveAndFlush(_cliente);
	}
	
	public Boolean existsCliente(Integer codigo) {
		return clientesRepository.existsById(codigo);
	}
}
