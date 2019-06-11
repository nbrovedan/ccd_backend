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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;

@RestController
@CrossOrigin("*")
@RequestMapping("/clientes")
@Api(value="Clientes", tags={"Clientes"}, description="Controle de usuários")
public class ClientesController {
	
	@Autowired
	private ClientesService clientesService;
	@Autowired
	private PropostasService propostaService; 
	
	@ApiOperation(
		value="Buscar todos os clientes",
		response=List.class,
		notes="Retorna todos os clientes cadastrados")

	@ApiResponses(value= {
		@ApiResponse(
			code=200,
			message="Retorna um imóvel",
			response=List.class),
		@ApiResponse(
			code=404,
			message="Retorna um erro 404 caso nenhum cliente seja encontrado",
			response=NotFoundException.class)
		})
	@GetMapping
	public List<Clientes> getClientes() {
		return clientesService.getClientes();
	}
	
	@ApiOperation(
			value="Buscar cliente pelo código",
			response=Clientes.class,
			notes="Retorna o cliente de acordo com o código")

	@ApiResponses(value= {
		@ApiResponse(
			code=200,
			message="Retorna um cliente",
			response=Clientes.class),
		@ApiResponse(
			code=404,
			message="Retorna um erro 404 caso nenhum cliente seja encontrado",
			response=NotFoundException.class)
		})
	@GetMapping("/{codigo}")
	public Clientes getCliente(@PathVariable Integer codigo) {
		return clientesService.getCliente(codigo);
	}
	
	@ApiOperation(
			value="Buscar cliente pelo CPF",
			response=Clientes.class,
			notes="Retorna o cliente de acordo com o CPF")

	@ApiResponses(value= {
		@ApiResponse(
			code=200,
			message="Retorna um cliente",
			response=Clientes.class),
		@ApiResponse(
			code=404,
			message="Retorna um erro 404 caso nenhum cliente seja encontrado",
			response=NotFoundException.class)
		})
	@GetMapping(params="cpf")
	public Clientes getCliente(@RequestParam String cpf) {
		return clientesService.getClienteByCpf(cpf);
	}
	
	@ApiOperation(
			value="Adicionar um novo cliente",
			response=Clientes.class,
			notes="Adiciona um novo cliente e retorna o mesmo")

	@ApiResponses(value= {
		@ApiResponse(
			code=200,
			message="Retorna o cliente inserido",
			response=Clientes.class),
		@ApiResponse(
			code=500,
			message="Retorna um erro 500 caso algum erro seja encontrado",
			response=InternalError.class)
		})
	@PostMapping
	public Clientes newCliente(@Valid @RequestBody Clientes cliente) {
		return clientesService.saveCliente(cliente);
	}
	
	@ApiOperation(
			value="Atualiza um cliente",
			response=Clientes.class,
			notes="Adiciona um cliente de acordo com o código passado")

	@ApiResponses(value= {
		@ApiResponse(
			code=200,
			message="Retorna o cliente atualizado",
			response=Clientes.class),
		@ApiResponse(
			code=500,
			message="Retorna um erro 500 caso algum erro seja encontrado",
			response=InternalError.class)
		})
	@PutMapping("/{codigo}")
	public Clientes updateCliente(@PathVariable Integer codigo, @RequestBody Clientes cliente) {
		return clientesService.updateCliente(codigo, cliente);
	}
	
	@ApiOperation(
			value="Remove um cliente",
			response=Clientes.class,
			notes="Remove um cliente de acordo com o código passado")

	@ApiResponses(value= {
		@ApiResponse(
			code=200,
			message="Retorna uma mensagem de sucesso",
			response=ResponseEntity.class),
		@ApiResponse(
			code=500,
			message="Retorna um erro 500 caso algum erro seja encontrado",
			response=InternalError.class)
		})
	@DeleteMapping(value = "/{codigo}", produces="application/json")
	@ResponseBody
	public ResponseEntity<String> deleteCliente(@PathVariable Integer codigo) {
		return clientesService.deleteClientes(codigo);
	}
	
	@ApiOperation(
			value="Adiciona uma proposta",
			response=Propostas.class,
			notes="Adiciona uma proposta ao cliente cujo código foi enviado")

	@ApiResponses(value= {
		@ApiResponse(
			code=200,
			message="Retorna a proposta inserida",
			response=Propostas.class),
		@ApiResponse(
			code=500,
			message="Retorna um erro 500 caso algum erro seja encontrado",
			response=InternalError.class)
		})
	@PostMapping("/{cliente}/propostas")
	public Propostas setAnalise(@PathVariable Integer cliente) {
		return propostaService.proposta(cliente);
	}
	
	@ApiOperation(
			value="Lista todas propostas do cliente",
			response=List.class,
			notes="Retorna todas as propostas do cliente cujo código foi enviado")

	@ApiResponses(value= {
		@ApiResponse(
			code=200,
			message="Retorna uma lista de propostas",
			response=List.class),
		@ApiResponse(
			code=404,
			message="Retorna um erro 404 caso o cliente não tenha nenhuma proposta",
			response=NotFoundException.class)
		})
	@GetMapping("/{cliente}/propostas")
	public List<Propostas> getAnalises(@PathVariable Integer cliente) {		
		return propostaService.getPropostaByCliente(clientesService.getCliente(cliente));
	}
	 
	@ApiOperation(
			value="Busca uma proposta do cliente",
			response=Propostas.class,
			notes="Retorna uma proposta do cliente de acordo com os códigos enviados")

	@ApiResponses(value= {
		@ApiResponse(
			code=200,
			message="Retorna uma proposta",
			response=Propostas.class),
		@ApiResponse(
			code=404,
			message="Retorna um erro 404 caso a proposta não seja encontrada",
			response=NotFoundException.class)
		})
	@GetMapping("/{cliente}/propostas/{codigo}")
	public Propostas getAnalise(@PathVariable Integer cliente, @PathVariable Integer codigo) {
		return propostaService.getProposta(cliente, codigo);
	}
}
