package com.belmonte.api.service;
import com.belmonte.api.model.EscanerRegistro;
import com.belmonte.api.repository.EscanerRegistroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EscanerRegistroService {
    private final EscanerRegistroRepository repo;

    public EscanerRegistro guardar(EscanerRegistro e) {
        return repo.save(e);
    }

    public List<EscanerRegistro> listar() {
        return repo.findAll();
    }
}