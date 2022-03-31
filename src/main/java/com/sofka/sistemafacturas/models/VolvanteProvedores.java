package com.sofka.sistemafacturas.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document
public class VolvanteProvedores {
    @Id
    private String id;

    private String nombre;
    private String telefono;
    private String documento;
    private Map<String,Integer> idProductos;

    public VolvanteProvedores() {
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
