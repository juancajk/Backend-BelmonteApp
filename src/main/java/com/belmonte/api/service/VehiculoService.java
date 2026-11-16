package com.belmonte.api.service;
import com.belmonte.api.model.Vehiculo;
import com.belmonte.api.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoService {
    private final VehiculoRepository repo;

    public Vehiculo guardar(Vehiculo v) {
        return repo.save(v);
    }

    public List<Vehiculo> listar() {
        return repo.findAll();
    }
}