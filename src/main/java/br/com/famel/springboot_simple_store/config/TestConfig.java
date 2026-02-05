package br.com.famel.springboot_simple_store.config;

import br.com.famel.springboot_simple_store.entity.User;
import br.com.famel.springboot_simple_store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null,"Maria","Maria@gmail.com","98888888","123456");
        User u2 = new User(null,"Alex","Alex@gmail.com","9777777","123456");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
