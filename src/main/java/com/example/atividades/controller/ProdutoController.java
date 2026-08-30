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
        if (produto.getPreco() < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (produto.getNome().length() < 3) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        Produto salvo = repository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscar(@RequestParam(required = false) String nome,
                                                @RequestParam(required = false) Double precoMin, @RequestParam(required = false) Double precoMax) {
        if (nome != null) {
            return ResponseEntity.ok(repository.findByNomeContainingIgnoreCase(nome));
        }
        if (precoMin != null && precoMax != null) {
            return ResponseEntity.ok(repository.findAllByPrecoBetween(precoMin, precoMax));
        }

        List<Produto> produtos = repository.findAll();
        if (produtos.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/mais-baratos")
    public ResponseEntity<List<Produto>> buscarMaisBaratos() {
        return ResponseEntity.ok(repository.findTop5ByOrderByPrecoAsc());
    }
}
