package br.com.flexpag.payments.controller.dto.response;

import br.com.flexpag.payments.model.user.enums.UserRole;
import br.com.flexpag.payments.model.user.User;

public record CreateUserResponse(Long userId, String email, UserRole role) {

    public CreateUserResponse(User user){
        this(user.getId(), user.getEmail(), user.getRole());
    }

}
