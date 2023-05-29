package br.com.flexpag.payments.service;

import br.com.flexpag.payments.controller.dto.request.CreateUserData;
import br.com.flexpag.payments.model.user.User;

public interface UserServiceContract {

    User createUser(CreateUserData createUserData);

}
