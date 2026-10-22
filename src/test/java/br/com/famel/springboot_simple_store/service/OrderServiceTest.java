package br.com.famel.springboot_simple_store.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import br.com.famel.springboot_simple_store.entities.Order;
import br.com.famel.springboot_simple_store.repositories.OrderRepository;
import br.com.famel.springboot_simple_store.service.exceptions.ResourceNotFoundException;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository repository;

    @InjectMocks
    private OrderService service;

    @Test
    void findByIdRetornaPedidoExistente() {
        Order order = new Order();
        when(repository.findById(1L)).thenReturn(Optional.of(order));

        assertThat(service.findById(1L)).isSameAs(order);
    }

    @Test
    void findByIdLancaResourceNotFoundParaIdInexistente() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.findById(99L))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("99");
    }
}
