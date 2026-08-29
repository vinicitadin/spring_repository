package com.example.atividades.controller;

import com.example.atividades.entity.Pedido;
import com.example.atividades.repository.PedidoRepository;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository repository;

    public PedidoController(PedidoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Pedido> cadastrar(@RequestBody Pedido pedido) {
        Pedido salvo = repository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping ResponseEntity<List<Pedido>> buscar(@RequestParam(required = false) LocalDate dataInicial,
                                                    @RequestParam(required = false) LocalDate dataFinal) {
        if (dataInicial != null && dataFinal != null) {
            return ResponseEntity.ok(repository.findAllByDataBetween(dataInicial, dataFinal));
        }
        return ResponseEntity.ok(repository.findAll());
    }
}
