package com.example.atividades.repository;

import com.example.atividades.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNomeContainingIgnoreCase(String nome);

    List<Produto> findAllByPrecoBetween(Double precoAfter, Double precoBefore);

    List<Produto> findTop5ByOrderByPrecoAsc();
}
