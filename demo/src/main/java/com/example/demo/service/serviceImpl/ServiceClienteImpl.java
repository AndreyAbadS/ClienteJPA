package com.example.demo.service.serviceImpl;

import com.example.demo.domain.Clientes;
import com.example.demo.persistence.ClienteRepository;
import com.example.demo.service.IServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceClienteImpl implements IServiceCliente {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public List<Clientes> getClientes() {
        return clienteRepository.findAll();
    }
}
