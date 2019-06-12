package br.com.calcard.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.calcard.enums.Faixas;
import br.com.calcard.enums.ResultadoAvaliacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Propostas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5349476678437776138L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JoinColumn(nullable=false)
	private Clientes cliente;
	private ResultadoAvaliacao resultado;
	private Faixas limiteCredito;		
}
