package com.AEP.urbaniza.service;

import com.AEP.urbaniza.model.Ocorrencia;
import com.AEP.urbaniza.repository.OcorrenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcorrenciaService {

    private final OcorrenciaRepository repository;

    public OcorrenciaService(OcorrenciaRepository repository) {
        this.repository = repository;
    }

    public Ocorrencia criar(Ocorrencia ocorrencia) {
        return repository.save(ocorrencia);
    }

    public List<Ocorrencia> listarTodos() {
        return repository.findAll();
    }

    public Ocorrencia buscarPorId(String id) {
        return repository.findById(id).orElse(null);
    }

}
