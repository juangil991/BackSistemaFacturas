package com.sofka.sistemafacturas.dtos;

public class ProductoDTO {
    private String id;
    private String nombreProducto;
    private Integer cantidadProducto;
    private Integer maximaCantidad;
    private Integer minimaCantidad;
    private Long precioProducto;
    private String tipo;

    public ProductoDTO() {
    }

    public ProductoDTO(String id, String nombreProducto, Integer cantidadProducto, Integer maximaCantidad, Integer minimaCantidad, Long precioProducto, String tipo) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.maximaCantidad = maximaCantidad;
        this.minimaCantidad = minimaCantidad;
        this.precioProducto = precioProducto;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getMaximaCantidad() {
        return maximaCantidad;
    }

    public void setMaximaCantidad(Integer maximaCantidad) {
        this.maximaCantidad = maximaCantidad;
    }

    public Integer getMinimaCantidad() {
        return minimaCantidad;
    }

    public void setMinimaCantidad(Integer minimaCantidad) {
        this.minimaCantidad = minimaCantidad;
    }
}
