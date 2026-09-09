package com.AEP.urbaniza.controller;

import com.AEP.urbaniza.model.Ocorrencia;
import com.AEP.urbaniza.service.OcorrenciaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
