package com.sofka.sistemafacturas.dtos;

import java.util.List;

public class VolanteProvedoresDTO {
    private String id;
    private String nombre;
    private String telefono;
    private String documento;
    private List<String> idProductos;

    public VolanteProvedoresDTO() {
    }

    public VolanteProvedoresDTO(String nombre, String telefono, String documento, List<String> idProductos) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.documento = documento;
        this.idProductos = idProductos;
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

    public List<String> getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(List<String> idProductos) {
        this.idProductos = idProductos;
    }
}
