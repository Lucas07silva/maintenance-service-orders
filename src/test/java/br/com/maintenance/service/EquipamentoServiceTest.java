package br.com.maintenance.service;

import br.com.maintenance.exception.ConflictException;
import br.com.maintenance.model.Equipamento;
import br.com.maintenance.repository.EquipamentoRepository;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EquipamentoServiceTest {
    @Test
    void deveImpedirCodigoDePatrimonioDuplicado() {
        EquipamentoRepository repository = mock(EquipamentoRepository.class);
        EquipamentoService service = new EquipamentoService(repository);
        Equipamento equipamento = new Equipamento();
        equipamento.setAssetCode("COMP-001");
        when(repository.findByAssetCode("COMP-001")).thenReturn(Optional.of(new Equipamento()));
        assertThrows(ConflictException.class, () -> service.criar(equipamento));
        verify(repository, never()).save(any());
    }
}
