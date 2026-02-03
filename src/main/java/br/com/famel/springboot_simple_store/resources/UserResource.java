package br.com.famel.springboot_simple_store.resources;

import br.com.famel.springboot_simple_store.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(null, "Famel", "rafael@gmail.com", "11988877665", "123456");
    return ResponseEntity.ok().body(u);
    }
}
