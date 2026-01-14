package com.victornext.security.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(
        @NotEmpty(message = "email obrigatorio")
        String email,

        @NotEmpty(message = "senha obrigatoria")
        String password
) {
}
