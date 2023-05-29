package br.com.flexpag.payments.controller;

import br.com.flexpag.payments.controller.dto.request.CredentialsData;
import br.com.flexpag.payments.controller.dto.response.TokenResponse;
import br.com.flexpag.payments.model.user.User;
import br.com.flexpag.payments.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired //pedindo ao spring para instanciar
    private AuthenticationManager manager; //Objeto que é responsável pela chamada do método dentro das configs do sec;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Transactional
    public ResponseEntity efetuarLogin(@RequestBody @Valid CredentialsData dados){

        var authToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.password());
        var authentication = manager.authenticate(authToken);

        var tokenJWT  = tokenService.createToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenResponse(tokenJWT));
    }
}
