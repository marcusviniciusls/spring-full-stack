package br.com.udemy.Spring.FullStack.config;

import br.com.udemy.Spring.FullStack.security.JWTAuthenticationFilter;
import br.com.udemy.Spring.FullStack.security.JWTAuthorizationFilter;
import br.com.udemy.Spring.FullStack.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Environment environment;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    private static final String[] PUBLIC_MATCHERS = {
            "/h2-console/**"
    };

    private static final String[] PUBLIC_MATCHERS_GET = {
            "/product/**",
            "/category/**"
    };

    private static final String[] PUBLIC_MATCHERS_POST = {
            "/client/",
            "/auth/forgot/**"
    };

    @Override
    protected void configure (HttpSecurity httpSecurity) throws Exception{
        if (Arrays.asList(environment.getActiveProfiles()).contains("test")){
            httpSecurity.headers().frameOptions().disable();
        }
        httpSecurity.cors().and().csrf().disable();
        httpSecurity.authorizeRequests().
                antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll().
                antMatchers(PUBLIC_MATCHERS).permitAll().
                antMatchers(HttpMethod.POST,PUBLIC_MATCHERS_POST).permitAll().
                anyRequest().authenticated();
        httpSecurity.addFilter(new JWTAuthenticationFilter(authenticationManager(),jwtUtil));
        httpSecurity.addFilter(new JWTAuthorizationFilter(authenticationManager(),jwtUtil, userDetailsService));
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure (AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return urlBasedCorsConfigurationSource;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
