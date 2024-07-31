package com.loja_mateus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    private Long id;

    private String nome;

    private String sobrenome;

    private String cpf;

    private String telefone;

    private String email;

}
