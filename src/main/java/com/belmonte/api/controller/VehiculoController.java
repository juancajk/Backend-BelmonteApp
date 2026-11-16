package com.belmonte.api.controller;
import com.belmonte.api.model.Vehiculo;
import com.belmonte.api.service.VehiculoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class VehiculoController {
    private final VehiculoService service;

    @GetMapping
    public List<Vehiculo> listar() {
        return service.listar();
    }


    @PostMapping
    public ResponseEntity<Vehiculo> guardar(@Valid @RequestBody Vehiculo v) {
        return ResponseEntity.ok(service.guardar(v));
    }

}