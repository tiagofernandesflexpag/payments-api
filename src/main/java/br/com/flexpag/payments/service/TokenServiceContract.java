package br.com.flexpag.payments.service;

import br.com.flexpag.payments.model.user.User;

public interface TokenServiceContract {

    String createToken(User user);

    String getSubject(String tokenJWT);

}
