package com.laboratorio_fisica.dto;

import com.laboratorio_fisica.model.UserRole;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @NotBlank(message = " Não pode ser nulo ou vazio")
    @Size(min = 5, message = " Deve ter mínimo de 5 caracteres")
    private String login;

    @NotBlank(message = " Não pode ser nulo ou vazio")
    @Size(min = 5, message = " Deve ter mínimo de 6 caracteres")
    private String password;

    private UserRole role;
}
