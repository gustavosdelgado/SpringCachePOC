package gustavosdelgado.com.github.springcachepoc.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import gustavosdelgado.com.github.springcachepoc.service.Token;
import gustavosdelgado.com.github.springcachepoc.service.TokenService;

@RestController
public class TokenController {

    @Autowired
    private TokenService service;

    @GetMapping("token")
    public ResponseEntity<Token> getToken() {

        Token token = service.getToken();

        if (token == null || LocalDateTime.now().isAfter(token.getCrationDateTime().plusSeconds(30))) {
            token = service.updateToken();
        }

        return new ResponseEntity<>(token, HttpStatus.ACCEPTED);
    }

}
