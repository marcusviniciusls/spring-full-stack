package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.Client;
import br.com.udemy.Spring.FullStack.exception.ResourceNotFoundException;
import br.com.udemy.Spring.FullStack.repositorys.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EmailService emailService;

    private Random random = new Random();

    public void sendNewPassword(String email){
        Client client = clientRepository.findByEmail(email);
        if (client == null){
            throw new ResourceNotFoundException("Client Not Found Exception");
        }
        String newPass = newPassowrd();
        client.setPassword(bCryptPasswordEncoder.encode(newPass));
        clientRepository.save(client);
        emailService.sendNewPasswordEmail(client,newPass);
    }

    private String newPassowrd() {
        char[] vectorChar = new char[10];
        for (int i = 0; i < 10; i++){
            vectorChar[i] = randomChar();
        }
        return new String(vectorChar);
    }

    private char randomChar() {
        int opt = random.nextInt(3);
        if (opt == 0){
            return (char) (random.nextInt(10) + 48);
        } else if (opt == 1){
            return (char) (random.nextInt(26) + 65);
        } else {
            return (char) (random.nextInt(26) + 97);
        }
    }


}
