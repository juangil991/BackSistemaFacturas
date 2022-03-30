package com.sofka.sistemafacturas.dtos;

public class InventarioProductoDTO {
    private String id;
    private String nombre;
    private Integer cantidad;
    private Long precio;

    public InventarioProductoDTO() {
    }

    public InventarioProductoDTO(String nombre, Integer cantidad, Long precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }
}
