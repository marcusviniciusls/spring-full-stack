package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.Client;
import br.com.udemy.Spring.FullStack.repositorys.ClientRepository;
import br.com.udemy.Spring.FullStack.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Client> optionalClient = clientRepository.findByClientPerEmail(email);
        if (optionalClient.isEmpty()){
            throw new UsernameNotFoundException("Client Not Found Exception");
        }
        Client client = optionalClient.get();
        return new UserSS(client.getUuid(),client.getEmail(),client.getPassword(), client.getProfile());
    }
}
