package com.example.PetFriends_Almoxarifados.almoxarifado.infra.repository;

import com.example.PetFriends_Almoxarifados.almoxarifado.domain.Armazenamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmazenamentoRepository extends JpaRepository<Armazenamento, Long> {
}
