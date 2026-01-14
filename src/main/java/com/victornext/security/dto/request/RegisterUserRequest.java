package com.victornext.security.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record RegisterUserRequest(
        @NotEmpty(message = "nome obrigatorio")
        String name,
        @NotEmpty(message = "email obrigatorio")
        String email,
        @NotEmpty(message = "senha obrigatoria")
        String pwassword
) {
}
