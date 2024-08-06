package com.laboratorio_fisica.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipamentoDto {

    private Long id;

    @NotBlank(message = " Não pode ser nulo ou vazio")
    @Size(min = 5, message = " Valor mínimo de 5 caracteres")
    private String nome;

    @Size(min = 5, message = " Valor mínimo de 5 caracteres")
    private String descricao;

    @NotBlank(message = " Não pode ser nulo ou vazio")
    @Size(min = 6, max = 6, message = " Valor de 6 caracteres")
    private String patrimonio;

    private String dataCriacao;

    private Boolean ativo;

}

