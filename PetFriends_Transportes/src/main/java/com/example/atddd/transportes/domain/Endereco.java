package com.example.atddd.transportes.domain;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String log;
    private String nm_cid;
    private String uf;
    private String cep;
}

