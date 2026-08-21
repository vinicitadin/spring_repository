package com.example.atividades.repository;

import com.example.atividades.entity.Cliente;
import com.example.atividades.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByEmailContainingIgnoreCase(String email);
}
