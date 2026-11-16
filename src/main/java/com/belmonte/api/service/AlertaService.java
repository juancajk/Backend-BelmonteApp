package com.belmonte.api.service;
import com.belmonte.api.model.Alerta;
import com.belmonte.api.repository.AlertaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertaService {
    private final AlertaRepository repo;

    public Alerta guardar(Alerta a) {
        return repo.save(a);
    }

    public List<Alerta> listar() {
        return repo.findAll();
    }
}