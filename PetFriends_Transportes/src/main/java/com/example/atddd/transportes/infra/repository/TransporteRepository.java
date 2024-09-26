package com.example.atddd.transportes.infra.repository;

import com.example.atddd.transportes.domain.Transporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransporteRepository extends JpaRepository<Transporte, Long> {
}

