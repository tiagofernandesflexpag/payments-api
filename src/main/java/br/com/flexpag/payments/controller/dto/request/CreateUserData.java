package br.com.flexpag.payments.controller.dto.request;

import br.com.flexpag.payments.model.user.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserData(
        @NotBlank
        String email,
        @NotBlank
        String password,
        @NotNull
        UserRole userRole
) {}
