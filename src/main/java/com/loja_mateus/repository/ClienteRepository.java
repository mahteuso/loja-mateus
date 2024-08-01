package com.loja_mateus.repository;

import com.loja_mateus.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Equipamento, Long> {
}
