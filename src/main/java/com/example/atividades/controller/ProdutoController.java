package com.example.atividades.controller;

import com.example.atividades.entity.Produto;
import com.example.atividades.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
        Produto salvo = repository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscar(@RequestParam(required = false) String nome) {
        if (nome != null) {
            return ResponseEntity.ok(repository.findByNomeContainingIgnoreCase(nome));
        }
        return  ResponseEntity.ok(repository.findAll());
    }

}
