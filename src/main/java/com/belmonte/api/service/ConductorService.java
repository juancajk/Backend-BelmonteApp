package com.belmonte.api.service;
import com.belmonte.api.model.Conductor;
import com.belmonte.api.repository.ConductorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConductorService {
    private final ConductorRepository repo;

    public Conductor guardar(Conductor c) {
        return repo.save(c);
    }

    public List<Conductor> listar() {
        return repo.findAll();
    }
}