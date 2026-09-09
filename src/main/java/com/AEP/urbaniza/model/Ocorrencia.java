package com.AEP.urbaniza.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ocorrencias")
public class Ocorrencia {

    @Id
    private String id;
    private String descricao;
    private String categoria;
    private String status;

    public void setId(String id) {
        this.id = id;
    }
}
