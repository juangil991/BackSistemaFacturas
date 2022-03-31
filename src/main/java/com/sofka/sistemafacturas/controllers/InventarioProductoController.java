package com.sofka.sistemafacturas.controllers;

import com.sofka.sistemafacturas.dtos.InventarioProductoDTO;
import com.sofka.sistemafacturas.services.InventarioProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.pattern.PathPattern;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
public class InventarioProductoController {

    @Autowired
    InventarioProductoService productoService;

    @GetMapping("/productos")
    @ResponseStatus(HttpStatus.OK)
    private Flux<InventarioProductoDTO> obtenerProductos(){
       return productoService.obtenerProductos();
    }

    @GetMapping("/producto/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<InventarioProductoDTO>obtenerPorId(@PathVariable("id") String id){
        return productoService.obtenerProductoPorId(id);
    }
    @GetMapping("/producto/nombre")
    @ResponseStatus(HttpStatus.OK)
    private Mono<InventarioProductoDTO>obtenerPorNombre(@RequestParam String nombre){
        return productoService.obtenerPorNombre(nombre);
    }
    @GetMapping("/Productos/cantidad")
    @ResponseStatus(HttpStatus.OK)
    private Flux<InventarioProductoDTO>obtenerPorCantidad(@RequestParam int cantidad){
        return productoService.obtenerPorCantidad(cantidad);
    }
    @GetMapping("/Productos/precio")
    @ResponseStatus(HttpStatus.OK)
    private Flux<InventarioProductoDTO>optenerPorPrecio(@RequestParam Long precio){
        return productoService.obtenerPorPrecio(precio);
    }

    @PostMapping("/producto/Save")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<InventarioProductoDTO>agregarProductoInventario(@RequestBody InventarioProductoDTO inventarioProducto){
        return productoService.agregarProducto(inventarioProducto);
    }
    @PutMapping("/producto/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<InventarioProductoDTO>actualizarProducto(@PathVariable("id") String id,
                                                          @RequestBody InventarioProductoDTO inventarioProducto){
        return productoService.actualizarProducto(id,inventarioProducto);
    }

    @DeleteMapping("/producto/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<InventarioProductoDTO>eliminarProducto(@PathVariable("id") String id){
        return productoService.eliminarProducto(id);
    }

}
