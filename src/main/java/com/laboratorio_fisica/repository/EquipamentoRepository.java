package com.laboratorio_fisica.repository;

import com.laboratorio_fisica.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
//    @Query("select e from Equipamento e where e.nome like %?1%")
//    List<Equipamento> findByName(String nome);

}
