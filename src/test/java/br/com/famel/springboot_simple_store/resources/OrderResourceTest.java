package br.com.famel.springboot_simple_store.resources;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.famel.springboot_simple_store.repositories.OrderRepository;
import br.com.famel.springboot_simple_store.resources.exceptions.ResourceExceptionHandler;
import br.com.famel.springboot_simple_store.service.OrderService;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class OrderResourceTest {

    @Mock
    private OrderRepository repository;

    @InjectMocks
    private OrderService service;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        OrderResource resource = new OrderResource();
        ReflectionTestUtils.setField(resource, "service", service);
        mockMvc = MockMvcBuilders.standaloneSetup(resource)
                .setControllerAdvice(new ResourceExceptionHandler())
                .build();
    }

    @Test
    void getOrderInexistenteRetorna404() throws Exception {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/orders/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.error").value("Resource not found"))
                .andExpect(jsonPath("$.path").value("/orders/99"));
    }
}
