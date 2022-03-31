package com.sofka.sistemafacturas.dtos;

import java.util.List;
import java.util.Map;

public class VolanteProvedoresDTO {
    private String id;
    private String nombreProvedor;
    private String telefonoProvedor;
    private String documentoProvedor;
    private Map<String,Integer> idProducto;
    private String tipo;

    public VolanteProvedoresDTO() {
    }

    public VolanteProvedoresDTO(String id, String nombreProvedor,
                                String telefonoProvedor, String documentoProvedor,
                                Map<String, Integer> idProducto, String tipo) {
        this.id = id;
        this.nombreProvedor = nombreProvedor;
        this.telefonoProvedor = telefonoProvedor;
        this.documentoProvedor = documentoProvedor;
        this.idProducto = idProducto;
        this.tipo = tipo;
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
}
