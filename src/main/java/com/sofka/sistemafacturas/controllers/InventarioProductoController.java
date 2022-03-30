package com.sofka.sistemafacturas.controllers;

import com.sofka.sistemafacturas.dtos.InventarioProductoDTO;
import com.sofka.sistemafacturas.services.InventarioProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class InventarioProductoController {

    @Autowired
    InventarioProductoService productoService;

    @GetMapping("/Productos")
    @ResponseStatus(HttpStatus.OK)
    private Flux<InventarioProductoDTO> obtenerProductos(){
       return productoService.obtenerProductos();
    }

    @PostMapping("/Save")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<InventarioProductoDTO>agregarProductoInventario(@RequestBody InventarioProductoDTO inventarioProducto){
        return productoService.agregarProducto(inventarioProducto);
    }

}
