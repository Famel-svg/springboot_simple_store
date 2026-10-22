package br.com.famel.springboot_simple_store.service;

import br.com.famel.springboot_simple_store.entities.Order;
import br.com.famel.springboot_simple_store.repositories.OrderRepository;
import br.com.famel.springboot_simple_store.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
