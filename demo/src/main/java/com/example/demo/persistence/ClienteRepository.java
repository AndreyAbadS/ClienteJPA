package com.example.demo.persistence;

import com.example.demo.domain.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends JpaRepository<Clientes,Integer> {

    @Query(value = "Select nombre,apellido from cliente where id=:id")
    Clientes getNombre(@Param("id")Integer id);
}
