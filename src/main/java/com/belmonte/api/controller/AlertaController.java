package com.belmonte.api.controller;
import com.belmonte.api.model.Alerta;
import com.belmonte.api.service.AlertaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alertas")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AlertaController {
    private final AlertaService service;

    @GetMapping
    public List<Alerta> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Alerta> guardar(@Valid @RequestBody Alerta a) {
        return ResponseEntity.ok(service.guardar(a));
    }


}