package com.sofka.sistemafacturas.repositories;

import com.sofka.sistemafacturas.dtos.InventarioProductoDTO;
import com.sofka.sistemafacturas.models.InventarioProducto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface InventarioProductoRepository extends ReactiveMongoRepository<InventarioProducto,String> {
    Mono<InventarioProducto>findByNombre(String nombre);
    Mono<InventarioProducto>findByCantidad(int cantidad);
    Mono<InventarioProducto>findByPrecio(Long precio);

}
