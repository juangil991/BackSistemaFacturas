package com.sofka.sistemafacturas.repositories;

import com.sofka.sistemafacturas.models.Factura;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@Repository
public interface FacturaRepository extends ReactiveMongoRepository<Factura,String> {
    Flux<Factura> findByFecha(LocalDate fecha);
    Flux<Factura> findByDocumentoCliente(String documentoCliente);

}
