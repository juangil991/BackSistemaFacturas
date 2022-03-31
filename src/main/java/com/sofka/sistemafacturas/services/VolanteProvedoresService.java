package com.sofka.sistemafacturas.services;

import com.sofka.sistemafacturas.dtos.VolanteProvedoresDTO;
import com.sofka.sistemafacturas.models.Inventario;
import com.sofka.sistemafacturas.repositories.InventarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VolanteProvedoresService {

    @Autowired
    InventarioRepository inventarioRepository;

    private ModelMapper modelMapper= new ModelMapper();

    public Flux<VolanteProvedoresDTO>obtenerVolantes(){
        return inventarioRepository.findByTipo("volante")
                .flatMap(p->Flux.just(modelMapper.map(p,VolanteProvedoresDTO.class)));
    }

    public Mono<VolanteProvedoresDTO>obtenerVolantesPorId(String id){
        return inventarioRepository.findByIdAndTipo(id,"volante")
                .flatMap(p->Mono.just(modelMapper.map(p,VolanteProvedoresDTO.class)));
    }

    public Flux<VolanteProvedoresDTO>obtenerVolantesPorDocumento(String documento){
        return inventarioRepository.findByDocumentoProvedorAndTipo(documento,"volante")
                .flatMap(p->Flux.just(modelMapper.map(p,VolanteProvedoresDTO.class)));
    }

    public Mono<VolanteProvedoresDTO>crearVolante(VolanteProvedoresDTO volanteProvedoresDTO){
        volanteProvedoresDTO.setTipo("volante");
        Inventario volvanteProvedores= modelMapper.map(volanteProvedoresDTO,Inventario.class);
        return this.inventarioRepository
                .save(volvanteProvedores)
                .flatMap(p->Mono.just(modelMapper.map(p,VolanteProvedoresDTO.class)));
    }

    public Mono<VolanteProvedoresDTO>actualizarVolante(String id, VolanteProvedoresDTO volanteProvedoresDTO){
        return this.inventarioRepository.findByIdAndTipo(id,"volante")
                .flatMap(p->{
                    volanteProvedoresDTO.setId(id);
                    return crearVolante(volanteProvedoresDTO);
                });
    }

    public Mono<VolanteProvedoresDTO>eliminarVolante(String id){
        return inventarioRepository.findByIdAndTipo(id,"volante")
                .flatMap(p -> this.inventarioRepository.deleteById(p.getId()).thenReturn(p))
                .flatMap(p->Mono.just(modelMapper.map(p,VolanteProvedoresDTO.class)));
    }


}
