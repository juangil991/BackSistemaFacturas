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

    public Mono<InventarioProductoDTO> agregarProducto(InventarioProductoDTO inventarioProducto) {
        InventarioProducto producto = modelMapper.map(inventarioProducto, InventarioProducto.class);
       return this.inventarioRepository
               .save(producto)
               .flatMap(p->Mono.just(modelMapper.map(p,InventarioProductoDTO.class)));

    }
}
