package com.laboratorio_fisica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "equipamentos")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Equipamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private String patrimonio;

    @Column(name = "data_de_criacao")
    private String dataCriacao;

    private Boolean ativo;

}
