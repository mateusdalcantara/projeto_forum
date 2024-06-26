package github.com.mateusdalcantara.projeto_forum.controllers;

import github.com.mateusdalcantara.projeto_forum.infra.security.AuthDto;
import github.com.mateusdalcantara.projeto_forum.infra.security.RequestRefreshDto;
import github.com.mateusdalcantara.projeto_forum.infra.security.TokenResponseDto;
import github.com.mateusdalcantara.projeto_forum.infra.security.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public TokenResponseDto auth(@RequestBody AuthDto authDto) {

        var usuarioAutenticationToken = new UsernamePasswordAuthenticationToken(authDto.login(), authDto.senha());

        authenticationManager.authenticate(usuarioAutenticationToken);

        return autenticacaoService.obterToken(authDto);
    }

    @PostMapping("/refresh-token")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponseDto authRefreshToken(@RequestBody RequestRefreshDto requestRefreshDto) {
        return autenticacaoService.obterRefreshToken(requestRefreshDto.refreshToken());
    }
}