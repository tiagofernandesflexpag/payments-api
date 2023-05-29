package br.com.flexpag.payments.service;

import br.com.flexpag.payments.model.user.User;

public interface TokenServiceContract {

    String gerarToken(User user);

    String getSubject(String tokenJWT);

}
