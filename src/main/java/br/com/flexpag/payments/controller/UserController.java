package br.com.flexpag.payments.controller;

import br.com.flexpag.payments.controller.dto.request.CreateUserData;
import br.com.flexpag.payments.controller.dto.response.CreateUserResponse;
import br.com.flexpag.payments.service.impl.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/create")
    @Transactional
    public ResponseEntity createUser(@RequestBody @Valid CreateUserData createUserData){

        System.out.println(createUserData.userRole());

        var user = userService.createUser(createUserData);

        var userResponse = new CreateUserResponse(user);

        return ResponseEntity.ok(userResponse);

    }

}
