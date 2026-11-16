package com.belmonte.api.controller;
import com.belmonte.api.model.Conductor;
import com.belmonte.api.service.ConductorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/conductores")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ConductorController {
    private final ConductorService service;

    @PostMapping
    public ResponseEntity<Conductor> guardar(@Valid @RequestBody Conductor c) {
        return ResponseEntity.ok(service.guardar(c));
    }

    @GetMapping
    public List<Conductor> listar() {
        return service.listar();
    }
}