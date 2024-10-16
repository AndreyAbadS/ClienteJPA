package com.example.demo.controller;

import com.example.demo.domain.Clientes;
import com.example.demo.payload.MessageResponse;
import com.example.demo.service.IServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private IServiceCliente clienteService;

    @GetMapping("cliente")
    public ResponseEntity<?> showAll(){
        List<Clientes> clientes = clienteService.getClientes();
        return new ResponseEntity<>(MessageResponse.builder().message("ok").object(clientes).build(), HttpStatus.OK);
    }

}
