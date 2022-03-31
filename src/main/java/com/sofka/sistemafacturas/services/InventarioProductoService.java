package com.sofka.sistemafacturas.services;

import com.sofka.sistemafacturas.dtos.InventarioProductoDTO;
import com.sofka.sistemafacturas.models.InventarioProducto;
import com.sofka.sistemafacturas.repositories.InventarioProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InventarioProductoService {

    @Autowired
    InventarioProductoRepository inventarioRepository;

    ModelMapper modelMapper= new ModelMapper();

    public Flux<InventarioProductoDTO> obtenerProductos(){
        return inventarioRepository.findAll()
                .flatMap(p->Flux.just(modelMapper.map(p,InventarioProductoDTO.class)));
    }

    public Mono<InventarioProductoDTO>obtenerProductoPorId(String id){
        return inventarioRepository.findById(id)
                .flatMap(p->Mono.just(modelMapper.map(p,InventarioProductoDTO.class)));
    }

    public Mono<InventarioProductoDTO> agregarProducto(InventarioProductoDTO inventarioProducto) {
        InventarioProducto producto = modelMapper.map(inventarioProducto, InventarioProducto.class);
       return this.inventarioRepository
               .save(producto)
               .flatMap(p->Mono.just(modelMapper.map(p,InventarioProductoDTO.class)));

    }
    public Mono<InventarioProductoDTO>obtenerPorNombre(String nombre){
        return this.inventarioRepository
                .findByNombre(nombre)
                .flatMap(p->Mono.just(modelMapper.map(p,InventarioProductoDTO.class)));

    }

    public Flux<InventarioProductoDTO>obtenerPorCantidad(int cantidad){
        return this.inventarioRepository
                .findByCantidad(cantidad)
                .flatMap(p->Flux.just(modelMapper.map(p,InventarioProductoDTO.class)));

    }

    public Flux<InventarioProductoDTO>obtenerPorPrecio(Long precio){
        return this.inventarioRepository
                .findByPrecio(precio)
                .flatMap(p->Flux.just(modelMapper.map(p,InventarioProductoDTO.class)));
    }

    public Mono<InventarioProductoDTO>actualizarProducto(String id,InventarioProductoDTO inventarioProducto){
        return this.inventarioRepository.findById(id)
                .flatMap(p->{
                    inventarioProducto.setId(id);
                    return agregarProducto(inventarioProducto);
                });
    }

    public Mono<InventarioProductoDTO>eliminarProducto(String id){
        return this.inventarioRepository.findById(id)
                .flatMap(p -> this.inventarioRepository.deleteById(p.getId()).thenReturn(p))
                .flatMap(p->Mono.just(modelMapper.map(p,InventarioProductoDTO.class)));
    }

}
