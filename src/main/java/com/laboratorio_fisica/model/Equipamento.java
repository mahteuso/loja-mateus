package com.laboratorio_fisica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

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

    private LocalDateTime criacao;

    private Boolean ativo;

    private String imagemArquivo;
}
