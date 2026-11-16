package com.belmonte.api.controller;
import com.belmonte.api.model.Usuario;
import com.belmonte.api.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService service;


    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Usuario> guardar(@Valid @RequestBody Usuario u) {
        return ResponseEntity.ok(service.guardar(u));
    }


    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario credenciales) {
        Usuario usuarioLogueado = service.login(credenciales.getCorreo(), credenciales.getPassword());
        if (usuarioLogueado != null) {
            return ResponseEntity.ok(usuarioLogueado);
        }
        return ResponseEntity.status(org.springframework.http.HttpStatus.UNAUTHORIZED).build();
    }
}