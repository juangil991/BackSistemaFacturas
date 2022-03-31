package com.sofka.sistemafacturas.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Map;

@Document
public class Inventario {

    @Id
    private String id;

    private Map<String,Integer> idProducto;
    private String tipo;
    //factura
    private LocalDate fecha;
    private String nombreCliente;
    private String documentoCliente;
    private String nombreCajero;
    private Long total;
    //producto
    private String nombreProducto;
    private Integer cantidadProducto;
    private Long precioProducto;
    //volante
    private String nombreProvedor;
    private String telefonoProvedor;
    private String documentoProvedor;

    public Inventario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Integer> getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Map<String, Integer> idProducto) {
        this.idProducto = idProducto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Long getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Long precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getNombreProvedor() {
        return nombreProvedor;
    }

    public void setNombreProvedor(String nombreProvedor) {
        this.nombreProvedor = nombreProvedor;
    }

    public String getTelefonoProvedor() {
        return telefonoProvedor;
    }

    public void setTelefonoProvedor(String telefonoProvedor) {
        this.telefonoProvedor = telefonoProvedor;
    }

    public String getDocumentoProvedor() {
        return documentoProvedor;
    }

    public void setDocumentoProvedor(String documentoProvedor) {
        this.documentoProvedor = documentoProvedor;
    }
}
