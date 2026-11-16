package com.belmonte.api.service;
import com.belmonte.api.model.Usuario;
import com.belmonte.api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repo;

    public Usuario guardar(Usuario u) {
        return repo.save(u);
    }

    public List<Usuario> listar() {
        return repo.findAll();
    }
    public Usuario login(String correo, String password) {
        java.util.Optional<Usuario> opcional = repo.findByCorreo(correo);
        if (opcional.isPresent() && opcional.get().getPassword().equals(password)) {
            return opcional.get();
        }
        return null;
    }
}