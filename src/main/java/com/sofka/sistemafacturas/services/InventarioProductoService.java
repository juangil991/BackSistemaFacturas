package com.sofka.sistemafacturas.services;

import com.sofka.sistemafacturas.dtos.ProductoDTO;
import com.sofka.sistemafacturas.models.Inventario;
import com.sofka.sistemafacturas.repositories.InventarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class InventarioProductoService {

    @Autowired
    InventarioRepository inventarioRepository;


    private ModelMapper modelMapper= new ModelMapper();

    public Flux<ProductoDTO> obtenerProductos(){
        return inventarioRepository.findByTipo("producto")
                .flatMap(p->Flux.just(modelMapper.map(p, ProductoDTO.class)));
    }

    public Mono<ProductoDTO>obtenerProductoPorId(String id){
        return inventarioRepository.findById(id)
                .flatMap(p->Mono.just(modelMapper.map(p, ProductoDTO.class)));
    }

    public Mono<ProductoDTO> crearProducto(ProductoDTO inventarioProducto) {
        inventarioProducto.setTipo("producto");
        Inventario producto = modelMapper.map(inventarioProducto, Inventario.class);
       return this.inventarioRepository
               .save(producto)
               .flatMap(p->Mono.just(modelMapper.map(p, ProductoDTO.class)));

    }
    public Mono<ProductoDTO>obtenerPorNombre(String nombre){
        return this.inventarioRepository
                .findByNombreProductoAndTipo(nombre,"producto")
                .flatMap(p->Mono.just(modelMapper.map(p, ProductoDTO.class)));

    }

    public Flux<ProductoDTO>obtenerPorCantidad(int cantidad){
        return this.inventarioRepository
                .findByCantidadProductoAndTipo(cantidad,"producto")
                .flatMap(p->Flux.just(modelMapper.map(p, ProductoDTO.class)));

    }

    public Flux<ProductoDTO>obtenerPorPrecio(Long precio){
        return this.inventarioRepository
                .findByPrecioProductoAndTipo(precio,"producto")
                .flatMap(p->Flux.just(modelMapper.map(p, ProductoDTO.class)));
    }

    public Mono<ProductoDTO>actualizarProducto(String id, ProductoDTO inventarioProducto){
        return this.inventarioRepository.findById(id)
                .flatMap(p->{
                    inventarioProducto.setId(id);
                    return crearProducto(inventarioProducto);
                });
    }
    public Mono<ProductoDTO> venderProducto(String id, int cantidad){
        return this.inventarioRepository.findByIdAndTipo(id,"producto")
                .flatMap(p->{
                    int cantidadNueva=p.getCantidadProducto()-cantidad;
                    p.setCantidadProducto(cantidadNueva);
                    return crearProducto(modelMapper.map(p, ProductoDTO.class));
                });
    }



    public Mono<ProductoDTO>eliminarProducto(String id){
        return this.inventarioRepository.findByIdAndTipo(id,"producto")
                .flatMap(p -> this.inventarioRepository.deleteById(p.getId()).thenReturn(p))
                .flatMap(p->Mono.just(modelMapper.map(p, ProductoDTO.class)));
    }
}
