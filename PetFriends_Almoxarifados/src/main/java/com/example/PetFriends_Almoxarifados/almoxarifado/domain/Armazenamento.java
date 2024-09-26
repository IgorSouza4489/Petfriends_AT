package com.example.PetFriends_Almoxarifados.almoxarifado.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "armazenamento")
@Data
@NoArgsConstructor
public class Armazenamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "armazenamento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Produto> produtos;

    @Embedded
    private Volume volume; //value object da classe armazenamento
}
