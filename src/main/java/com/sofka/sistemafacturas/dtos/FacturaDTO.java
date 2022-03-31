package com.sofka.sistemafacturas.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FacturaDTO {
    private String id;
    private LocalDate fecha;
    private String nombreCliente;
    private String documentoCliente;
    private String nombreCajero;
    private Map<String,Integer> idProducto;
    private Long total;
    private String tipo;

    public FacturaDTO() {
    }

    public FacturaDTO(String id, LocalDate fecha, String nombreCliente, String documentoCliente,
                      String nombreCajero, Map<String, Integer> idProducto, Long total, String tipo) {
        this.id = id;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.documentoCliente = documentoCliente;
        this.nombreCajero = nombreCajero;
        this.idProducto = idProducto;
        this.total = total;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public String getNombreCajero() {
        return nombreCajero;
    }

    public void setNombreCajero(String nombreCajero) {
        this.nombreCajero = nombreCajero;
    }

    public Map<String, Integer> getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Map<String, Integer> idProducto) {
        this.idProducto = idProducto;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
