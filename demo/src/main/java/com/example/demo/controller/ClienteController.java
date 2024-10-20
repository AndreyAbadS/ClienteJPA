package com.example.demo.controller;

import com.example.demo.domain.Clientes;
import com.example.demo.dto.ClienteDto;
import com.example.demo.payload.MessageResponse;
import com.example.demo.service.IServiceCliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private IServiceCliente clienteService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("cliente")
    public ResponseEntity<?> showAll(){
        List<Clientes> clientes = clienteService.getClientes();

        if (clientes ==null){
            return new ResponseEntity<>(MessageResponse.builder().message("Error de datos").object(null).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(MessageResponse.builder().message("ok").object(clientes).build(), HttpStatus.OK);
    }

    @PostMapping("cliente")
    public ResponseEntity<?> createCliente(@RequestBody ClienteDto clienteDto){
        try {
            Clientes clientesSave = clienteService.save(clienteDto);
            return new ResponseEntity<>(MessageResponse.builder().message("Se guardo correctamente").object(clientesSave).build(), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(MessageResponse.builder().message("Error en guardado").object(null).build(), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("cliente/nombre{id}")
    public ResponseEntity<?> clienteNombre(@PathVariable Integer id){
        Clientes clientes = clienteService.getNombre(id);

        if (clientes ==null){
            return new ResponseEntity<>(MessageResponse.builder().message("Error de datos").object(null).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(MessageResponse.builder().message("ok").object(clientes).build(), HttpStatus.OK);
    }

}
