package com.sofka.sistemafacturas.services;

import com.sofka.sistemafacturas.dtos.FacturaDTO;
import com.sofka.sistemafacturas.dtos.InventarioProductoDTO;
import com.sofka.sistemafacturas.models.Factura;
import com.sofka.sistemafacturas.repositories.FacturaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class FacturaService {
    @Autowired
    FacturaRepository facturaRepository;

   private ModelMapper modelMapper= new ModelMapper();

    public Mono<FacturaDTO> crearFactura(FacturaDTO facturaDTO){
        Factura factura= modelMapper.map(facturaDTO,Factura.class);
        return this.facturaRepository.save(factura)
                .flatMap(p->Mono.just(modelMapper.map(p,FacturaDTO.class)));
    }

    public Flux<FacturaDTO>obtenerFacturas(){
        return this.facturaRepository.findAll()
                .flatMap(p->Flux.just(modelMapper.map(p,FacturaDTO.class)));
    }

    public Mono<FacturaDTO>obtenerFacturaPorId(String id){
        return this.facturaRepository.findById(id)
                .flatMap(p->Mono.just(modelMapper.map(p,FacturaDTO.class)));
    }

    public Flux<FacturaDTO>obtenerPorFecha(String fecha){
        return this.facturaRepository.findByFecha( LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                .flatMap(p->Flux.just(modelMapper.map(p,FacturaDTO.class)));
    }

    public Flux<FacturaDTO>obtenerPorDocumentoCliente(String documentoCliente){
        return this.facturaRepository.findByDocumentoCliente(documentoCliente)
                .flatMap(p->Flux.just(modelMapper.map(p,FacturaDTO.class)));
    }

    public Mono<FacturaDTO>eliminarFactura(String id){
        return this.facturaRepository.findById(id)
                .flatMap(p -> this.facturaRepository.deleteById(p.getId()).thenReturn(p))
                .flatMap(p->Mono.just(modelMapper.map(p,FacturaDTO.class)));
    }

    public Mono<FacturaDTO>actualizarFactura(String id, FacturaDTO facturaDTO){
        return this.facturaRepository.findById(id)
                .flatMap(p->{
                    facturaDTO.setId(id);
                    return crearFactura(facturaDTO);
                });
    }
}
