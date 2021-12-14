package br.com.eltonpignatel.app.service;

import br.com.eltonpignatel.app.gateway.database.repository.LancamentoRepository;
import br.com.eltonpignatel.app.gateway.database.repository.ProcessaLancamentoRepository;
import br.com.eltonpignatel.app.service.impl.LancamentoServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Calendar;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LancamentosServiceTest {

    @Mock
    private ProcessaLancamentoRepository processaLancamentoRepository;

    @Spy
    @InjectMocks
    private LancamentoServiceImpl service;

    @Test
    public void shouldAddTransactionWithDueDate() {
        String descricao = "Parcela Exemplo";
        Long usuario = 1L;
        Double valor = 100.0;
        Integer numeroParcelas = 1;
        Calendar vencimento = Calendar.getInstance();

        Mockito.when(processaLancamentoRepository.processaLancamentos(Mockito.anyString(), Mockito.anyLong(), Mockito.anyDouble(), Mockito.anyInt(), Mockito.any() )).thenReturn("Parcelas processadas com sucesso!");

        String result = service.processaLancamentos(descricao, usuario, valor, numeroParcelas, vencimento);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Parcelas processadas com sucesso!", result);
    }

    @Test
    public void shouldAddTransactionWithoutDueDate() {
        String descricao = "Parcela Exemplo";
        Long usuario = 1L;
        Double valor = 100.0;
        Integer numeroParcelas = 1;

        Mockito.when(processaLancamentoRepository.processaLancamentos(Mockito.anyString(), Mockito.anyLong(), Mockito.anyDouble(), Mockito.anyInt() )).thenReturn("Parcelas processadas com sucesso!");

        String result = service.processaLancamentos(descricao, usuario, valor, numeroParcelas, null);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Parcelas processadas com sucesso!", result);
    }
}
