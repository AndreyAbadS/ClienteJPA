package com.example.demo.persistence;

import com.example.demo.domain.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Clientes,Integer> {

}
