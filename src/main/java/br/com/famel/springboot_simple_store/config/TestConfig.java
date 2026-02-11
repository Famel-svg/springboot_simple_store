package br.com.famel.springboot_simple_store.config;

import br.com.famel.springboot_simple_store.entities.Category;
import br.com.famel.springboot_simple_store.entities.Order;
import br.com.famel.springboot_simple_store.entities.OrderStatus;
import br.com.famel.springboot_simple_store.entities.User;
import br.com.famel.springboot_simple_store.repositories.CategoryRepository;
import br.com.famel.springboot_simple_store.repositories.OrderRepository;
import br.com.famel.springboot_simple_store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Category c1 = new Category("TV", null);
        Category c2 = new Category("Books", null);
        Category c3 = new Category("Computers", null);

        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

        User u1 = new User(null,"Maria","Maria@gmail.com","98888888","123456");
        User u2 = new User(null,"Alex","Alex@gmail.com","9777777","123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT , u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.PAID, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
