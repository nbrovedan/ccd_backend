package br.com.calcard.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.calcard.entities.Propostas;
import br.com.calcard.entities.Clientes;

@Repository
public interface PropostasRepository extends JpaRepository<Propostas, Integer>{
	
	List<Propostas> findAllByCliente(Clientes cliente);
	
	Optional<Propostas> findAllByClienteAndCodigo(Clientes cliente, Integer codigo);
}
