package br.com.eltonpignatel.app.gateway.database.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	Long id;
	String nome;
	
	@Column(name="data_cadastro")
	Calendar dataCadastro;

}
