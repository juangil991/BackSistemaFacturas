package com.sofka.sistemafacturas.dtos;

import java.util.List;
import java.util.Map;

public class VolanteProvedoresDTO {
    private String id;
    private String nombreProvedor;
    private String telefonoProvedor;
    private String documentoProvedor;
    private List<ProductoDTO> Productos;
    private String tipo;

    public VolanteProvedoresDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<ProductoDTO> getProductos() {
        return Productos;
    }

    public void setProductos(List<ProductoDTO> productos) {
        Productos = productos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
