package com.sofka.sistemafacturas.repositories;

import com.sofka.sistemafacturas.models.Inventario;
import org.apache.tomcat.jni.Local;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Repository
public interface InventarioRepository extends ReactiveMongoRepository<Inventario,String> {
    Flux<Inventario>findByTipo(String tipo);
    Mono<Inventario>findByIdAndTipo(String id,String tipo);
    Flux<Inventario>findByFechaAndTipo(LocalDate fecha,String tipo);
    Flux<Inventario>findByDocumentoClienteAndTipo(String documentoCliente,String tipo);
    Mono<Inventario>findByNombreProductoAndTipo(String nombreProducto,String tipo);
    Flux<Inventario>findByCantidadProductoAndTipo(int cantidad,String tipo);
    Flux<Inventario>findByPrecioProductoAndTipo(Long precio,String tipo);
    Flux<Inventario>findByDocumentoProvedorAndTipo(String nombre,String tipo);



}
