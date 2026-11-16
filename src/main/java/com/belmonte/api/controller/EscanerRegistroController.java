package com.belmonte.api.controller;
import com.belmonte.api.model.EscanerRegistro;
import com.belmonte.api.service.EscanerRegistroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/escaner")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class EscanerRegistroController {
    private final EscanerRegistroService service;


    @GetMapping
    public List<EscanerRegistro> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<EscanerRegistro> guardar(@Valid @RequestBody EscanerRegistro e) {
        return ResponseEntity.ok(service.guardar(e));
    }


}