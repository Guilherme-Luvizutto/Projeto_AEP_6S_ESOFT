package com.AEP.urbaniza.repository;

import com.AEP.urbaniza.model.Ocorrencia;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OcorrenciaRepository extends MongoRepository<Ocorrencia, String> {
}
