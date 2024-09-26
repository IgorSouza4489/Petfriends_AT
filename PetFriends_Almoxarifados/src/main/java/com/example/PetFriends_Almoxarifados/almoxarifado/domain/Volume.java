package com.example.PetFriends_Almoxarifados.almoxarifado.domain;

import java.util.Objects;

public class Volume {
    private double capacidade;
    private String unidade;

    public Volume(double capacidade, String unidade) {
        this.capacidade = capacidade;
        this.unidade = unidade;
    }
    public double getCapacidade() {
        return capacidade;
    }
    public String getUnidade() {
        return unidade;
    }


}
