package com.belmonte.api.controller;

import com.belmonte.api.model.Traslado;
import com.belmonte.api.service.TrasladoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/traslados")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class TrasladoController {
    private final TrasladoService service;

    @GetMapping
    public List<Traslado> listar() {
        return service.listarTodos();
    }

    @GetMapping("/estado/{estado}")
    public List<Traslado> listarPorEstado(@PathVariable String estado) {
        return service.listarPorEstado(estado);
    }

    @PostMapping
    public ResponseEntity<Traslado> guardar(@Valid @RequestBody Traslado t) {
        return ResponseEntity.ok(service.guardar(t));
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Traslado> actualizarEstado(@PathVariable Long id, @RequestParam String estado) {
        Traslado t = service.actualizarEstado(id, estado);
        return t != null ? ResponseEntity.ok(t) : ResponseEntity.notFound().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Traslado> actualizarViajeCompleto(@PathVariable Long id, @Valid @RequestBody Traslado viajeModificado) {
        Traslado t = service.actualizarViaje(id, viajeModificado);
        return t != null ? ResponseEntity.ok(t) : ResponseEntity.notFound().build();
    }
}
