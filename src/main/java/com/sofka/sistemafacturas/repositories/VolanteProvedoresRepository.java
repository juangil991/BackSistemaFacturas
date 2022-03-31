package com.sofka.sistemafacturas.repositories;

import com.sofka.sistemafacturas.models.VolvanteProvedores;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface VolanteProvedoresRepository extends ReactiveMongoRepository<VolvanteProvedores,String> {
    Flux<VolvanteProvedores> findByDocumento(String documento);
}
