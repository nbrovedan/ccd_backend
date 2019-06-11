package br.com.calcard.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuarios implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2150614112787923791L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	@NotNull
	@Size(max=30)
	@Column(length=30)
	private String nome;
	@NotNull
	@Size(max=150)
	@Column(length=150)
	private String email;
	@NotNull
	@Size(max=50)
	@Column(length=50)
	private String senha;
}
