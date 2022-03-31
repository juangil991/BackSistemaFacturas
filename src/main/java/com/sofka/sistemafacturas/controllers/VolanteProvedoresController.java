package com.sofka.sistemafacturas.controllers;

import com.sofka.sistemafacturas.dtos.VolanteProvedoresDTO;
import com.sofka.sistemafacturas.services.VolanteProvedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
public class VolanteProvedoresController {

    @Autowired
    VolanteProvedoresService volanteProvedoresService;

    @GetMapping("/volantes")
    @ResponseStatus(HttpStatus.OK)
    private Flux<VolanteProvedoresDTO> obtenerVolantes() {
        return volanteProvedoresService.obtenerVolantes();
    }

    @GetMapping("/volantes/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<VolanteProvedoresDTO> obtenerVolantesPorId(@PathVariable("id") String id) {
        return volanteProvedoresService.obtenerVolantesPorId(id);
    }

    @GetMapping("/volantes/documento/{documento}")
    @ResponseStatus(HttpStatus.OK)
    private Flux<VolanteProvedoresDTO> obtenerPorDocumento(@PathVariable("documento") String id) {
        return volanteProvedoresService.obtenerVolantesPorDocumento(id);
    }

    @PostMapping("/volante/crear/save")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<VolanteProvedoresDTO> crearVolante(@RequestBody VolanteProvedoresDTO volanteProvedoresDTO){
        return volanteProvedoresService.crearVolante(volanteProvedoresDTO);
    }

    @PutMapping("/volante/actualizar/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<VolanteProvedoresDTO>actualizarVolante(@PathVariable("id")String id,
                                                        @RequestBody VolanteProvedoresDTO volanteProvedoresDTO){
        return volanteProvedoresService.actualizarVolante(id,volanteProvedoresDTO);
    }

    @DeleteMapping("/volante/eliminar/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<VolanteProvedoresDTO>eliminarVolante(@PathVariable("id") String id){
        return volanteProvedoresService.eliminarVolante(id);
    }
}
