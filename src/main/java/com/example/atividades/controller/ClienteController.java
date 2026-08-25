package com.example.atividades.controller;

import com.example.atividades.entity.Cliente;
import com.example.atividades.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = repository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping
    public ResponseEntity<?> listar(@RequestParam(required = false) String email) {
        if (email != null) {
            Optional<Cliente> cliente = repository.findByEmailIgnoreCase(email);
            if (cliente.isPresent()) {
                return ResponseEntity.ok(cliente.get());
            }
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(repository.findAll());
    }
}
