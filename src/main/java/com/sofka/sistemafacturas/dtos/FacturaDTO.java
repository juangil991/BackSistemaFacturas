package com.sofka.sistemafacturas.dtos;

import java.time.LocalDate;
import java.util.List;

public class FacturaDTO {
    private String id;
    private LocalDate fecha;
    private String nombreCliente;
    private String documentoCliente;
    private String nombreCajero;
    private List<String> idProducto;
    private Long total;

    public FacturaDTO() {
    }

    public FacturaDTO(LocalDate fecha, String nombreCliente,
                      String documentoCliente, String nombreCajero, List<String> idProducto, Long total) {
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.documentoCliente = documentoCliente;
        this.nombreCajero = nombreCajero;
        this.idProducto = idProducto;
        this.total = total;
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

    public List<String> getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(List<String> idProducto) {
        this.idProducto = idProducto;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
