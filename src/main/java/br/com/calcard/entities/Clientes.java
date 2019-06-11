package br.com.calcard.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.calcard.enums.EstadoCivil;
import br.com.calcard.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor	
@NoArgsConstructor
@JsonInclude(Include.NON_NULL) 
public class Clientes implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8414712824854927689L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	@NotNull
	@Size(max=100)
	@Column(length=100)
	private String nome;
	@NotNull
	@Size(max=14)
	@Column(length=14, unique=true)
	private String cpf;
	@NotNull
	private Integer idade;
	@NotNull
	private Sexo sexo;
	@NotNull
	private EstadoCivil estadoCivil;
	@NotNull
	@Size(max=2)
	@Column(length=2)
	private String estado;
	private Integer dependentes;
	private Float renda;
}
