package com.sofka.sistemafacturas.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
public class Factura {
    @Id
    private String id;

    private LocalDate fecha;
    private String nombreCliente;
    private String documentoCliente;
    private String nombreCajero;
    private List<String> idProducto;
    private Long total;
}
