package com.sofka.sistemafacturas.services;

import com.sofka.sistemafacturas.dtos.InventarioProductoDTO;
import com.sofka.sistemafacturas.dtos.VolanteProvedoresDTO;
import com.sofka.sistemafacturas.models.VolvanteProvedores;
import com.sofka.sistemafacturas.repositories.VolanteProvedoresRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VolanteProvedoresService {

    @Autowired
    VolanteProvedoresRepository volanteProvedoresRepository;

    private ModelMapper modelMapper= new ModelMapper();

    public Flux<VolanteProvedoresDTO>obtenerVolantes(){
        return volanteProvedoresRepository.findAll()
                .flatMap(p->Flux.just(modelMapper.map(p,VolanteProvedoresDTO.class)));
    }

    public Mono<VolanteProvedoresDTO>obtenerVolantesPorId(String id){
        return volanteProvedoresRepository.findById(id)
                .flatMap(p->Mono.just(modelMapper.map(p,VolanteProvedoresDTO.class)));
    }

    public Flux<VolanteProvedoresDTO>obtenerVolantesPorDocumento(String documento){
        return volanteProvedoresRepository.findByDocumento(documento)
                .flatMap(p->Flux.just(modelMapper.map(p,VolanteProvedoresDTO.class)));
    }

    public Mono<VolanteProvedoresDTO>crearVolante(VolanteProvedoresDTO volanteProvedoresDTO){
        VolvanteProvedores volvanteProvedores= modelMapper.map(volanteProvedoresDTO,VolvanteProvedores.class);
        return this.volanteProvedoresRepository
                .save(volvanteProvedores)
                .flatMap(p->Mono.just(modelMapper.map(p,VolanteProvedoresDTO.class)));
    }

    public Mono<VolanteProvedoresDTO>actualizarVolante(String id, VolanteProvedoresDTO volanteProvedoresDTO){
        return this.volanteProvedoresRepository.findById(id)
                .flatMap(p->{
                    volanteProvedoresDTO.setId(id);
                    return crearVolante(volanteProvedoresDTO);
                });
    }

    public Mono<VolanteProvedoresDTO>eliminarVolante(String id){
        return volanteProvedoresRepository.findById(id)
                .flatMap(p -> this.volanteProvedoresRepository.deleteById(p.getId()).thenReturn(p))
                .flatMap(p->Mono.just(modelMapper.map(p,VolanteProvedoresDTO.class)));
    }


}
