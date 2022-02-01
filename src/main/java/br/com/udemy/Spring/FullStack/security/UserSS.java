package br.com.udemy.Spring.FullStack.security;

import br.com.udemy.Spring.FullStack.domain.enums.Profile;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserSS implements UserDetails {

    // Atributos
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID uuid;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    // Construtores
    public UserSS(){}

    public UserSS(UUID uuid, String email, String password, Set<Profile> setProfiles) {
        this.uuid = uuid;
        this.email = email;
        this.password = password;
        this.authorities = setProfiles.stream().map(x -> new SimpleGrantedAuthority(x.getDescription())).collect(Collectors.toList());
    }

    // Método Gets
    public UUID getId() {
        return uuid;
    }

    // Métodos da implementação da interface
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean hasRole(Profile profile){
        return getAuthorities().contains(new SimpleGrantedAuthority(profile.getDescription()));
    }
}
