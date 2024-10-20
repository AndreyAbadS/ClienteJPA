package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class ClienteDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
    private Integer numero;

}
