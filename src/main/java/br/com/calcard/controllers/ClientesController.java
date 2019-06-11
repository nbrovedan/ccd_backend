package br.com.calcard.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.entities.Clientes;
import br.com.calcard.entities.Propostas;
import br.com.calcard.services.ClientesService;
import br.com.calcard.services.PropostasService;

@RestController
@CrossOrigin("*")
@RequestMapping("/clientes")
public class ClientesController {
	
	@Autowired
	private ClientesService clientesService;
	@Autowired
	private PropostasService propostaService; 
	
	@GetMapping
	public List<Clientes> getClientes() {
		return clientesService.getClientes();
	}
	
	@GetMapping("/{codigo}")
	public Clientes getCliente(@PathVariable Integer codigo) {
		return clientesService.getCliente(codigo);
	}
	
	@GetMapping(params="cpf")
	public Clientes getCliente(@RequestParam String cpf) {
		return clientesService.getClienteByCpf(cpf);
	}
	
	@PostMapping
	public Clientes newCliente(@Valid @RequestBody Clientes cliente) {
		return clientesService.saveCliente(cliente);
	}
	
	@PutMapping("/{codigo}")
	public Clientes updateCliente(@PathVariable Integer codigo, @RequestBody Clientes cliente) {
		return clientesService.updateCliente(codigo, cliente);
	}
	
	@DeleteMapping(value = "/{codigo}", produces="application/json")
	@ResponseBody
	public ResponseEntity<String> deleteCliente(@PathVariable Integer codigo) {
		return clientesService.deleteClientes(codigo);
	}
	
	@PostMapping("/{cliente}/propostas")
	public Propostas setAnalise(@PathVariable Integer cliente) {
		return propostaService.proposta(cliente);
	}
	
	@GetMapping("/{cliente}/propostas")
	public List<Propostas> getAnalises(@PathVariable Integer cliente) {		
		return propostaService.getPropostaByCliente(clientesService.getCliente(cliente));
	}
	 
	@GetMapping("/{cliente}/propostas/{codigo}")
	public Propostas getAnalise(@PathVariable Integer cliente, @PathVariable Integer codigo) {
		return propostaService.getProposta(cliente, codigo);
	}
}
