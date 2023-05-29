package br.com.flexpag.payments.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthServiceContract {

    UserDetails loadUserByUsername(String email);

}
