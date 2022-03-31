package com.sofka.sistemafacturas.controllers;

import com.sofka.sistemafacturas.dtos.ProductoDTO;
import com.sofka.sistemafacturas.services.InventarioProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
public class InventarioProductoController {

    @Autowired
    InventarioProductoService productoService;

    @GetMapping("/productos")
    @ResponseStatus(HttpStatus.OK)
    private Flux<ProductoDTO> obtenerProductos(){
       return productoService.obtenerProductos();
    }

    @GetMapping("/producto/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<ProductoDTO>obtenerPorId(@PathVariable("id") String id){
        return productoService.obtenerProductoPorId(id);
    }
    @GetMapping("/producto/nombre")
    @ResponseStatus(HttpStatus.OK)
    private Mono<ProductoDTO>obtenerPorNombre(@RequestParam String nombre){
        return productoService.obtenerPorNombre(nombre);
    }
    @GetMapping("/Productos/cantidad")
    @ResponseStatus(HttpStatus.OK)
    private Flux<ProductoDTO>obtenerPorCantidad(@RequestParam int cantidad){
        return productoService.obtenerPorCantidad(cantidad);
    }
    @GetMapping("/Productos/precio")
    @ResponseStatus(HttpStatus.OK)
    private Flux<ProductoDTO>optenerPorPrecio(@RequestParam Long precio){
        return productoService.obtenerPorPrecio(precio);
    }

    @PostMapping("/producto/Save")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<ProductoDTO>agregarProductoInventario(@RequestBody ProductoDTO inventarioProducto){
        return productoService.crearProducto(inventarioProducto);
    }
    @PutMapping("/producto/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<ProductoDTO>actualizarProducto(@PathVariable("id") String id,
                                                @RequestBody ProductoDTO inventarioProducto){
        return productoService.actualizarProducto(id,inventarioProducto);
    }

    @DeleteMapping("/producto/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<ProductoDTO>eliminarProducto(@PathVariable("id") String id){
        return productoService.eliminarProducto(id);
    }

}
