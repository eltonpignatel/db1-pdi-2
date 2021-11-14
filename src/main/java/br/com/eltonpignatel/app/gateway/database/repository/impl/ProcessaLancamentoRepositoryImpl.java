package br.com.eltonpignatel.app.gateway.database.repository.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.eltonpignatel.app.gateway.database.repository.ProcessaLancamentoRepository;
import oracle.jdbc.OracleTypes;

@Repository
public class ProcessaLancamentoRepositoryImpl implements ProcessaLancamentoRepository {
	
	@Autowired
    protected DataSource dataSource;
	
	@Override
	public String processaLancamentos() {
		// TODO Auto-generated method stub
		
		Connection connection = null;
        CallableStatement st = null;
        String retorno = "nao deu";
        try {

            connection = dataSource.getConnection();
            st = connection.prepareCall("begin pck_lancamentos.processa_parcelas(p_descricao=> ?, p_usuario=> ?, p_valor_total=> ?, p_numero_parcelas=> ?, p_retorno => ?); end;");
            st.setString(1, "teste de lancamento");
            st.setLong(2, 1);
            st.setLong(3, 100);
            st.setLong(4, 5);
            st.registerOutParameter(5 , OracleTypes.VARCHAR);
            st.executeUpdate();
            
            retorno = st.getString(5);

        }catch(Exception e){
        	e.printStackTrace();
        	System.out.println(e.getMessage());
        } finally {
        	if (connection != null) {
                try {
                	connection.close();
                } catch (SQLException s) {
                	System.out.println("Error a long closing Connection to Pool Hikari");
                }
            }
        }
		return retorno;
	}
	
}
