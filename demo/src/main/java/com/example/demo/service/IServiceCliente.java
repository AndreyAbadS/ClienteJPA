package com.example.demo.service;

import com.example.demo.domain.Clientes;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IServiceCliente {


    List<Clientes> getClientes();
}
