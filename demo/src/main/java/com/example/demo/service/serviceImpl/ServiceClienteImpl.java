package com.example.demo.service.serviceImpl;

import com.example.demo.domain.Clientes;
import com.example.demo.dto.ClienteDto;
import com.example.demo.persistence.ClienteRepository;
import com.example.demo.service.IServiceCliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceClienteImpl implements IServiceCliente {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Clientes> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Clientes save(ClienteDto clienteDto) {
        Clientes clientes = modelMapper.map(clienteDto,Clientes.class);
        return clienteRepository.save(clientes);
    }

    @Override
    public Clientes getNombre(Integer id) {
        Clientes cliente = null;
        try {
            cliente = clienteRepository.getNombre(id);
        }
    }
}
