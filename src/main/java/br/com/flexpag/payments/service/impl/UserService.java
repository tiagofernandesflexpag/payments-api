package br.com.flexpag.payments.service.impl;

import br.com.flexpag.payments.controller.dto.request.CreateUserData;
import br.com.flexpag.payments.model.user.User;
import br.com.flexpag.payments.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User createUser(CreateUserData createUserData){

        var encryptedPassword = passwordEncoder.encode(createUserData.password());

        var user = userRepository.save(new User(createUserData, encryptedPassword));

        return user;

    }

}
