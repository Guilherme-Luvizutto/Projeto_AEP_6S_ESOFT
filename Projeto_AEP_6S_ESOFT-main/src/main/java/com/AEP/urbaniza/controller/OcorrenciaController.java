package com.AEP.urbaniza.controller;

import com.AEP.urbaniza.model.Ocorrencia;
import com.AEP.urbaniza.service.OcorrenciaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OcorrenciaController {

    private final OcorrenciaService service;

    public OcorrenciaController(OcorrenciaService service) {
        this.service = service;
    }

    @PostMapping("/ocorrencias")
    public Ocorrencia criar(@RequestBody Ocorrencia ocorrencia){
        return service.criar(ocorrencia);
    }

    @GetMapping("/ocorrencias")
    public List<Ocorrencia> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/ocorrencias/{id}")
    public Ocorrencia buscarPorId(@PathVariable String id){
        return service.buscarPorId(id);
    }

    @PutMapping("/ocorrencias/{id}")
    public Ocorrencia atualizar(@PathVariable String id, @RequestBody Ocorrencia ocorrencia){
        return service.atualizar(id, ocorrencia);
    }

    @DeleteMapping("/ocorrencias/{id}")
    public void deletar(@PathVariable String id) {
        service.deletar(id);
    }
}
