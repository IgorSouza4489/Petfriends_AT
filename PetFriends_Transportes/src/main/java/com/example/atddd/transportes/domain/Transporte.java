package com.example.atddd.transportes.domain;

import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pedidoId;

    @Embedded
    private Endereco enderecoEntrega;

    private String status;

    @Override
    public String toString() {
        return "Transporte{" +
                "id=" + id +
                ", pedidoId=" + pedidoId +
                ", enderecoEntrega=" + enderecoEntrega +
                ", status='" + status + '\'' +
                '}';
    }

}


