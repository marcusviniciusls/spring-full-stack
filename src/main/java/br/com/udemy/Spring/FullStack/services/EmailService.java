package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido order);
    void sendEmail(SimpleMailMessage simpleEmailMessage);
}
