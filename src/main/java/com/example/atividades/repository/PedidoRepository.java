package com.example.atividades.repository;

import com.example.atividades.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findAllByDataBetween(LocalDate dataAfter, LocalDate dataBefore);
}
