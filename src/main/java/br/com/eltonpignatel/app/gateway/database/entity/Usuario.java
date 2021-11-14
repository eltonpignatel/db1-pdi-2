package br.com.eltonpignatel.app.gateway.database.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	Long id;
	String nome;
	
	@Column(name="data_cadastro")
	Calendar dataCadastro;
}
