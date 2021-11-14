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
@Table(name="lancamento")
public class Lancamento {
	
	@Id
	Long id;
	
	String descricao;
	
	Double valor;
	
	Long usuario;
	
	@Column(name="data_vencimento")
	Calendar dataVencimeto;
	
	@Column(name="data_cadastro")
	Calendar dataCadastro;
}

