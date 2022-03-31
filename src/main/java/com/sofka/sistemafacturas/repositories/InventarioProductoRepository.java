package com.sofka.sistemafacturas.repositories;

import com.sofka.sistemafacturas.dtos.InventarioProductoDTO;
import com.sofka.sistemafacturas.models.InventarioProducto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface InventarioProductoRepository extends ReactiveMongoRepository<InventarioProducto,String> {
    Mono<InventarioProducto> findByNombre(String nombre);
    Flux<InventarioProducto>findByCantidad(int cantidad);
    Flux<InventarioProducto>findByPrecio(Long precio);

}
