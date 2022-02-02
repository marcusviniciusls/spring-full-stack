package br.com.udemy.Spring.FullStack.security;

import br.com.udemy.Spring.FullStack.dto.CredentialsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private JWTUtil jwtUtil;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse
                                                httpServletResponse) throws AuthenticationException{
        try{
            CredentialsDto credentialsDto = new ObjectMapper()
                    .readValue(httpServletRequest.getInputStream(), CredentialsDto.class);
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    credentialsDto.getEmail(), credentialsDto.getPassword(), new ArrayList<>());

            Authentication auth = authenticationManager.authenticate(authToken);
            return auth;
        } catch (IOException ioException){
            throw new RuntimeException(ioException);
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse
                                            httpServletResponse, FilterChain filterChain, Authentication
                                            authentication) throws IOException, ServletException{

        String username = ((UserSS) authentication.getPrincipal()).getUsername();
        String token = jwtUtil.generateToken(username);
        httpServletResponse.addHeader("Authorization","Bearer " + token);
        httpServletResponse.addHeader("access-control-expose-headers", "Authorization");
    }

    private class JwtAuthenticationFailureHandler implements AuthenticationFailureHandler{

        @Override
        public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
            httpServletResponse.setStatus(401);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().append(json());
        }
        private String json(){
            long date = new Date().getTime();
            return "{\"timestamp\": "+ date + ", " +
                    "\"status\": 401, " +
                    "\"error\": \"Não Autorizado\", " +
                    "\"message\": \"Email ou senha inválida\", " +
                    "\"path\": \"/login\"}";
        }
    }
}
