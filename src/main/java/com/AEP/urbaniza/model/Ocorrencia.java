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

    public String getId() { return id; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCategoria() { return categoria; }

    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}
