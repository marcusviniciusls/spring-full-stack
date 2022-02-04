package br.com.udemy.Spring.FullStack.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping("/")
    public ResponseEntity<String> getHealth(){
        return ResponseEntity.ok().body("SUCESSO");
    }
}