package br.com.calcard.repositories;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.calcard.entities.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer>{
	Clientes findOneByCpf(@NotNull String cpf);
}
