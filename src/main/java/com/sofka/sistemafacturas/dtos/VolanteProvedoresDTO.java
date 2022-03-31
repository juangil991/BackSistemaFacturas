package com.sofka.sistemafacturas.dtos;

import java.util.List;
import java.util.Map;

public class VolanteProvedoresDTO {
    private String id;
    private String nombre;
    private String telefono;
    private String documento;
    private Map<String,Integer> idProductos;

    public VolanteProvedoresDTO() {
    }

    public VolanteProvedoresDTO(String id, String nombre, String telefono, String documento, Map<String, Integer> idProductos) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.documento = documento;
        this.idProductos = idProductos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Map<String, Integer> getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(Map<String, Integer> idProductos) {
        this.idProductos = idProductos;
    }
}
