package br.com.flexpag.payments.controller;

import br.com.flexpag.payments.controller.dto.request.AuthData;
import br.com.flexpag.payments.controller.dto.response.TokenReponse;
import br.com.flexpag.payments.model.user.User;
import br.com.flexpag.payments.service.impl.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity auth(@RequestBody @Valid AuthData authData){

        var authToken = new UsernamePasswordAuthenticationToken(authData.email(), authData.password());
        var authentication = manager.authenticate(authToken);

        var tokenJWT  = tokenService.gerarToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenReponse(tokenJWT));
    }
}
