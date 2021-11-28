package br.com.eltonpignatel.app.gateway.database.entity;

import java.util.Calendar;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
@Table(name="lancamento")
public class Lancamento {
	
	@Id
	Long id;

	@NotNull(message = "Descricao do lancamento nao pode ser nula")
	String descricao;
	
	Double valor;

	@OneToOne
	Usuario usuario;
	
	@Column(name="data_vencimento")
	Calendar dataVencimeto;
	
	@Column(name="data_cadastro")
	Calendar dataCadastro;
}

