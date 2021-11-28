package br.com.eltonpignatel.app.gateway.database.repository.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.eltonpignatel.app.gateway.database.repository.ProcessaLancamentoRepository;
import oracle.jdbc.OracleTypes;

@Repository
public class ProcessaLancamentoRepositoryImpl implements ProcessaLancamentoRepository {

    private static final String SQL_LANCAMENTOS_PROCESSA_PARCELAS = "begin pck_lancamentos.processa_parcelas(p_descricao=> ?, p_usuario=> ?, p_valor_total=> ?, p_numero_parcelas=> ?, p_vencimento=> ?, p_retorno => ?); end;";

	@Autowired
    protected DataSource dataSource;
	
	@Override
	public String processaLancamentos(String descricao, Long usuario, Double valor, Integer numeroParcelas, Calendar vencimento) {
		// TODO Auto-generated method stub

        String retorno = "Nao foi possivel executar transacao com banco de dados";
        try (Connection connection = dataSource.getConnection();
             CallableStatement st = connection.prepareCall(SQL_LANCAMENTOS_PROCESSA_PARCELAS);) {

            st.setString(1, descricao);
            st.setLong(2, usuario);
            st.setDouble(3, valor);
            st.setLong(4, numeroParcelas);
            System.out.println(vencimento.toString());
            st.setDate(5,new java.sql.Date( vencimento.getTimeInMillis()) );
            st.registerOutParameter(6 , OracleTypes.VARCHAR);
            st.executeUpdate();
            
            retorno = st.getString(6);

        }catch(Exception e){
        	e.printStackTrace();
        	System.out.println(e.getMessage());
        }

		return retorno;
	}
	
}
