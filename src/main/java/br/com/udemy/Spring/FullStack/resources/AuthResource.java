package br.com.udemy.Spring.FullStack.resources;

import br.com.udemy.Spring.FullStack.form.atualizar.EmailDto;
import br.com.udemy.Spring.FullStack.security.JWTUtil;
import br.com.udemy.Spring.FullStack.security.UserSS;
import br.com.udemy.Spring.FullStack.services.AuthService;
import br.com.udemy.Spring.FullStack.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthResource {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService authService;

    @PostMapping(value="/refresh_token")
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        UserSS user = UserService.authenticated();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("access-control-expose-headers", "Authorization");
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value="/forgot")
    public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDto emailDto) {
        authService.sendNewPassword(emailDto.getEmail());
        return ResponseEntity.noContent().build();
    }
}
