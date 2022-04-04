package com.sofka.sistemafacturas.services;

import com.sofka.sistemafacturas.dtos.FacturaDTO;
import com.sofka.sistemafacturas.dtos.ProductoDTO;
import com.sofka.sistemafacturas.models.Inventario;
import com.sofka.sistemafacturas.repositories.InventarioRepository;
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
    InventarioRepository inventarioRepository;


   private ModelMapper modelMapper= new ModelMapper();

    public Mono<FacturaDTO> crearFactura(FacturaDTO facturaDTO){
        facturaDTO.setTipo("factura");
        Inventario factura= modelMapper.map(facturaDTO,Inventario.class);
        return this.inventarioRepository.save(factura)
                .flatMap(p->Mono.just(modelMapper.map(p,FacturaDTO.class)));
    }

    public Flux<FacturaDTO>obtenerFacturas(){
        return this.inventarioRepository.findByTipo("factura")
                .flatMap(p->Flux.just(modelMapper.map(p,FacturaDTO.class)));
    }

    public Mono<FacturaDTO>obtenerFacturaPorId(String id){
        return this.inventarioRepository.findByIdAndTipo(id,"factura")
                .flatMap(p->Mono.just(modelMapper.map(p,FacturaDTO.class)));
    }

    public Flux<FacturaDTO>obtenerPorFecha(String fecha){
        return this.inventarioRepository
                .findByFechaAndTipo( LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy-MM-dd")),"factura")
                .flatMap(p->Flux.just(modelMapper.map(p,FacturaDTO.class)));
    }

    public Flux<FacturaDTO>obtenerPorDocumentoCliente(String documentoCliente){
        return this.inventarioRepository.findByDocumentoClienteAndTipo(documentoCliente,"factura")
                .flatMap(p->Flux.just(modelMapper.map(p,FacturaDTO.class)));
    }

    public Mono<FacturaDTO>eliminarFactura(String id){
        return this.inventarioRepository.findByIdAndTipo(id,"factura")
                .flatMap(p -> this.inventarioRepository.deleteById(p.getId()).thenReturn(p))
                .flatMap(p->Mono.just(modelMapper.map(p,FacturaDTO.class)));
    }

    public Mono<FacturaDTO>actualizarFactura(String id, FacturaDTO facturaDTO){
        return this.inventarioRepository.findByIdAndTipo(id,"factura")
                .flatMap(p->{
                    facturaDTO.setId(id);
                    return crearFactura(facturaDTO);
                });
    }

}
