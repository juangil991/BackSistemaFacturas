package com.sofka.sistemafacturas.controllers;

import com.sofka.sistemafacturas.dtos.FacturaDTO;
import com.sofka.sistemafacturas.services.FacturaService;
import com.sofka.sistemafacturas.services.InventarioProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
public class FacturasController {
    @Autowired
    FacturaService facturaService;

    @GetMapping("/facturas")
    @ResponseStatus(HttpStatus.OK)
    private Flux<FacturaDTO>obtenerFacturas(){
        return facturaService.obtenerFacturas();
    }

    @GetMapping("/factura/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<FacturaDTO>obtenerFacturaPorId(@PathVariable("id") String id){
        return facturaService.obtenerFacturaPorId(id);
    }
    @GetMapping("/factura/fecha/{fecha}")
    @ResponseStatus(HttpStatus.OK)
    private Flux<FacturaDTO>obtenerFacturaPorFecha(@PathVariable("fecha") String fecha){
        return facturaService.obtenerPorFecha(fecha);
    }

    @GetMapping("/factura/cliente/{idCliente}")
    @ResponseStatus(HttpStatus.OK)
    private Flux<FacturaDTO>obtenerPorDocumentoCliente(@PathVariable("idCliente")String idCliente){
        return facturaService.obtenerPorDocumentoCliente(idCliente);
    }

    @PostMapping("/factura/save")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<FacturaDTO> crearFactura(@RequestBody FacturaDTO facturaDTO){
        return facturaService.crearFactura(facturaDTO);
    }

    @PutMapping("factura/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<FacturaDTO> actualizarFactura(@PathVariable("id") String id,@RequestBody FacturaDTO facturaDTO){
        return facturaService.actualizarFactura(id,facturaDTO);
    }

    @DeleteMapping("/factura/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<FacturaDTO>eliminarFactura(@PathVariable("id")String id){
        return facturaService.eliminarFactura(id);
    }


}
