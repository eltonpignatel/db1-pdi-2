package br.com.eltonpignatel.app.gateway.database.repository.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Calendar;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import br.com.eltonpignatel.app.gateway.database.repository.ProcessaLancamentoRepository;
import oracle.jdbc.OracleTypes;

@Slf4j
@Repository
public class ProcessaLancamentoRepositoryImpl implements ProcessaLancamentoRepository {

    private static final String SQL_LANCAMENTOS_PROCESSA_PARCELAS = "begin pck_lancamentos.processa_parcelas(p_descricao=> ?, p_usuario=> ?, p_valor_total=> ?, p_numero_parcelas=> ?, p_vencimento=> ?, p_retorno => ?); end;";
    private static final String SQL_LANCAMENTOS_PROCESSA_PARCELAS_SEM_VENCTO = "begin pck_lancamentos.processa_parcelas(p_descricao=> ?, p_usuario=> ?, p_valor_total=> ?, p_numero_parcelas=> ?, p_retorno => ?); end;";

	@Autowired
    protected DataSource dataSource;
	
	@Override
	public String processaLancamentos(String descricao, Long usuario, Double valor, Integer numeroParcelas, Calendar vencimento) {

        String retorno = null;
        try (Connection connection = dataSource.getConnection();
             CallableStatement st = connection.prepareCall(SQL_LANCAMENTOS_PROCESSA_PARCELAS);) {

            st.setString(1, descricao);
            st.setLong(2, usuario);
            st.setDouble(3, valor);
            st.setLong(4, numeroParcelas);
            st.setDate(5,new java.sql.Date( vencimento.getTimeInMillis()) );
            st.registerOutParameter(6 , OracleTypes.VARCHAR);
            st.executeUpdate();
            
            retorno = st.getString(6);

        }catch(Exception e) {
        	e.printStackTrace();
        	log.debug("Erro ao fazer chamada no banco de dados.",e);
            retorno = "Nao foi possivel executar transacao com banco de dados";
        }

		return retorno;
	}

    @Override
    public String processaLancamentos(String descricao, Long usuario, Double valor, Integer numeroParcelas) {

        String retorno = null;
        try (Connection connection = dataSource.getConnection();
             CallableStatement st = connection.prepareCall(SQL_LANCAMENTOS_PROCESSA_PARCELAS_SEM_VENCTO);) {

            st.setString(1, descricao);
            st.setLong(2, usuario);
            st.setDouble(3, valor);
            st.setLong(4, numeroParcelas);
            st.registerOutParameter(5 , OracleTypes.VARCHAR);
            st.executeUpdate();

            retorno = st.getString(5);

        }catch(Exception e){
            e.printStackTrace();
            retorno = "Nao foi possivel executar transacao com banco de dados";
        }

        return retorno;
    }

}
